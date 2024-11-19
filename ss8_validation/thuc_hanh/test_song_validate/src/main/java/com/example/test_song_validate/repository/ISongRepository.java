package com.example.test_song_validate.repository;

import com.example.test_song_validate.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> searchSongsByTitleContaining(String searchTitle, Pageable pageable);
}
