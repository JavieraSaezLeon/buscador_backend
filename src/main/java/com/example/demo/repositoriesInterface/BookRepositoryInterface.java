/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositoriesInterface;

import com.example.demo.domain.BX_Books;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author javiera
 */
public interface BookRepositoryInterface extends JpaRepository<BX_Books, String>{
    //ultima capa (paso 1)
    List<BX_Books> findAllByPublisher(String publisher);
    
    List<BX_Books> findAllByBooktitle(String booktitle);
    
    List<BX_Books> findAllByBookauthor(String bookauthor);
    
    List<BX_Books> findAllByYearofpublication(int yearofpublication);
        
}
