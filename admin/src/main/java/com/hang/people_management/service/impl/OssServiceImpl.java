package com.hang.people_management.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.hang.people_management.service.OssService;
import com.hang.people_management.util.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.UUID;


@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        String endpoint = ConstantPropertiesUtils.END_POIND;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try {
            OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid + fileName;
            String datePath = new DateTime().toString("yyyy/MM/dd");
            fileName = datePath + "/" + fileName;
            ossClient.putObject(bucketName, fileName, inputStream);
            ossClient.shutdown();
            String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
