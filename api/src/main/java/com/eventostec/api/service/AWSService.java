package com.eventostec.api.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

@Service
public class AWSService {
    @Autowired
    private AmazonS3 s3Client;

    public void putFile(String bucketName, String fileName, File file){
        if (!s3Client.doesBucketExistV2(bucketName)){
            s3Client.createBucket(bucketName);
        }

        s3Client.putObject(bucketName,fileName,file);
    }

    public String getUrlAssinada(String bucketName, String fileName){
        Date expiracao = new Date(System.currentTimeMillis()+(5 * 60 * 100));
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName,fileName)
                .withMethod(HttpMethod.GET)
                .withExpiration(expiracao);
        return s3Client.generatePresignedUrl(request).toString();

    }
}
