package com.example.baitap8.controllers;

import com.example.baitap8.models.Book;
import com.example.baitap8.models.ReponseObject;
import com.example.baitap8.services.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Book")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<ReponseObject> getBooks(Pageable pageable) {
        Page<Book> bookList = bookService.getALLBooks(pageable);
        if(bookList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject("false","There are no elements in the list.",""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReponseObject("ok","Success",bookList));
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<ReponseObject> getIdBook(@PathVariable int id) {
        Optional book = bookService.getIdBook(id);
        if(book.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ReponseObject("false","There are no elements in the list.",""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ReponseObject("ok","Success",book.get()));
    }
    @PostMapping("/books")
    public ResponseEntity<ReponseObject> addBook(@RequestBody Book book) {
        List<Book> bookList = bookService.getBooksByTitle(book.getTitle());
        if(bookList.size()==0) {
            return ResponseEntity.status(HttpStatus.OK).body(new ReponseObject("ok","Insert success.",bookService.saveBook(book)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ReponseObject("false","Title already exists.",""));
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<ReponseObject> updateBook(@PathVariable int id,@RequestBody Book newBook) {
        List<Book> bookList =  bookService.getBooksById(id);
        if(bookList.size()==0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ReponseObject("ok","Insert success.",bookService.saveBook(newBook)));
        }
        bookService.updateBook(bookList.get(0),newBook);
        newBook.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ReponseObject("ok","Update success",newBook));
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<ReponseObject> deleteBook(@PathVariable int id) {
        List<Book> bookList = bookService.deleteBook(id);
        if(bookList.size()<=0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ReponseObject("false","Can not delete success.",""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ReponseObject("ok","Delete success",bookList.get(0)));
    }
}
