package com.utej.photography.Repository;

import com.utej.photography.model.Album;
import com.utej.photography.model.Photograph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographRepository extends JpaRepository<Photograph, Long> {
    Photograph findByPhotographId(Long photographId);
    List<Photograph> findByAlbum(Album album);

}
