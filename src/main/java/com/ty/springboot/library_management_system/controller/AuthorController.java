package com.ty.springboot.library_management_system.controller;

import com.ty.springboot.library_management_system.entity.Author;
import com.ty.springboot.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.getAll();
        return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        Author body = authorService.getById(id);
        return new ResponseEntity<Author>(body , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
       Author body = authorService.save(author);
        return new ResponseEntity<Author>(body , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id,@RequestBody Author author){
        Author body = authorService.update(id,author);
        return new ResponseEntity<Author>(body , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
         authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
