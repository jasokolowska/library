package com.example.library.repository;

import com.example.library.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Integer> {
}
