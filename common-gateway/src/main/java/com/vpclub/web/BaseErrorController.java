package com.vpclub.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import com.vpclub.result.ResponseResult;
import com.vpclub.result.Result;
import com.vpclub.result.ResultCodeEnum;

/**
 * @author
 * @date 12/14
 */
@RestController
public class BaseErrorController extends AbstractErrorController {

    @Autowired
    public BaseErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public Result error(HttpServletRequest request) {
        return ResponseResult.failResult(ResultCodeEnum.SERVER_ERROR, "网关服务异常,请联系管理员");
    }

}