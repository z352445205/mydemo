package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhengyn
 * @description
 * @create 21/2/24 18:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class EsEntity<T> {

    private String id;
    private T data;




}