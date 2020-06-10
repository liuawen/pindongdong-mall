package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2019-08-05
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);


    public String upload(MultipartFile file,String path){
        String fileName = file.getOriginalFilename();
        //扩展名
        //abc.jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        //.jpg jpg 后缀名  名不一致  生成不重复的
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        //文件夹是否存在
        if(!fileDir.exists()){
            //不存在就创建它

            //可写权限
            fileDir.setWritable(true);
            //mkdir  mkdirs可以创建多级 a/b/c
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);


        try {
            file.transferTo(targetFile);
            //文件已经上传成功了

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //已经上传到ftp服务器上

            targetFile.delete();
            //todo 上传完之后，删除upload下面的文件  tomcat
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;//没有文件名
        }
        //A:abc.jpg
        //B:abc.jpg
        return targetFile.getName();//返回 目标的文件名
    }

}
