package com.example.art.Service;

import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;

@Service
public class ImageService {

    public Resource getImage(String paintingName) throws MalformedURLException{
      Path path;
      paintingName = paintingName.toLowerCase(); 
        if(paintingName.isEmpty()){
            path = Paths.get("src/main/resources/static/imageNotFound.png");
        }
       else{
        path = Paths.get("src/main/resources/static/"+paintingName+".png");
       }
       if(Files.notExists(path)){
        path = Paths.get("src/main/resources/static/imageNotFound.png");
       }
        Resource resource = new UrlResource(path.toUri());

        return resource;
    }

    public Resource getVideo(String videoName) throws IOException {
        Path path;

        videoName = videoName.toLowerCase(); 
          if(videoName.isEmpty()){
              path = Paths.get("src/main/resources/static/imageNotFound.png");
          }
         else{
          path = Paths.get("src/main/resources/static/"+videoName+".MP4");
         }
         if(Files.notExists(path)){
          path = Paths.get("src/main/resources/static/imageNotFound.png");
         }
        Resource resource = new UrlResource(path.toUri());

  
          return resource;
      }

      public String getPathString(String videoName) throws IOException {
       
        String pathString;
        Path path;


        videoName = videoName.toLowerCase(); 
          if(videoName.isEmpty()){
            pathString = "src/main/resources/static/imageNotFound.png";
            path = Paths.get("src/main/resources/static/imageNotFound.png");
          }
         else{
            pathString = "src/main/resources/static/"+videoName+".MP4";
            path = Paths.get("src/main/resources/static/"+videoName+".MP4");
         }
         if(Files.notExists(path)){
            pathString = "src/main/resources/static/imageNotFound.png";
         }

  
          return pathString;
      }
    
}
