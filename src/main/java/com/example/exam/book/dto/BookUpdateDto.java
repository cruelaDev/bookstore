package com.example.exam.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.AdviceName;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateDto {
    private String title;
    private String description;
    private String author;
    private double price;
}
