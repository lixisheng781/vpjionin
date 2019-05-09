package com.vpclub.admin.client;


import com.vpclub.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lxs
 */
@RequestMapping(value = "/sysUserTokenClient")
public interface SysUserTokenClient {
    /**
     * 生成token
     * @param userId  用户ID
     */
    @RequestMapping(value = "createToken")
    Result createToken(@RequestParam("userId") long userId);

    /**
     * 退出，修改token值
     * @param userId  用户ID
     */
    @RequestMapping(value = "logout")
    Result logout(@RequestParam("userId") long userId);
}
