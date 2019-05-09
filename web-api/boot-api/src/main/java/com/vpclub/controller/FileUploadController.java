package com.vpclub.controller;

import com.vpclub.result.ResponseResult;
import com.vpclub.result.ResultCodeEnum;
import com.vpclub.annotation.Unlogin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Value("${upload.rootpath}")
    String uploadPath;

    @Value("${upload.serverurl}")
    String serverurl;


    /**
     * 实现文件上传
     * */
    @Unlogin
    @ResponseBody
    @RequestMapping("/upload")
    public Object fileUpload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return ResponseResult.failResult(ResultCodeEnum.BAD_REQUEST, "文件为空");
        }

        String originalFilename = file.getOriginalFilename();
        String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")) + originalFilename.substring(originalFilename.lastIndexOf("."));

        //long size =  file.getSize();
        //System.out.println(fileName + "-->" + size);
        //System.out.println(uploadPath + "-->" + serverurl);

        String filepath = "/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "/" + UUID.randomUUID().toString() + "/" +  fileName;
        File dest = new File(uploadPath + filepath);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest); //保存文件
            return ResponseResult.success(serverurl + filepath);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseResult.serverError();
    }

}
