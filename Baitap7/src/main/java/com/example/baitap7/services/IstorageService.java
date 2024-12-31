package com.example.baitap7.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface IstorageService {
    public String storeFile(MultipartFile file);
    public Stream<Path> loadALL();
    public byte[] readFileConten(String fileName);
}
