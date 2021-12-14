package com.example.library.controller;

import com.example.library.domain.*;
import com.example.library.mapper.BookMapper;
import com.example.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/v1/library")
@RequiredArgsConstructor
public class LibraryController {

    private final DbService service;
    private final BookMapper bookMapper;

    @RequestMapping(value="getBooks", method = RequestMethod.GET)
    public List<BookDto> getBooks() {
        List<Book> books = service.getAllBooks();
        return bookMapper.mapToBookDtoList(books);
    }

    @RequestMapping(value="getBook", method = RequestMethod.GET)
    public BookDto getBook(int bookId) {
        return new BookDto(1, Status.AVAILABLE, new Title());
    }

    @PostMapping(value = "addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto addBook(BookDto bookDto) {
        return new BookDto(1, Status.AVAILABLE, new Title());
    }

    @RequestMapping(value="updateBookStatus", method = RequestMethod.PUT)
    public BookDto updateBookStatus(BookDto bookDto) {
        return new BookDto(1, Status.AVAILABLE, new Title());
    }

    @RequestMapping(value="getReaders", method = RequestMethod.GET)
    public List<Reader> getReaders() {
        return new ArrayList<>();
    }

    @RequestMapping(value="getReader", method = RequestMethod.GET)
    public ReaderDto getReader(int readerId) {
        return new ReaderDto(1, "joanna", "sokolowska", new Date(), new HashSet<>());
    }

    @PostMapping(value = "addReader", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ReaderDto addReader(ReaderDto readerDto) {
        return new ReaderDto(1, "joanna", "sokolowska", new Date(), new HashSet<>());
    }

}
