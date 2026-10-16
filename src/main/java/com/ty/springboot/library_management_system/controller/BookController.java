package com.ty.springboot.library_management_system.controller;

import com.ty.springboot.library_management_system.entity.Book;
import com.ty.springboot.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
       List<Book> body = bookService.getAll();
       return new ResponseEntity<List<Book>>(body , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book body = bookService.get(id);
        return new ResponseEntity<Book>( body , HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<Book>> getBookByAuthorId(@PathVariable Long id){
      List<Book> body = bookService.getByAuthorId(id);
      return new ResponseEntity<List<Book>>(body,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Book>> getBookByCategoryId(@PathVariable Long id){
        List<Book> body = bookService.getByCategoryId(id);
        return new ResponseEntity<List<Book>>(body, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book body = bookService.save(book);
        return new ResponseEntity<Book>(body , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book book){
       Book body = bookService.updateBook(id,book);
        return new ResponseEntity<>(body,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
