package com.example.library.mapper;

import com.example.library.domain.Book;
import com.example.library.domain.BookDto;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getStatus(),
                bookDto.getTitle()
        );
    }

    public BookDto mapToBookDto (final Book book) {
        return new BookDto(
                book.getId(),
                book.getStatus(),
                book.getTitle()
        );
    }
}
