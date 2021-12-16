package com.example.library.service;

import com.example.library.domain.*;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowingRepository;
import com.example.library.repository.ReaderRepository;
import com.example.library.repository.TitleRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class DbService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final BorrowingRepository borrowingRepository;
    private final TitleRepository titleRepository;

    public Borrowing rentBook(int bookId, int readerId) {
        Book book = bookRepository.findById(bookId);
        book.setStatus(Status.RENT);
        Borrowing borrowing = new Borrowing();
        borrowing.setBook(book);
        borrowing.setReader(readerRepository.findById(readerId));
        borrowing.setBorrowDate(new Date());
        borrowingRepository.save(borrowing);
        return borrowing;
    }

    public Borrowing returnBook(int bookId) {
        Book book = bookRepository.findById(bookId);
        book.setStatus(Status.AVAILABLE);
        bookRepository.save(book);
        Borrowing borrowing = borrowingRepository.findByBook_Id(bookId);
        borrowing.setReturnDate(new Date());
        borrowingRepository.save(borrowing);
        return borrowing;
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Title saveTitle (Title title) {
        return titleRepository.save(title);
    }

    public Book saveBook (Book book) {
        return bookRepository.save(book);
    }

    public Borrowing saveBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public Reader getReader (int id) {
        return readerRepository.findById(id);
    }

    public Book getBook (int id) {
        return bookRepository.findById(id);
    }

    public Title getTitle (int id) {
        return titleRepository.findById(id);
    }

    public Optional<Borrowing> getBorrowing (int id) {
        return borrowingRepository.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

}
