package com.example.baitap8.database;

import com.example.baitap8.models.Book;
import com.example.baitap8.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private final Logger log = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book1 = new Book("Bách khoa toàn thư","Trần Văn Khởi",500.0);
                Book book2 = new Book("Dế mèn phưu lưu kí", "Tô Hoài", 450);
                log.info("insert data"+ bookRepository.save(book1));
                log.info("insert data" + bookRepository.save(book2));
            }
        };
    }
}
