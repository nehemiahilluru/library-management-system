package com.ty.springboot.library_management_system.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    @NotNull(message = "Member id is required")
    private Long memberId;

    @NotNull(message = "Book id is required")
    private Long bookId;

    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Please Provide a valid due date")
    private LocalDate dueDate;
}
