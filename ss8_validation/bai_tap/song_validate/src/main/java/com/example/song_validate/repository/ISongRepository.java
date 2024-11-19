package com.example.song_validate.repository;

import com.example.song_validate.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song>findAll(Pageable pageable);
}
