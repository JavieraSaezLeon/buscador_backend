/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicesInterfaces;

import com.example.demo.domain.BX_Books;
import java.util.List;

/**
 *
 * @author javiera
 */
public interface BookServiceInterface {
     
    public List<BX_Books>  getBooks(String query);
    
}
