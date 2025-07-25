package com.utej.photography.Service;


import com.utej.photography.Repository.PhotographRepository;
import com.utej.photography.model.Album;
import com.utej.photography.model.Photograph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PhotographService {
    @Autowired
    PhotographRepository photographRepository;
    public PhotographService(PhotographRepository photographRepository){
        this.photographRepository = photographRepository;
    }
    public ResponseEntity<String> uploadPhoto(MultipartFile image, Album album, String date){
        try {
        Photograph photograph = new Photograph();
        photograph.setImageData(image.getBytes());
        photograph.setAlbum(album);
        photograph.setDate(date);
        photographRepository.save(photograph);
        return ResponseEntity.ok("Photograph added");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed: " + e.getMessage());
        }
    }
    public ResponseEntity<String> deletePhotograph(Long photographId){
        photographRepository.deleteById(photographId);
        return ResponseEntity.ok("Photograph deleted!");
    }
    public List<Photograph> getAllPhotographByAlbum(Album album){
        return photographRepository.findByAlbum(album);
    }
    public List<Photograph> getAllPhotograph(){
        return photographRepository.findAll();
    }
    public Photograph getPhotographById(Long photographId){
        return photographRepository.findByPhotographId(photographId);
    }
    public long photographsCount(){
        return photographRepository.count();
    }


}
