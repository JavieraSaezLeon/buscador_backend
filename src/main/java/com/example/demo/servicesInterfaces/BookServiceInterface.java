/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicesInterfaces;

import com.example.demo.domain.BX_Books;
import com.example.demo.domain.Query;
import java.util.List;

/**
 *
 * @author javiera
 */
public interface BookServiceInterface {
    //paso2 
    public List<BX_Books>  getBooks(Query query);
    
    public List<BX_Books> getAll();
    
    public List<BX_Books> getAllByPublisher(Query query);
    
    public List<BX_Books> getAllByBooktitle(Query query);
    
    public List<BX_Books> getAllByBookauthor(Query query);
    
    public List<BX_Books> getAllByYear(Query query);
    
    public List<BX_Books> findAllByWord(String word);
    
    public List<BX_Books> findAllByLucene(String word);
    
}
