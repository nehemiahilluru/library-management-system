package com.ty.springboot.library_management_system.entity;

import com.ty.springboot.library_management_system.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate loanDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate returnDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status ;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Book book;

    @PrePersist
    public void setLoanDate(){
        this.loanDate=LocalDate.now();
    }

}
