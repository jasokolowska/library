package com.example.library.mapper;

import com.example.library.domain.Title;
import com.example.library.domain.TitleDto;
import com.example.library.repository.TitleRepository;
import org.springframework.stereotype.Service;


@Service
public class TitleMapper {

    private TitleRepository titleRepository;

    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear()
        );
    }

    public TitleDto mapToTitleDto (final Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }

}
