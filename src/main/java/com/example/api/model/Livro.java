package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String isbn;
    private String titulo;
    private LocalDate dataPublicacao;
    @Enumerated(EnumType.STRING)
    private GeneroLivro genero;
    private BigDecimal preco;
    @ManyToOne
    private Author author;
    @CreatedDate
    private LocalDateTime dataCadastro;
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;
    @ManyToOne
    private Usuario usuario;
}
