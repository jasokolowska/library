package com.example.library.repository;

import com.example.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ReaderRepository extends CrudRepository<Reader, Integer> {
    List<Reader> findByLastName(String lastName);
    List<Reader> findAll();
    Reader findById(int id);
}
