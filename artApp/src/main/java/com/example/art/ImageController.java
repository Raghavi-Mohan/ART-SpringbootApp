package com.example.art;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.art.Service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ImageController {

    @Autowired(required=true)
    private ImageService imageService;

    @GetMapping("/image/{paintingName}")
    public ResponseEntity<Resource> getImage(@PathVariable("paintingName") String paintingName) throws Exception {
  
        Resource resource = imageService.getImage(paintingName);
        // Return ResponseEntity with image content type
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

    // Endpoint to serve PDF file
    @GetMapping("/file")
    public ResponseEntity<Resource> getFile() throws Exception {
        // Path to the PDF file
        Path path = Paths.get("src/main/resources/static/README.pdf");
        // Load the resource
        Resource resource = new UrlResource(path.toUri());
        // Return ResponseEntity with PDF content type
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    @GetMapping("/video/{paintingName}")
    public ResponseEntity<Resource> getVideo(@PathVariable("paintingName") String paintingName) throws Exception {
        // Load the resource
        Resource resource = imageService.getVideo(paintingName);
        // Return ResponseEntity with image content type
        HttpHeaders headers = new HttpHeaders();
        String stringPath = imageService.getPathString(paintingName);
        headers.setContentType(MediaType.valueOf(Files.probeContentType(Path.of(stringPath))));
        headers.setContentLength(resource.contentLength());
        // Return ResponseEntity with image content type
        return  ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
    
}
