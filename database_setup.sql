-- =========================================
-- Setup Database untuk Music App
-- =========================================

-- Buat database
CREATE DATABASE IF NOT EXISTS musicdb;
USE musicdb;

-- Tabel users (otomatis dibuat oleh Hibernate, ini untuk referensi)
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'USER') NOT NULL DEFAULT 'USER'
);

-- Tabel music sesuai requirement
CREATE TABLE IF NOT EXISTS music (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    youtube_link VARCHAR(500)
);

-- Sample data music
INSERT INTO music (title, artist, youtube_link) VALUES
('Bohemian Rhapsody', 'Queen', 'https://www.youtube.com/watch?v=fJ9rUzIMcZQ'),
('Shape of You', 'Ed Sheeran', 'https://www.youtube.com/watch?v=JGwWNGJdvx8'),
('Blinding Lights', 'The Weeknd', 'https://www.youtube.com/watch?v=4NRXx6U8ABQ'),
('Levitating', 'Dua Lipa', 'https://www.youtube.com/watch?v=TUVcZfQe-Kw'),
('Stay', 'The Kid LAROI & Justin Bieber', 'https://www.youtube.com/watch?v=kTJczUoc26U');
