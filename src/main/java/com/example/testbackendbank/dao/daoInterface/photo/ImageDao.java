package com.example.testbackendbank.dao.daoInterface.photo;

import com.example.testbackendbank.entity.Image;

public interface ImageDao {
    Image create(Image image);
    Image readByName(String name);
    Image update(Image image);
    void delete(Image image);
}
