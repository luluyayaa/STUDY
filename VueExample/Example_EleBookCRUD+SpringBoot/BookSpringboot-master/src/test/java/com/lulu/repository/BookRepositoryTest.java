package com.lulu.repository;

import com.lulu.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class BookRepositoryTest {
    /**
     * 自动注入
     */
    @Autowired
    private BookRepository bookRepository;

    /**
     * 每写一个Repository在此测试
     */
    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }

}