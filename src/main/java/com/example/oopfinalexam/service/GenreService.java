package com.example.oopfinalexam.service;

import com.example.oopfinalexam.model.Genre;
import com.example.oopfinalexam.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    public Genre updateGenre(Long id, Genre genre) {
        Optional<Genre> existingGenreOptional = genreRepository.findById(id);

        if (existingGenreOptional.isPresent()) {
            Genre existingGenre = existingGenreOptional.get();
            existingGenre.setName(genre.getName());
            return genreRepository.save(existingGenre);
        }

        return null;
    }
}
