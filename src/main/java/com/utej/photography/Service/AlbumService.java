package com.utej.photography.Service;


import com.utej.photography.Repository.AlbumRepository;
import com.utej.photography.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;
    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }
    public ResponseEntity<String> createAlbum(String AlbumName, String description, String date){
        Album album = new Album(AlbumName, description, date);
        albumRepository.save(album);
        return ResponseEntity.ok("Album created!");
    }
    public ResponseEntity<String> deleteAlbum(Long albumId){
        albumRepository.deleteById(albumId);
        return ResponseEntity.ok("Album deleted!");
    }
    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }
    public Album getAlbumById(Long albumId){
        return albumRepository.findByAlbumId(albumId);
    }
    public ResponseEntity<String> updateAlbum(String albumName, String description, String date, Long albumId){
        Album album = albumRepository.findByAlbumId(albumId);
        album.setAlbumName(albumName);
        album.setDescription(description);
        album.setDate(date);
        albumRepository.save(album);
        return ResponseEntity.ok("Album updated successfully!");
    }
    public List<Album> searchByAlbumName(String albumName){
        return albumRepository.findByAlbumNameContainingIgnoreCase(albumName);
    }
    public long albumCount(){
        return albumRepository.count();
    }

}
