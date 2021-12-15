package com.example.library.repository;

import com.example.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepository extends CrudRepository<Title, Integer> {
    Title findById(int id);
}
