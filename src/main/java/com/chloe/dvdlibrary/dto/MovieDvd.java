/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chloe.dvdlibrary.dto;

/**
 *
 * @author User
 */
public class MovieDvd extends Dvd {
    //Example of inheritance - the mechanism by which one class (child/subclass) is 
    //allowed to inherit the features (fields and methods another class (parent/super/base class)
    //Here, DVD is the base class and MovieDvd is the subclass. 
    //Inheritance allows us to express an is-a relationship. TvShowDVD is a DVD, but with a few more
    //features.
    
    String genre;

    public MovieDvd(String title) {
        super(title);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
