package com.example.demo.service;

import com.example.demo.entity.ImageEntity;
import com.example.demo.web.ImageRequest;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    void addImage(ImageRequest imageRequest) throws IOException;
    List<ImageEntity> getAll();
}
