package com.example.exam.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDto {
    private String title;
    private String description;
    private String author;
    private double price;
}
