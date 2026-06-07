package com.example.musicapp.service;

import com.example.musicapp.entity.Music;
import com.example.musicapp.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    // Get all music
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    // Get music by ID
    public Music getMusicById(Long id) {
        return musicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Music not found with id: " + id));
    }

    // Add new music (Admin only)
    public Music addMusic(Music music) {
        return musicRepository.save(music);
    }

    // Delete music by ID (Admin only)
    public void deleteMusic(Long id) {
        if (!musicRepository.existsById(id)) {
            throw new RuntimeException("Music not found with id: " + id);
        }
        musicRepository.deleteById(id);
    }
}
