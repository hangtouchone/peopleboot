package com.hang.people_management.service;


import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
