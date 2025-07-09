package com.example.api.repository;

import com.example.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Author, UUID> {
}
