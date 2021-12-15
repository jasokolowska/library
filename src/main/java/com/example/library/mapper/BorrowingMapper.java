package com.example.library.mapper;

import com.example.library.domain.Borrowing;
import com.example.library.domain.BorrowingDto;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowingMapper {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private BookRepository bookRepository;

    public Borrowing mapToBorrowing (final BorrowingDto borrowingDto) {
        return new Borrowing(
                borrowingDto.getId(),
                bookRepository.findById(borrowingDto.getBookId()),
                readerRepository.findById(borrowingDto.getReaderId()),
                borrowingDto.getBorrowDate()
        );
    }

    public BorrowingDto mapToBorrowingDto (final Borrowing borrowing) {
        return new BorrowingDto(
                borrowing.getId(),
                borrowing.getBook().getId(),
                borrowing.getReader().getId(),
                borrowing.getBorrowDate(),
                borrowing.getReturnDate()
        );
    }


}
