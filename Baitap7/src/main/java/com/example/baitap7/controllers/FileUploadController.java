package com.example.baitap7.controllers;

import com.example.baitap7.models.ResponseObject;
import com.example.baitap7.services.ImageStorageSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/api/v1/FileUpload")
public class FileUploadController {
    //Inject Storage Service here
    @Autowired
    private ImageStorageSevice storageSevice;

    @PostMapping("")
    public ResponseEntity<ResponseObject> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            //save files to a folder =>use a service
            String generateFileName = storageSevice.storeFile(file);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","upload file successfully",generateFileName)
            );
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("error","upload file failed",exception.getMessage())
            );
        }
    }
    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<byte[]> readDetailFile(@PathVariable String filename) {
        try {
            byte[] bytes = storageSevice.readFileConten(filename);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(bytes);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/getListFiles")
    public ResponseEntity<ResponseObject> getListFiles() {
        try {
            List<String> urls = (List<String>) storageSevice.loadALL()
                    .map(path -> {
                        String urlPath = MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "readDetailFile", path.getFileName().toString()).build().toUri().toString();
                        return urlPath;
                    }).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","list files successfully",urls));
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }

    }

}
