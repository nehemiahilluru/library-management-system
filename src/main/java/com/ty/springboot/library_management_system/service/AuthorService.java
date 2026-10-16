package com.ty.springboot.library_management_system.service;

import com.ty.springboot.library_management_system.entity.Author;
import com.ty.springboot.library_management_system.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public Author getById(Long id){
        Optional<Author> opt = authorRepository.findById(id);
        if(opt.isPresent()) return opt.get();
        throw new RuntimeException("id not found");
    }

    public Author save(Author author){
        Author a = authorRepository.save(author);
        return a;
    }

    public Author update(Long id,Author author){
        boolean exists = authorRepository.existsById(id);
        if(!exists) throw new RuntimeException("id not found");
        Author a = authorRepository.save(author);
        return a;
    }

    public void delete(Long id){
        boolean exists = authorRepository.existsById(id);
        if(!exists) throw new RuntimeException("id not found");
        authorRepository.deleteById(id);
    }
}
