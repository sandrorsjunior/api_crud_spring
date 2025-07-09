package com.example.api.repository;

import com.example.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Author, UUID> {
    public List<Author> findByNome(String nome);
    public List<Author> findByNacionalidade(String nacionalidade);
    public List<Author> findByNacionalidadeAndNome(String nacionalidade, String nome);
}
