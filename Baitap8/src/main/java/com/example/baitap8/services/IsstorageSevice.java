package com.example.baitap8.services;

import com.example.baitap8.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IsstorageSevice {
    Page<Book> getALLBooks(Pageable pageable);
    Optional<Book> getIdBook(int id);
    List<Book> getBooksByTitle(String author);
    Object saveBook(Book book);
    List<Book> getBooksById(int id);

    void updateBook(Book oldBook, Book newBook);

    List<Book> deleteBook(int id);
}
