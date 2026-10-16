package com.ty.springboot.library_management_system.repository;

import com.ty.springboot.library_management_system.entity.Loan;
import com.ty.springboot.library_management_system.enums.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findByMemberId(Long id);
    List<Loan> findByBookId(Long id);

    List<Loan> findByStatus(LoanStatus status);

}
