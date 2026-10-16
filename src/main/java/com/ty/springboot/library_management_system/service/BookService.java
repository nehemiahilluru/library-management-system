package com.ty.springboot.library_management_system.service;

import com.ty.springboot.library_management_system.entity.Book;
import com.ty.springboot.library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book get(Long id){
       Optional <Book> opt = bookRepository.findById(id);
       if(opt.isPresent()) return opt.get();
       throw new RuntimeException("id not found");
    }

    public List<Book> getByAuthorId(Long id){
        List<Book> res = bookRepository.findByAuthorId(id);
        return res;
    }

    public List<Book> getByCategoryId(Long id){
        List<Book> res = bookRepository.findByCategoryId(id);
        return res;
    }

    public Book save(Book b){
        return bookRepository.save(b);
    }

    public Book updateBook(Long id, Book b){
        boolean exists = bookRepository.existsById(id);
        if(!exists) throw new RuntimeException("id not found");
        Book res = bookRepository.save(b);
        return res;
    }

    public void deleteById(Long id){
         bookRepository.deleteById(id);
    }

}
