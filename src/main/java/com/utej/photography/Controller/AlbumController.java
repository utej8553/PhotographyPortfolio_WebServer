package com.utej.photography.Controller;

import com.utej.photography.Service.AlbumService;
import com.utej.photography.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/albums")
public class AlbumController {
    @Autowired
    AlbumService albumService;
    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }
    @PostMapping("/create")
    public ResponseEntity<String> createAlbum(@RequestParam String albumName, @RequestParam String description, @RequestParam String date){
        return albumService.createAlbum(albumName, description, date);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAlbum(@RequestParam Long albumId){
        return albumService.deleteAlbum(albumId);
    }
    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }
    @GetMapping("/{albumId}")
    public Album getAlbumById(@PathVariable Long albumId){
        return albumService.getAlbumById(albumId);
    }
    @PutMapping("/{albumId}")
    public ResponseEntity<String> updateAlbum(@RequestParam String albumName, @RequestParam String description, @RequestParam String date, @PathVariable Long albumId){
        return albumService.updateAlbum(albumName, description, date, albumId);
    }
    @GetMapping("/search")
    public List<Album> searchAlbums(@RequestParam String keyword){
        return albumService.searchByAlbumName(keyword);
    }
    @GetMapping("/count")
    public long albumCount(){
        return albumService.albumCount();
    }
}
