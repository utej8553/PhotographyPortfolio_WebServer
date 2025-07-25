package com.utej.photography.Repository;

import com.utej.photography.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByAlbumId(Long AlbumId);
    List<Album> findByAlbumNameContainingIgnoreCase(String albumName);
}
