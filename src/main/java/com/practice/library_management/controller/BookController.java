package com.practice.library_management.controller;

import com.practice.library_management.models.dto.book.CreateBookDto;
import com.practice.library_management.services.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {this.bookService = bookService;}
    @PostMapping
    public String createBook(@RequestBody CreateBookDto createBookDto) throws Exception {
        this.bookService.createBook(createBookDto);
        return "Sucessfully created";
    }

}
