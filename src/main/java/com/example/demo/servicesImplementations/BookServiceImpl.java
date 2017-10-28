/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicesImplementations;

import com.example.demo.domain.BX_Books;
import com.example.demo.domain.Query;
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
    //paso3
    @Autowired
    BookRepositoryInterface bookRepositoryInterface;
    @Override
    public List<BX_Books> getBooks(Query query) {
        
        System.out.println("Query " + query.getQuery());
        BX_Books book = bookRepositoryInterface.findOne(query.getQuery());
        System.out.println(book.getBooktitle());
        List<BX_Books> books = new ArrayList<BX_Books>();
        books.add(book);
        return books;
    }
    
    @Override
    public List<BX_Books> getAll() {
        List<BX_Books> books = bookRepositoryInterface.findAll();
        return books;
    }

    @Override
    public List<BX_Books> getAllByPublisher(Query query) {
        List<BX_Books> books = bookRepositoryInterface.findAllByPublisher(query.getQuery());
        return books;
    }

    @Override
    public List<BX_Books> getAllByBooktitle(Query query) {
        List<BX_Books> books = bookRepositoryInterface.findAllByBooktitle(query.getQuery());
        return books;    
    }

    @Override
    public List<BX_Books> getAllByBookauthor(Query query) {
        List<BX_Books> books = bookRepositoryInterface.findAllByBookauthor(query.getQuery());
        return books;   
    }

    @Override
    public List<BX_Books> getAllByYear(Query query) {
        List<BX_Books> books = bookRepositoryInterface.findAllByYearofpublication(query.getYear());
        return books;
    }

    @Override
    public List<BX_Books> findAllByWord(String word) {
        List<BX_Books> books = bookRepositoryInterface.findAll();
        List<BX_Books> responseBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBooktitle().contains(word)) {
                responseBooks.add(books.get(i));
            }
        }
        return responseBooks;
    }
    
}
