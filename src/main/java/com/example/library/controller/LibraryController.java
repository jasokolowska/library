package com.example.library.controller;

import com.example.library.domain.*;
import com.example.library.mapper.BookMapper;
import com.example.library.mapper.BorrowingMapper;
import com.example.library.mapper.ReaderMapper;
import com.example.library.mapper.TitleMapper;
import com.example.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    private final ReaderMapper readerMapper;
    private final BorrowingMapper borrowingMapper;
    private final TitleMapper titleMapper;

    @PostMapping(value = "rentBook")
    public BorrowingDto rentBook(@RequestParam int readerId, @RequestParam int bookId) {
        Borrowing borrowing = service.rentBook(bookId, readerId);
        return borrowingMapper.mapToBorrowingDto(borrowing);
    }

    @PutMapping(value = "returnBook")
    public BorrowingDto returnBook(int bookId){
        return borrowingMapper.mapToBorrowingDto(service.returnBook(bookId));
    }

    @GetMapping(value="getBooks")
    public List<BookDto> getBooks() {
        List<Book> books = service.getAllBooks();
        return bookMapper.mapToBookDtoList(books);
    }

    @GetMapping(value="getBook")
    public BookDto getBook(@RequestParam int bookId){
        return bookMapper.mapToBookDto(
                service.getBook(bookId)
        );
    }

    @PostMapping(value = "addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        service.saveBook(book);
    }

    @PutMapping(value="updateBookStatus")
    public BookDto updateBookStatus(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Book savedBook = service.saveBook(book);
        return bookMapper.mapToBookDto(savedBook);
    }


    @GetMapping(value="getReaders")
    public List<ReaderDto> getReaders() {
        List<Reader> readers = service.getAllReaders();
        return readerMapper.mapToReaderDtoList(readers);
    }

    @GetMapping(value="getReader")
    public ReaderDto getReader(@RequestParam int readerId){
        return readerMapper.mapToReaderDto(
                service.getReader(readerId)
        );
    }

    @PostMapping(value = "addReader", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        service.saveReader(reader);
    }

    @PostMapping(value = "addBorrowing", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBorrowing(@RequestBody BorrowingDto borrowingDto) {
        Borrowing borrowing = borrowingMapper.mapToBorrowing(borrowingDto);
        service.saveBorrowing(borrowing);
    }

    @PutMapping(value="updateReturnDate")
    public BorrowingDto updateBookStatus(@RequestBody BorrowingDto borrowingDto) {
        Borrowing borrowing = borrowingMapper.mapToBorrowing(borrowingDto);
        Borrowing updatedReturn = service.saveBorrowing(borrowing);
        return borrowingMapper.mapToBorrowingDto(updatedReturn);
    }

    @PostMapping(value = "addTitle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        service.saveTitle(title);
    }


}
