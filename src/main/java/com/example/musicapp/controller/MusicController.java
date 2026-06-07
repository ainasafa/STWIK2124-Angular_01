package com.example.musicapp.controller;

import com.example.musicapp.entity.Music;
import com.example.musicapp.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/music")
@CrossOrigin(origins = "http://localhost:4200")
public class MusicController {

    @Autowired
    private MusicService musicService;

    // GET /api/music - View semua music (ADMIN & USER)
    @GetMapping
    public ResponseEntity<List<Music>> getAllMusic() {
        List<Music> musicList = musicService.getAllMusic();
        return ResponseEntity.ok(musicList);
    }

    // GET /api/music/{id} - View music by ID (ADMIN & USER)
    @GetMapping("/{id}")
    public ResponseEntity<?> getMusicById(@PathVariable Long id) {
        try {
            Music music = musicService.getMusicById(id);
            return ResponseEntity.ok(music);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // POST /api/music - Add music baru (hanya ADMIN)
    @PostMapping
    public ResponseEntity<?> addMusic(@RequestBody Music music) {
        try {
            Music saved = musicService.addMusic(music);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gagal menambahkan music: " + e.getMessage());
        }
    }

    // DELETE /api/music/{id} - Hapus music (hanya ADMIN)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMusic(@PathVariable Long id) {
        try {
            musicService.deleteMusic(id);
            return ResponseEntity.ok("Music dengan ID " + id + " berhasil dihapus");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
