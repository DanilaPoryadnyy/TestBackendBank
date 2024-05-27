package com.example.testbackendbank.dao.daoImpl.photo;

import com.example.testbackendbank.dao.daoInterface.photo.ImageDao;
import com.example.testbackendbank.entity.Image;
import com.example.testbackendbank.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
@Repository
@RequiredArgsConstructor
public class ImageDaoImpl implements ImageDao {

    private final ImageRepository imageRepository;

    private Image getImage(String imageName) {
        return imageRepository.findByName(imageName).orElseThrow(() -> new UsernameNotFoundException("Image with that name not found"));
    }

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image readByName(String imageName) {
        return getImage(imageName);
    }

    @Override
    public Image update(Image image) {
        return null;
    }

    @Override
    public void delete(Image image) {
        imageRepository.delete(image);
    }
}
