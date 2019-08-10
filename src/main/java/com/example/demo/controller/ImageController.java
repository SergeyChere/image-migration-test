package com.example.demo.controller;

import com.example.demo.entity.ImageEntity;
import com.example.demo.service.ImageService;
import com.example.demo.web.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/add")
    public void addImage(@RequestBody ImageRequest imageRequest) throws IOException {
        imageService.addImage(imageRequest);
    }

    @GetMapping("/get")
    public List<ImageEntity> getALl() {
        return imageService.getAll();
    }
}
