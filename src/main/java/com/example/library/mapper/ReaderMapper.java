package com.example.library.mapper;

import com.example.library.domain.Book;
import com.example.library.domain.BookDto;
import com.example.library.domain.Reader;
import com.example.library.domain.ReaderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getCreation(),
                readerDto.getBorrowings()
        );
    }

    public ReaderDto mapToReaderDto (final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getCreation(),
                reader.getBorrowings()
        );
    }

    public List<ReaderDto> mapToBookDtoList (final List<Reader> reader) {
        return reader.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
