package com.example.api.service;


import com.example.api.model.Author;
import com.example.api.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;

    public Author save(Author newAuthor){
        return this.autorRepository.save(newAuthor);
    }

    public Optional<Author> findById(UUID id){
        return this.autorRepository.findById(id);
    }



}
