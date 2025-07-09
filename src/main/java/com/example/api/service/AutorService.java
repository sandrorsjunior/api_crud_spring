package com.example.api.service;


import com.example.api.model.Author;
import com.example.api.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void deleteById(Author author){
        this.autorRepository.delete(author);
    }

    public List<Author> getAllAuthors(){
        return this.autorRepository.findAll();
    }

    public List<Author> search(String name, String nationality){
        if(name!=null && nationality==null) return this.autorRepository.findByNome(name);
        else if(name==null && nationality!=null) return this.autorRepository.findByNacionalidade(nationality);
        else if(name!=null) return this.autorRepository.findByNacionalidadeAndNome(nationality, name);
        else return this.getAllAuthors();

    }
}
