package com.vpclub.activitycheckinfo.controller;

import com.vpclub.util.RedisLock;
import com.vpclub.util.RedisUtils;
import cn.vpclub.moses.utils.common.DateUtil;
import cn.vpclub.moses.utils.common.JsonUtil;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.vpclub.activitybaseinfo.entity.ActivityBaseInfoEntity;
import com.vpclub.activitycheckinfo.domain.BaoMingDto;
import com.vpclub.activitycheckinfo.entity.ActivityJoinInfoEntity;
import com.vpclub.activitycheckinfo.entity.ActivityMemberInfoEntity;
import com.vpclub.activitycheckinfo.service.ActivityBaseInfoService;
import com.vpclub.activitycheckinfo.service.ActivityJoinInfoService;
import com.vpclub.activitycheckinfo.service.ActivityMemberInfoService;
import com.vpclub.admin.domain.OrgDTO;
import com.vpclub.admin.domain.UserParam;
import com.vpclub.admin.entity.SysUserInfo;
import com.vpclub.admin.service.ISysUserInfoService;
import com.vpclub.admin.utils.R;
//import com.vpclub.util.WechatService;
//import com.vpclub.util.WechatReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动人员报名签到签退表#20161213#
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 09:46:53
 */
@RestController
@CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("app/activityjoininfo")
@Slf4j
public class ActivityJoinInfoController {
    @Autowired
    private ActivityJoinInfoService activityJoinInfoService;
    @Autowired
    private ActivityBaseInfoService activityBaseInfoService;
    @Autowired
    private ActivityMemberInfoService activityMemberInfoService;
    @Autowired
    private ISysUserInfoService isysUserInfoService;


    @Autowired
    private ISysUserInfoService userInfoService;


    @Autowired
    private RedisLock redisLock;
//    @Autowired
//    private RedisUtils redisUtils;

//    @Autowired
//    private RedissonClient redissonClient;

    /**
     * 获取用户机构
     *
     * @param userParam
     */
    @PostMapping("/getUserOrg")
    public R getUserOrg(@RequestBody UserParam userParam) {
        List<OrgDTO> orgDTOList = userInfoService.queryByUserIdAndSchoolId(userParam);
        if (CollectionUtils.isEmpty(orgDTOList)) {
            return R.error("不存在的数据");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("org", orgDTOList);
        return R.ok(map);
    }

    /**
     * 活动报名
     */
    @SuppressWarnings("unused")
    @RequestMapping("/eventRegistration")
    public R eventRegistration(@RequestBody BaoMingDto baoMingDto) {
        // 加锁，超时时间5秒
        long time = System.currentTimeMillis() + 1000 * 5;
//
        boolean isLock;
//        RLock rlock = redissonClient.getLock(baoMingDto.getActivityId() + "");
//        rlock.lock(20, TimeUnit.SECONDS);
        try {
            isLock = redisLock.lock(String.valueOf(baoMingDto.getActivityId()) + baoMingDto.getUserId(), String.valueOf(time));
            log.info("给活动id[{}]上锁", baoMingDto.getActivityId());
            if (!isLock) {
                log.info("locked fail");
                return R.error("人太多了，请稍后再试");
            }
            String key = "activity:" + baoMingDto.getActivityId() + ":" + baoMingDto.getUserId();
//            if (redisUtils.get(key, 60 *30) !=null) {
//                log.info("userId = {}，报名[activityId = {}]$$$$get redis baoming $$$$$${}", baoMingDto.getUserId(), baoMingDto.getActivityId(), redisUtils.get(key, 60 * 30));
//                return R.error("您已参与过报名");
//            }
            Integer count = activityJoinInfoService.isenlist(baoMingDto.getActivityId(), baoMingDto.getUserId());
            log.info("userId = {}，报名[activityId = {}],查询的个数{}", baoMingDto.getUserId(), baoMingDto.getActivityId(), count);
            if (count > 0) {
                return R.error("您已参与过报名");
            }
            Map<String, Object> map = new HashMap<>();
            map.put("abiNum", baoMingDto.getActivityId());
            ActivityMemberInfoEntity activityMemberInfoEntity = new ActivityMemberInfoEntity();
            ActivityJoinInfoEntity activityJoinInfoEntity = new ActivityJoinInfoEntity();
            activityJoinInfoEntity.setAbiId(baoMingDto.getActivityId());
            activityJoinInfoEntity.setUbiId(baoMingDto.getSchoolId());
            activityJoinInfoEntity.setAmiId(baoMingDto.getUserId());
            activityJoinInfoEntity.setFileUrl(baoMingDto.getFileUrl());
            activityJoinInfoEntity.setJoinType(1);

            ActivityBaseInfoEntity activityBaseInfo = activityBaseInfoService.isSignup(map);
            log.info("获取根据[abiNum={}]得到activityBaseInfo= {}", baoMingDto.getActivityId(), activityBaseInfo.getAbiName());
            if (activityBaseInfo != null) {
                //开始报名
                log.info(",限制人数={},已报人数={}", activityBaseInfo.getLimitSignNum(), activityBaseInfo.getAbiSignNum());
                // 活动开始时间 与结束时间
                Long newTime = System.currentTimeMillis();
                Long start = activityBaseInfo.getAbiStartTime().getTime();
                Long abiRegistrationDeadline = activityBaseInfo.getAbiRegistrationDeadline().getTime();

                if (newTime > start) {
                    return R.error("活动已经开始");
                }

                if (activityBaseInfo.getLimitSignNum() <= activityBaseInfo.getAbiEnrollmentNum()) {
                    return R.error("报名人数已满");
                }

                // 如果是公开报名 则校实际报名人数 是否已满
                if (activityBaseInfo.getAbiSignOpen() == 0) {
                    if (activityBaseInfo.getLimitSignNum() <= activityBaseInfo.getAbiSignNum()) {
                        log.info("[abiNum={}]得到activityBaseInfo= {} 公开报名人数已满", baoMingDto.getActivityId(), activityBaseInfo.getAbiName());
                        return R.error("报名人数已满");
                    }
                    // 如果是审核报名 则校验已报名人数是否已满
                } else if (activityBaseInfo.getAbiSignOpen() == 1) {
                    if (activityBaseInfo.getLimitSignNum() <= activityBaseInfo.getAbiEnrollmentNum()) {
                        log.info("[abiNum={}]得到activityBaseInfo= {} 审核人数已满", baoMingDto.getActivityId(), activityBaseInfo.getAbiName());
                        return R.error("报名人数已满");
                    }
                } else {
                    return R.error("报名人数已满");
                }

                // 校验学员是否已经报过名



                //
                activityJoinInfoEntity.setJoinDate(new Date());
                activityJoinInfoEntity.setAjiNum(IdWorker.getId());
                boolean falg = this.activityJoinInfoService.insert(activityJoinInfoEntity);
                if (falg) {
                    ActivityBaseInfoEntity activityBaseInfoEntity = new ActivityBaseInfoEntity();
                    activityBaseInfoEntity.setAbiNum(activityBaseInfo.getAbiNum());
                    // 如果是公开报名 则更新活动表 实际报名人数 跟已报名人数
                    if (activityBaseInfo.getAbiSignOpen() == 0) {
//                        activityBaseInfoEntity.setAbiSignNum(activityBaseInfo.getAbiSignNum() + 1);
//                        activityBaseInfoEntity.setAbiEnrollmentNum(activityBaseInfo.getAbiEnrollmentNum() + 1);
                        activityMemberInfoEntity.setAmiAuditStatus(0);
                    }
//                    else if (activityBaseInfo.getAbiSignOpen() == 1) {
//                        activityBaseInfoEntity.setAbiSignNum(activityBaseInfo.getAbiSignNum() + 1);
//                        activityBaseInfoEntity.setAbiEnrollmentNum(activityBaseInfo.getAbiEnrollmentNum() + 1);
//                    }
//                    this.activityBaseInfoService.updateById(activityBaseInfoEntity);
                    boolean res = this.activityBaseInfoService.updateApply(activityBaseInfo.getAbiNum());
                    if (res) {
                        // 根据学员id 获取学员信息
                        SysUserInfo sysUserInfo = isysUserInfoService.getSysUserInfo(baoMingDto.getUserId());
                        // 添加 活动人员信息表#20161213#
                        activityMemberInfoEntity.setAmiNum(IdWorker.getId());
                        activityMemberInfoEntity.setAbiId(baoMingDto.getActivityId());
                        //TODO 获取abi_publish_id机构
                        activityMemberInfoEntity.setUdiId(/*baoMingDto.getOrgId()*/activityBaseInfo.getAbiPublishId());
                        activityMemberInfoEntity.setUbiId(baoMingDto.getSchoolId());
                        activityMemberInfoEntity.setAmiUserType(3);
                        activityMemberInfoEntity.setAmiUserId(baoMingDto.getUserId());
                        activityMemberInfoEntity.setAmiUserName(sysUserInfo.getUuiName());
                        activityMemberInfoEntity.setAmiUserNo(sysUserInfo.getGradeCode());
                        activityMemberInfoService.insert(activityMemberInfoEntity);
                    } else {
                        log.error("已经超出报名人数,限制人数={},已报人数={}", activityBaseInfo.getLimitSignNum(), activityBaseInfo.getAbiSignNum());
                        return R.error("已超出最大限额");
                    }
                } else {
                    return R.error("报名失败 请联系管理员");
                }

            } else {
                return R.error("暂时无法报名,请联系管理员");
            }
        }catch (Exception ex) {
            log.error("报名出错了{}", ex.getMessage());
        }finally {
            //解锁
            redisLock.unLock(String.valueOf(baoMingDto.getActivityId()) + baoMingDto.getUserId(), String.valueOf(time));
//            rlock.unlock();
            log.info("活动id=[{}]解锁", baoMingDto.getActivityId());
        }

//        //报名成功存入redis
//        redisUtils.set("activity:" + baoMingDto.getActivityId() + ":" + baoMingDto.getUserId(), 1, 60 * 30);

        //报名成功推送微信消息
//        WechatService wechatService = new WechatService();
//        WechatReq req = new WechatReq();

        Map<String, Object> map = new HashMap<>();
        map.put("abiNum", baoMingDto.getActivityId());

        ActivityBaseInfoEntity activityBaseInfo = activityBaseInfoService.isSignup(map);

        // 根据学员id 获取学员信息
        SysUserInfo sysUserInfo = isysUserInfoService.getSysUserInfo(baoMingDto.getUserId());

//        req.setSecret_key("ZSN426XtLdhIS9/DxY2SkNJJDyk=");
//        req.setTp_name("WLSZJY");
//        req.setModule_id("wechat");
//        req.setSys_id("mp");
//        req.setInterface_method("wechat");
//        req.setApp_id("28");
//        req.setSend_priority("4");
//        req.setSend_sys_id("1");
//        req.setPerson_info(sysUserInfo.getUuiName()+"|"+sysUserInfo.getGradeCode()+"| | | ");
//        req.setSend_sys_name("I-Huster网络思政教育一键通");
//        req.setWechat_type("text");
//        req.setTemplet_id("0");
//        req.setReceipt_id("0");
//        req.setSend_time(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//        req.setWechat_info("[ihuster微平台]您已成功报名"+activityBaseInfo.getAbiName()+"活动，请准时参加活动。");
//        wechatService.getWechatServiceHttpPort().saveWechatInfo(JsonUtil.objectToJson(req));

        return R.ok();
    }

    @GetMapping("signIn")
    public R notToken(@RequestBody BaoMingDto baoMingDto) {

        ActivityJoinInfoEntity activityJoinInfoEntity = new ActivityJoinInfoEntity();
        activityJoinInfoEntity.setAbiId(baoMingDto.getActivityId());
        activityJoinInfoEntity.setAmiId(baoMingDto.getUserId());
        activityJoinInfoEntity.setJoinType(1);
        ActivityBaseInfoEntity activityBaseInfo = activityBaseInfoService.selectById(baoMingDto.getActivityId());
        if (activityBaseInfo == null) {
            return R.error("当前活动不存在 请联系管理员");
        }
        // 判断活动状态 是否进行中
        if (activityBaseInfo.getSigninType() == 0) {

            return R.error("当前活动 不需要签到");
        }
        // 签到开始时间
        Long signinStartTime = null;
        Long signinEndTime = null;
        Long signoutStartTime = null;
        Long signontEndTime = null;

        // 服务器当前时间
        Long newTine = System.currentTimeMillis();

        if (baoMingDto.getSigninType() == 2) {

            if (activityBaseInfo.getSigninStartTime() != null) {
                signinStartTime = activityBaseInfo.getSigninStartTime().getTime();
            } else {
                signinStartTime = activityBaseInfo.getAbiStartTime().getTime();
            }
            if (activityBaseInfo.getSigninEndTime() != null) {
                signinEndTime = activityBaseInfo.getSigninEndTime().getTime();
            } else {
                signinEndTime = activityBaseInfo.getAbiEndTime().getTime();
            }
            // 判断当前时间 是否可以参加签到
            if (signinStartTime >= newTine) {
                return R.error("签到时间 还未开始");
            }
            // 判断签到时间 是否结束
            if (signinEndTime <= newTine) {
                return R.error("签到时间已经截止");
            }
        } else if (baoMingDto.getSigninType() == 3) {
            if (activityBaseInfo.getSignoutStartTime() != null) {
                signoutStartTime = activityBaseInfo.getSignoutStartTime().getTime();
            } else {
                signoutStartTime = activityBaseInfo.getAbiStartTime().getTime();
            }
            if (activityBaseInfo.getSignoutEndTime() != null) {
                signontEndTime = activityBaseInfo.getSignoutEndTime().getTime();
            } else {
                signontEndTime = activityBaseInfo.getAbiEndTime().getTime();
            }

            if (signoutStartTime >= newTine) {
                return R.error("签退时间 还未开始");
            }
            // 判断签到时间 是否结束
            if (signontEndTime <= newTine) {
                return R.error("签退时间已经截止");
            }
        } else {
            return R.error("传入类型错误");
        }
        // 判断当前用户 是否参与过活动
        Integer count = activityJoinInfoService.isenlist(baoMingDto.getActivityId(), baoMingDto.getUserId());
        if (count == 0) {
            return R.error("当前用户 还未参与活动");
        }
        // 状态2为签到类型
        activityJoinInfoEntity.setJoinType(activityBaseInfo.getSigninType());
        activityJoinInfoEntity.setAjiNum(IdWorker.getId());
        activityJoinInfoEntity.setJoinDate(new Date());
        activityJoinInfoEntity.setUbiId(activityBaseInfo.getUbiId());
        // 签到类型
        // int signinType = activityBaseInfo.getSigninType();
        // #20160926#0、不需要签到1、普通签到2、扫描签到3、管理员扫描签到4验票签到
        activityJoinInfoService.insert(activityJoinInfoEntity);

        return R.ok();
    }
}
