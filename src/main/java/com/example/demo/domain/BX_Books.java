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
@Table(name = "bx_books")
@Entity
public class BX_Books {
    
    @Id
    @Column(name = "isbn")
    private String isbn;
    private String booktitle;
    private String bookauthor;
    private int yearofpublication;
    private String publisher;
    private String imageurls;
    private String imageurlm;
    private String imageurll;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public int getYearofpublication() {
        return yearofpublication;
    }

    public void setYearofpublication(int yearofpublication) {
        this.yearofpublication = yearofpublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageurls() {
        return imageurls;
    }

    public void setImageurls(String imageurls) {
        this.imageurls = imageurls;
    }

    public String getImageurlm() {
        return imageurlm;
    }

    public void setImageurlm(String imageurlm) {
        this.imageurlm = imageurlm;
    }

    public String getImageurll() {
        return imageurll;
    }

    public void setImageurll(String imageurll) {
        this.imageurll = imageurll;
    }

    
    public BX_Books() {
    }
       
    
}
