package com.ty.springboot.library_management_system.service;

import com.ty.springboot.library_management_system.dto.request.LoanRequest;
import com.ty.springboot.library_management_system.entity.Book;
import com.ty.springboot.library_management_system.entity.Loan;
import com.ty.springboot.library_management_system.entity.Member;
import com.ty.springboot.library_management_system.enums.LoanStatus;
import com.ty.springboot.library_management_system.repository.BookRepository;
import com.ty.springboot.library_management_system.repository.LoanRepository;
import com.ty.springboot.library_management_system.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAll(){
        List<Loan> loans = loanRepository.findAll();
        return loans;
    }

    public Loan getById(Long id){
        Optional<Loan> opt = loanRepository.findById(id);
        if(opt.isPresent()) return opt.get();
        throw new RuntimeException("Id not found");
    }

    public List<Loan> getByMemberId(Long id){
        List<Loan> result = loanRepository.findByMemberId(id);
        return result;
    }

    public List<Loan> getByBookId(Long id){
        return loanRepository.findByBookId(id);
    }

    public List<Loan> getActiveLoans(){
        return loanRepository.findByStatus(LoanStatus.ACTIVE);
    }

    public List<Loan> getOverdueLoans(){
        return loanRepository.findByStatus(LoanStatus.OVERDUE);
    }

    public Loan save(LoanRequest loanRequest){
        Member member = memberRepository.getReferenceById(loanRequest.getMemberId());
        Book book = bookRepository.getReferenceById(loanRequest.getBookId());
        Loan loan = Loan.builder()
                .member(member)
                .dueDate(loanRequest.getDueDate())
                .book(book)
                .status(LoanStatus.ACTIVE)
                .build();
        return loanRepository.save(loan);
    }

    public Loan returnBook(Long id){
      Loan loan =  loanRepository.findById(id).orElse(null);
      loan.setStatus(LoanStatus.RETURNED);
      return loanRepository.save(loan);
    }

    public void delete(Long id){
        boolean exists = loanRepository.existsById(id);
        if(!exists) throw new RuntimeException("Id not found");
        loanRepository.deleteById(id);
    }
}
