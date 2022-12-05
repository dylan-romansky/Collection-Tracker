package com.rigtrack.tracker.Service;

import com.rigtrack.tracker.Entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface ImageService {
    Image createImage(MultipartFile file) throws IOException;
    Image updateImage(MultipartFile file) throws IOException;
    Stream<Image> getAllImages();
    Image getImageById(String id);
    String deleteImageById(String id);
}
