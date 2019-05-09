package com.vpclub.activitycheckinfo.controller;

import com.vpclub.activitybaseinfo.entity.ActivityBaseInfoEntity;
import com.vpclub.activitycheckinfo.service.ActivityBaseInfoService;
import com.vpclub.admin.utils.PageUtils;
import com.vpclub.admin.utils.R;
import com.vpclub.admin.utils.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 活动信息表
 *
 */
@RestController
@RequestMapping("sys/activitybaseinfo")
public class ActivityBaseInfoController {
	@Autowired
	private ActivityBaseInfoService activityBaseInfoService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:activitybaseinfo:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = activityBaseInfoService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{abiNum}")
	@RequiresPermissions("sys:activitybaseinfo:info")
	public R info(@PathVariable("abiNum") Long abiNum) {
		ActivityBaseInfoEntity activityBaseInfo = activityBaseInfoService.selectById(abiNum);

		return R.ok().put("activityBaseInfo", activityBaseInfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:activitybaseinfo:save")
	public R save(@RequestBody ActivityBaseInfoEntity activityBaseInfo) {
		activityBaseInfoService.insert(activityBaseInfo);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:activitybaseinfo:update")
	public R update(@RequestBody ActivityBaseInfoEntity activityBaseInfo) {
		ValidatorUtils.validateEntity(activityBaseInfo);
		activityBaseInfoService.updateAllColumnById(activityBaseInfo);// 全部更新

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:activitybaseinfo:delete")
	public R delete(@RequestBody Long[] abiNums) {
		activityBaseInfoService.deleteBatchIds(Arrays.asList(abiNums));

		return R.ok();
	}

}
