package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowingRepository;
import com.example.library.repository.ReaderRepository;
import com.example.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final BorrowingRepository borrowingRepository;
    private final TitleRepository titleRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
