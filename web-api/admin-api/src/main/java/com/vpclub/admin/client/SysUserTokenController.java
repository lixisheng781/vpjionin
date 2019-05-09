/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vpclub.admin.client;


import com.vpclub.result.Result;
import com.vpclub.admin.service.ShiroService;
import com.vpclub.admin.service.SysUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Token 前端控制器
 */
@RestController
@RequestMapping("/admin/sys/token")
public class SysUserTokenController extends AbstractController {

	@Autowired
	private SysUserTokenService sysUserTokenService;

	@Autowired
	private ShiroService shiroService;

	/**
	 * 生成token
	 */
	@PostMapping("/createToken")
	//当写了@RequestParam时，是默认必需有默认值，如果没有报错
	public Result createToken(@RequestParam(value = "userId",defaultValue = "0") long userId) {
        return sysUserTokenService.createToken(userId);
    }

	/**
	 * 退出，修改token值
	 */
	@PostMapping("/logout")
	//当写了@RequestParam时，是默认必需有默认值，如果没有报错
	//@RequestParam(value = "userId", defaultValue = "0")
	public Result logout(@RequestParam(value = "userId", defaultValue = "0") long userId){
		return sysUserTokenService.logout(userId);
	}
}
