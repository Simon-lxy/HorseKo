package com.hroseko.oss.controller;

import com.hroseko.oss.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wayne
 * @data 2024/03/20 15:56:10
 * 5
 **/

@RestController
@RequestMapping
public class FileController {


    @Resource
    private FileService fileService;

    @GetMapping("/getAllBuckets")
    public String testGetAllBuckets()  throws Exception {
        List<String> allBuckets =  fileService.getAllBucket();
        return allBuckets.get(0);
    }

    @RequestMapping("/getUrl")
    public String getUrl(String bucketName, String objectName) throws Exception {
        return fileService.getUrl(bucketName, objectName);
    }

}
