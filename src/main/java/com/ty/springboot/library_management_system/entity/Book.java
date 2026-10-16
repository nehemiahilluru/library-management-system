package com.ty.springboot.library_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,unique = true)
    private String isbn;

    @Column(nullable = false)
    private Integer publishedYear;

    private Integer totalCopies=1;

    private Integer availableCopies=1;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

}
