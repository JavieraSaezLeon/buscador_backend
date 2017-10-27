/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author javiera
 */
@Table(name = "BX_Books")
@Entity
public class BX_Books {
    
    @Id
    @Column(name = "ISBN")
    private String ISBN;
    private String Book_Title;
    private String Book_Author;
    private int Year_Of_Publication;
    private String Publisher;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBook_Title() {
        return Book_Title;
    }

    public void setBook_Title(String Book_Title) {
        this.Book_Title = Book_Title;
    }

    public String getBook_Author() {
        return Book_Author;
    }

    public void setBook_Author(String Book_Author) {
        this.Book_Author = Book_Author;
    }

    public int getYear_Of_Publication() {
        return Year_Of_Publication;
    }

    public void setYear_Of_Publication(int Year_Of_Publication) {
        this.Year_Of_Publication = Year_Of_Publication;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public BX_Books() {
    }
       
    
}
