package com.example.demo.service;

import com.example.demo.entity.ImageEntity;
import com.example.demo.repository.ImageRepository;
import com.example.demo.web.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public void addImage(ImageRequest imageRequest) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] image = base64Decoder.decodeBuffer(imageRequest.getBase64());
        System.out.println(Arrays.toString(image));
        ImageEntity imageEntity = ImageEntity.builder().image(image).build();
        imageRepository.save(imageEntity);
    }

    @Override
    public List<ImageEntity> getAll() {
        return imageRepository.findAll();
    }
}
