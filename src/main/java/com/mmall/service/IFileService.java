package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2019-08-05
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
