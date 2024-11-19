package com.example.song_validate.service;

import com.example.song_validate.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    void save(Song song);
}
