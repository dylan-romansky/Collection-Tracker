package com.rigtrack.tracker.Service;

import com.rigtrack.tracker.Dao.ImageDao;
import com.rigtrack.tracker.Entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDao imageDao;
    @Override
    public Image createImage(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image(filename, file.getContentType(), file.getBytes());
        return imageDao.save(image);
    }

    @Override
    public Image updateImage(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image(filename, file.getContentType(), file.getBytes());
        return imageDao.save(image);
    }

    @Override
    public Stream<Image> getAllImages() {
        return imageDao.findAll().stream();
    }

    @Override
    public Image getImageById(String id) {
        return imageDao.findById(id).get();
    }

    @Override
    public String deleteImageById(String id) {
        imageDao.deleteById(id);
        return id;
    }
}
