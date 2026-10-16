package com.ty.springboot.library_management_system.controller;

import com.ty.springboot.library_management_system.dto.request.LoanRequest;
import com.ty.springboot.library_management_system.entity.Loan;
import com.ty.springboot.library_management_system.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans(){
        List<Loan> body = loanService.getAll();
        return new ResponseEntity<>(body , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id){
        Loan body = loanService.getById(id);
        return new ResponseEntity<>(body , HttpStatus.OK);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<List<Loan>> getLoanByMemberId(@PathVariable Long id){
        List<Loan> body = loanService.getByMemberId(id);
        return new ResponseEntity<>(body,HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<List<Loan>> getLoanByBookId(@PathVariable Long id){
        List<Loan> body = loanService.getByBookId(id);
        return new ResponseEntity<>(body , HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Loan>> getActiveLoans(){
        List<Loan> body = loanService.getActiveLoans();
        return new ResponseEntity<>(body , HttpStatus.OK);
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Loan>> getOverdueLoans(){
        List<Loan> body = loanService.getOverdueLoans();
        return new ResponseEntity<>(body , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Loan> saveLoan(@Valid @RequestBody LoanRequest loanRequest){
        Loan body = loanService.save(loanRequest);
        return new ResponseEntity<>(body,HttpStatus.CREATED);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable Long id){
        Loan body = loanService.returnBook(id);
        return new ResponseEntity<Loan>(body , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanRecord(@PathVariable Long id){
        loanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
