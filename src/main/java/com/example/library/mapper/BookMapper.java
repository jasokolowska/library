package com.example.library.mapper;

import com.example.library.domain.Book;
import com.example.library.domain.BookDto;
import com.example.library.domain.Title;
import com.example.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper {

    @Autowired
    private TitleRepository titleRepository;

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getStatus(),
                titleRepository.findById(bookDto.getTitleId())
        );
    }

    public BookDto mapToBookDto (final Book book) {
        return new BookDto(
                book.getId(),
                book.getStatus(),
                book.getTitle().getId()
        );
    }

    public List<BookDto> mapToBookDtoList (final List<Book> books) {
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
