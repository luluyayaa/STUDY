package com.lulu;

import com.lulu.entity.Book;
import com.lulu.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 自带测试类
 */
@SpringBootTest
class SpringboottestApplicationTests {
    private  BookRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void save() {
        Book book = new Book();
        book.setName("Spring Boot");
        book.setAuthor("张三");
        Book book1 =  repository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById() {
        Book book = repository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(120);
        book.setName("aaa");
        Book book1 = repository.save(book);
        System.out.println(book1);
    }
}
