package com.vpclub.activitycheckinfo.controller;

import com.vpclub.activitycheckinfo.entity.ActivityMemberInfoEntity;
import com.vpclub.activitycheckinfo.service.ActivityMemberInfoService;
import com.vpclub.admin.utils.PageUtils;
import com.vpclub.admin.utils.R;
import com.vpclub.admin.utils.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 活动人员信息表#20161213#
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 10:41:26
 */
@RestController
@RequestMapping("sys/activitymemberinfo")
public class ActivityMemberInfoController {
	@Autowired
	private ActivityMemberInfoService activityMemberInfoService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:activitymemberinfo:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = activityMemberInfoService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{amiNum}")
	@RequiresPermissions("sys:activitymemberinfo:info")
	public R info(@PathVariable("amiNum") Long amiNum) {
		ActivityMemberInfoEntity activityMemberInfo = activityMemberInfoService.selectById(amiNum);

		return R.ok().put("activityMemberInfo", activityMemberInfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:activitymemberinfo:save")
	public R save(@RequestBody ActivityMemberInfoEntity activityMemberInfo) {
		activityMemberInfoService.insert(activityMemberInfo);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:activitymemberinfo:update")
	public R update(@RequestBody ActivityMemberInfoEntity activityMemberInfo) {
		ValidatorUtils.validateEntity(activityMemberInfo);
		activityMemberInfoService.updateAllColumnById(activityMemberInfo);// 全部更新

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:activitymemberinfo:delete")
	public R delete(@RequestBody Long[] amiNums) {
		activityMemberInfoService.deleteBatchIds(Arrays.asList(amiNums));

		return R.ok();
	}

}
