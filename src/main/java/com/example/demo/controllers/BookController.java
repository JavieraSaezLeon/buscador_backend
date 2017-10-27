/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.domain.BX_Books;
import com.example.demo.servicesImplementations.BookServiceImpl;
import com.example.demo.servicesInterfaces.BookServiceInterface;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author javiera
 */
@RestController
public class BookController {
    //Instancia la clase, inyeccion de dependencia
    @Autowired
    BookServiceInterface bookServiceInterface;
    //Crea un metodo post
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/books")
    public List<BX_Books> register(@RequestBody String query) {
        List<BX_Books> books = bookServiceInterface.getBooks(query);
        return books;
    }
    
}
