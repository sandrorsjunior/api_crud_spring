package com.example.api.controller;

import com.example.api.controller.dto.AuthorDTO;
import com.example.api.model.Author;
import com.example.api.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Author>> search(){
        List<Author> authors = this.autorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AuthorDTO authorDTO){
        Author newAuthor = authorDTO.mapToAutor();
        autorService.save(newAuthor);
        URI uriLocation =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(newAuthor.getId())
                .toUri();

        return ResponseEntity.created(uriLocation).build();
    }
    @GetMapping("{id}")
    public ResponseEntity<AuthorDTO> getDatails(@PathVariable("id") String id){
         Optional<Author> authorOP = this.autorService.findById(UUID.fromString(id));
        if(authorOP.isPresent()){
            Author author = authorOP.get();
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getId(),
                    author.getNome(),
                    author.getDataNascimento(),
                    author.getNacionalidade()
                    );
            return ResponseEntity.ok(authorDTO);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        Optional<Author> authorOP = this.autorService.findById(UUID.fromString(id));
        if(authorOP.isPresent()){
            Author author = authorOP.get();
            this.autorService.deleteById(author);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<AuthorDTO>> search(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "nationality", required = false) String nationality
            ){
        List<Author> authors = this.autorService.search(name, nationality);
        List<AuthorDTO> authorDTOS = authors.stream().map(
                author -> new AuthorDTO(
                        author.getId(),
                        author.getNome(),
                        author.getDataNascimento(),
                        author.getNacionalidade()
                )
        ).collect(Collectors.toList());
        return ResponseEntity.ok(authorDTOS);
    }
}
