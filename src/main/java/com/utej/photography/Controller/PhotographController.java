package com.utej.photography.Controller;


import com.utej.photography.Service.AlbumService;
import com.utej.photography.Service.PhotographService;
import com.utej.photography.model.Album;
import com.utej.photography.model.Photograph;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/photographs")
public class PhotographController {
    PhotographService photographService;
    AlbumService albumService;
    public PhotographController(PhotographService photographService, AlbumService albumService){
        this.photographService = photographService;
        this.albumService = albumService;
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadPhoto(@RequestParam MultipartFile imageData, @RequestParam Album album, @RequestParam String date){
        return photographService.uploadPhoto(imageData, album, date);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePhoto(@RequestParam Long photographId){
        return photographService.deletePhotograph(photographId);
    }
    @GetMapping()
    public List<Photograph> getAllPhoto(){
        return photographService.getAllPhotograph();
    }
    @GetMapping("/by-albumId/{albumId}")
    public List<Photograph> getAllPhotoByAlbum(@PathVariable Long albumId){
        Album album = albumService.getAlbumById(albumId);
        return photographService.getAllPhotographByAlbum(album);
    }
    @GetMapping("/{photographId}")
    public Photograph getPhotoById(@PathVariable Long photographId){
        return photographService.getPhotographById(photographId);
    }
    @GetMapping("/count")
    public long photographCount(){
        return photographService.photographsCount();
    }


}
