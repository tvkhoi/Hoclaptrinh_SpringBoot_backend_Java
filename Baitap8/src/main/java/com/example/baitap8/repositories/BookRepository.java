package com.example.baitap8.repositories;

import com.example.baitap8.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByTitle(String title);
    List<Book> findBookById(int id);

    Page<Book> findAll(Pageable pageable);
}
