    package com.utej.photography.model;


    import jakarta.persistence.*;

    @Entity
    @Table(name = "photographs")
    public class Photograph {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long photographId;
        @Lob
        @Column(name = "imageData", columnDefinition = "LONGBLOB")
        private byte[] imageData;
        @ManyToOne
        @JoinColumn(name = "albumId")
        private Album album;
        @Column(nullable = false)
        private String date;

        public Photograph(){
        }
        public Photograph(byte[] imageData,Album album, String date){
            this.imageData = imageData;
            this.album = album;
            this.date = date;
        }

        public byte[] getImageData() {
            return imageData;
        }

        public Album getAlbum() {
            return album;
        }

        public void setAlbum(Album album) {
            this.album = album;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
        public void setImageData(byte[] imageData) {
            this.imageData = imageData;
        }

    }
