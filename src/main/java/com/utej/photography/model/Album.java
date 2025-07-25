package com.utej.photography.model;


import jakarta.persistence.*;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;
    private String albumName;
    private String description;
    private String date;

    public Album(){
    }
    public Album(String albumName, String description, String date){
        this.albumName = albumName;
        this.description = description;
        this.date = date;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
