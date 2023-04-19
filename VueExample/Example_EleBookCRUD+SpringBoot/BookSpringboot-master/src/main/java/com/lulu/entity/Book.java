package com.lulu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity实体原型注解
 */
@Entity
/**
 * Data自动生成方法
 */
@Data
public class Book {
    @Id
    /**
     * 设置id自增
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private String pages;
    private String price;

}
