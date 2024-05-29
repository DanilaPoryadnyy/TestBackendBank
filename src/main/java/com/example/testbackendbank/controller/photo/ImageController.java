package com.example.testbackendbank.controller.photo;

import com.example.testbackendbank.service.photo.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<?> uploadImage(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imageService.uploadImage(file, request);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping()
    public ResponseEntity<?> downloadImage(HttpServletRequest request) throws UnsupportedEncodingException {
        byte[] imageData = imageService.downloadImage(request);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(IMAGE_PNG_VALUE))
                .body(imageData);
    }
}
