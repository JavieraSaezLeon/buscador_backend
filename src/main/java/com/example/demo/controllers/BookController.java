/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.domain.BX_Books;
import com.example.demo.domain.Query;
import com.example.demo.servicesInterfaces.BookServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
    //paso4
    //Instancia la clase, inyeccion de dependencia
    @Autowired
    BookServiceInterface bookServiceInterface;
    //Crea un metodo post
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/books/id")
    public List<BX_Books> getById(@RequestBody Query query) {
        List<BX_Books> books = bookServiceInterface.getBooks(query);
        return books;
    }
    
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "/books")
    public List<BX_Books> getAll() {
        List<BX_Books> books = bookServiceInterface.getAll();
        return books;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/books/publisher")
    public List<BX_Books> getByPublisher(@RequestBody Query query) {
        List<BX_Books> books = bookServiceInterface.getAllByPublisher(query);
        return books;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/books/title")
    public List<BX_Books> getByTitle(@RequestBody Query query) {
        List<BX_Books> books = bookServiceInterface.getAllByBooktitle(query);
        return books;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/books/author")
    public List<BX_Books> getByAuthor(@RequestBody Query query) {
        List<BX_Books> books = bookServiceInterface.getAllByBookauthor(query);
        return books;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/books/year")
    public List<BX_Books> getByYear(@RequestBody Query query) {
        List<BX_Books> books = bookServiceInterface.getAllByYear(query);
        return books;
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/books/word")
    public List<BX_Books> getByWord(@RequestBody Query query) {
        List<BX_Books> books = bookServiceInterface.findAllByWord(query.getQuery());
        return books;
    }
}
