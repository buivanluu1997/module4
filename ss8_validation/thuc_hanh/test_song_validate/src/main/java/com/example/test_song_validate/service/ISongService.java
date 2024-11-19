package com.example.test_song_validate.service;

import com.example.test_song_validate.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> searchSongsByTitleContaining(String searchTitle, Pageable pageable);

    void saveSong(Song song);

    Song findSongById(int id);

    void deleteSongById(int id);

    void updateSong(Song song);
}
