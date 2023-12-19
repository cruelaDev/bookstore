package com.example.exam.book;

import com.example.exam.book.dto.BookCreateDto;
import com.example.exam.book.dto.BookUpdateDto;
import com.example.exam.book.entity.Book;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository repository;

    public List<Book> getAll() {
        return repository.findAll();
    }

    public void create(BookCreateDto createDto) {
        Book book = new Book(null, createDto.getTitle(), createDto.getDescription(), createDto.getAuthor(), createDto.getPrice());
        repository.save(book);
    }

    public void delete(Integer id) {
        if (!(repository.existsById(id))) {
            throw new EntityNotFoundException();
        }
        repository.deleteById(id);
    }

    public void update(Integer id, BookUpdateDto updateDto) {
        Book book = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        book.setTitle(updateDto.getTitle());
        book.setDescription(updateDto.getDescription());
        book.setAuthor(updateDto.getAuthor());
        book.setPrice(updateDto.getPrice());
    }
}
