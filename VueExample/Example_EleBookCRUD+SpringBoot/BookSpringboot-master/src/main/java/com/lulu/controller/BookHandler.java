package com.lulu.controller;

import com.lulu.entity.Book;
import com.lulu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
/**
 * 运行启动类后
 * http://localhost:8181/book/findAll进行测试
 */

@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    /**
     * findAll分页重载
     * @PathVariable接口，调取前端参数{page}/{size}"
     * 测试：http://localhost:8181/book/findAll/2/6 查询第2页，并展示6条数据
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }

//    @GetMapping("/findAll")
//    public List<Book> findAll(){
//        return bookRepository.findAll();
//    }

    @PostMapping("/save")
    /**
     * @RequestBody json对象转换为java对象
     */
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
         bookRepository.deleteById(id);
    }
}
