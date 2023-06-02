package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class UploadController
{

    @PostMapping("/upload")
    public Result upload(String username , Integer age , MultipartFile image) throws IOException
    {
        log.info("文件上传：{} {} {}",username , age , image);

        String originalFilename = image.getOriginalFilename();
        image.transferTo(new File("C:\\Users\\GT\\Desktop\\image"));
        return Result.success();
    }
}
