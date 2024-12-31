package com.example.baitap7.services;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ImageStorageSevice implements IstorageService{
    private final Path storagePath = Paths.get("uploads");
    public ImageStorageSevice() {
        try {
            Files.createDirectories(storagePath);
        } catch (IOException exception) {
            throw new RuntimeException("Cannot initialize storage",exception);
        }
    }
    public boolean isImageFile(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        return Arrays.asList("jpg", "jpeg", "gif", "png").contains(extension.trim().toLowerCase());
    }
    @Override
    public String storeFile(MultipartFile file) {
        try {
            if(file.isEmpty()) {
                throw new RuntimeException("Cannot store empty file");
            }
            //check file is image ?
            if(!isImageFile(file)) {
                throw new RuntimeException("Cannot store file");
            }
            //file must be <= 50mb
            float fileSizeInMegabytes = file.getSize()/ 1_000_000.0f;
            if(fileSizeInMegabytes > 5.0f) {
                throw new RuntimeException("File must be <= 50Mb");
            }
            //File must be rename, why ?
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
            String generateFileName = UUID.randomUUID().toString().replace("-","");
            generateFileName = generateFileName + "." + fileExtension;
            Path destinationFilePath = this.storagePath.resolve(Paths.get(generateFileName)).normalize().toAbsolutePath();

            if(!destinationFilePath.getParent().equals(this.storagePath.toAbsolutePath())) {
                throw new RuntimeException("Cannot store file outside current directory.");
            }
            try(InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);

            }
            return generateFileName;
        }

        catch (IOException exception) {
            throw new RuntimeException("Cannot initialize storage",exception);
        }
    }

    @Override
    public Stream<Path> loadALL() {
        try {
            return Files.walk(this.storagePath, 1)
                    .filter(path -> !path.equals(this.storagePath) && !path.toString().contains("_."))
                    .map(this.storagePath::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Error reading directory: " +this.storagePath, e);
        }
    }

    @Override
    public byte[] readFileConten(String fileName) {
        try {
            Path filePath = storagePath.resolve(fileName);

            // Check if file exists and is readable
            if (!Files.exists(filePath) || !Files.isReadable(filePath)) {
                throw new IOException("File not found or unreadable: " + filePath);
            }

            // Read the file contents and return it as byte[]
            return Files.readAllBytes(filePath);

        } catch (IOException e) {
            throw new RuntimeException("Error reading file at path: " + fileName, e);
        }
    }
}
