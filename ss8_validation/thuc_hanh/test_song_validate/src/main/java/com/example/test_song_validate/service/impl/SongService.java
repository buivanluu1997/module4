package com.example.test_song_validate.service.impl;

import com.example.test_song_validate.model.Song;
import com.example.test_song_validate.repository.ISongRepository;
import com.example.test_song_validate.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> searchSongsByTitleContaining(String searchTitle, Pageable pageable) {
        return songRepository.searchSongsByTitleContaining(searchTitle, pageable);
    }

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findSongById(int id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSongById(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }
}
