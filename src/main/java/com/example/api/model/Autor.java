package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private List<Livro> livros;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    @ManyToOne
    private Usuario usuario;

}
