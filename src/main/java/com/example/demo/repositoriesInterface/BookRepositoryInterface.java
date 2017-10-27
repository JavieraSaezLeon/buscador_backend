/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositoriesInterface;

import com.example.demo.domain.BX_Books;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author javiera
 */
public interface BookRepositoryInterface extends JpaRepository<BX_Books, String>{
    
    BX_Books findByPublisher(String publisher);
    
}
