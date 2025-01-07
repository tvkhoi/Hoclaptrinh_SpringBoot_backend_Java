package com.example.baitap8.services;

import com.example.baitap8.models.Book;
import com.example.baitap8.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IsstorageSevice{

    BookRepository repository;
    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    @Override
    public Page<Book> getALLBooks(Pageable pageable) {
        return repository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public Optional<Book> getIdBook(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return repository.findBookByTitle(title);
    }
    @Override
    public Object saveBook(Book book) {
        return repository.save(book);
    }
    @Override
    public List<Book> getBooksById(int id) {
        return repository.findBookById(id);
    }
    @Override
    public void updateBook(Book oldBook, Book newBook) {
        oldBook.setTitle(newBook.getTitle());
        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setPrice(newBook.getPrice());
        repository.save(oldBook);
    }
    @Override
    public List<Book> deleteBook(int id) {
        List<Book> bookList = repository.findBookById(id);
        if(bookList.size() > 0) {
            repository.deleteById(id);
            return bookList;
        }
        return bookList;
    }
}
