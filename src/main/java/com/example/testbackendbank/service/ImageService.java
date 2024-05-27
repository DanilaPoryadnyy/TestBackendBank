package com.example.testbackendbank.service;

import com.example.testbackendbank.dao.daoImpl.auth.UserDaoImpl;
import com.example.testbackendbank.dao.daoImpl.auth.UserDataDaoImpl;
import com.example.testbackendbank.entity.Image;
import com.example.testbackendbank.entity.UserData;
import com.example.testbackendbank.repository.ImageRepository;
import com.example.testbackendbank.utils.ImageUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final UserDataDaoImpl userDataDaoImpl;
    private final UserDaoImpl userDaoImpl;
    private final JwtService jwtService;

    public String uploadImage(MultipartFile imageFile, HttpServletRequest request) throws IOException {

        String email = jwtService.extractEmail(jwtService.resolveToken(request));
        UserData userData = userDataDaoImpl.findByUserInstance(userDaoImpl.getByEmail(email));

        var imageToSave = Image.builder()
                .name(imageFile.getOriginalFilename())
                .type(imageFile.getContentType())
                .imageData(ImageUtils.compressImage(imageFile.getBytes()))
                .build();

        if(userData.getIdImage() != null)
        {
            var imageToDelete = userData.getIdImage();
            userData.setIdImage(null);
            userDataDaoImpl.update(request,userData);
            imageRepository.delete(imageToDelete);
            imageRepository.save(imageToSave);
        }
        else {
            imageRepository.save(imageToSave);
        }

        userData.setIdImage(imageToSave);
        userDataDaoImpl.update(request,userData);

        return "file uploaded successfully : " + imageFile.getOriginalFilename();
    }
    @Transactional
    public byte[] downloadImage(HttpServletRequest request) throws UnsupportedEncodingException {
        String email = jwtService.extractEmail(jwtService.resolveToken(request));
        var userData = userDataDaoImpl.findByUserInstance(userDaoImpl.getByEmail(email));
        Optional<Image> dbImage = Optional.ofNullable(userData.getIdImage());

        return dbImage.map(image -> {
            try {
                return ImageUtils.decompressImage(image.getImageData());
            } catch (DataFormatException | IOException exception) {
                throw new ContextedRuntimeException("Error downloading an image", exception)
                        .addContextValue("Image ID",  image.getId())
                        .addContextValue("Image name", image.getName());
            }
        }).orElse(null);
    }
}
