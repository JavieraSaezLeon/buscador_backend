/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicesImplementations;

import com.example.demo.domain.BX_Books;
import com.example.demo.repositoriesInterface.BookRepositoryInterface;
import com.example.demo.servicesInterfaces.BookServiceInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javiera
 */
@Service
public class BookServiceImpl implements BookServiceInterface{

    @Autowired
    BookRepositoryInterface bookRepositoryInterface;
    @Override
    public List<BX_Books> getBooks(String query) {
        
        BX_Books book = bookRepositoryInterface.findByPublisher(query);
        
        List<BX_Books> books = new ArrayList<BX_Books>();
        System.out.println("nombre"+ bookRepositoryInterface.findOne(query));
        books.add(book);
        return books;
    }
    
  
    
}
