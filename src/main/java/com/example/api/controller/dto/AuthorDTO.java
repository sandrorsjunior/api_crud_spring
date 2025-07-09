package com.example.api.controller.dto;

import com.example.api.model.Author;

import java.time.LocalDate;
import java.util.UUID;

public record AuthorDTO(
        UUID id,
        String nome,
        LocalDate dataNascimento,
        String nacionalidade
) {
    public Author mapToAutor(){
        Author newAuthor = new Author();
        newAuthor.setId(this.id);
        newAuthor.setNome(this.nome);
        newAuthor.setDataNascimento(this.dataNascimento);
        newAuthor.setNacionalidade(this.nacionalidade);
        return newAuthor;
    }
}

