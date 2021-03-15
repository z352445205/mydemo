package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhengyn
 * @description
 * @create 21/2/25 11:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;
    private String name;
}
