package com.rigtrack.tracker.Controller;

import com.rigtrack.tracker.Entity.Image;
import com.rigtrack.tracker.Responses.ResponseMessage;
import com.rigtrack.tracker.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("img/")
public class ImageController {
    @Autowired
    ImageService imageService;
    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> createImage(@RequestParam("file")MultipartFile file)  {
        String message = "";
        try {
            Image img = imageService.createImage(file);
            message = img.getUuid();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e)   {
            message = "Error: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable String id) {
        Image image = imageService.getImageById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
                .body(image.getData());
    }
    //TODO: remaining CRUD ops
}
