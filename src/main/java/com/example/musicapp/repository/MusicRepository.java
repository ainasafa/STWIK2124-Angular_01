package com.example.musicapp.repository;

import com.example.musicapp.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
    // JpaRepository sudah menyediakan: findAll, findById, save, deleteById, dll.
}
