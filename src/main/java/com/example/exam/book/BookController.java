package com.example.exam.book;

import com.example.exam.book.dto.BookCreateDto;
import com.example.exam.book.dto.BookUpdateDto;
import com.example.exam.book.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    @GetMapping
    public String getAll(Model model) {
        List<Book> books = service.getAll();
        model.addAttribute("books", books);
        return "book/books";
    }

    @PostMapping
    public String create(@ModelAttribute BookCreateDto createDto) {
        service.create(createDto);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/books";
    }

    @PutMapping("/{id}/update")
    public String update(@PathVariable Integer id, @ModelAttribute BookUpdateDto updateDto) {
        service.update(id, updateDto);
        return "redirect:/books";
    }
}
