/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chloe.dvdlibrary.ui;

import com.chloe.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author User
 */
public class DvdLibraryView {
    //The view is responsible for all user interaction. No other component is allowed to
    //interact with the user.
    
    private UserIO io;
    //private UserIO io = new UserIOConsoleImpl();  //Removed this hard-coded reference so that its dependency is injected into the constructor
    
    
    //Constructor to initialise the IO member field
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add new DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List all DVDS ");
        io.print("5. Display DVD information");
        io.print("6. Exit");
        
        return io.readInt("Please select from the above choices.", 1,6);
    }
    
    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter the DVD title");
        String releaseDate = io.readString("Please enter the DVD release date");
        String MpaaRating = io.readString("Please enter the MPAA rating");
        String directorName = io.readString("Please enter the director's name");
        String userRating = io.readString("Please enter your rating of the DVD");
        String studio = io.readString("Please enter the DVD studio");
        
        //Instantiating a new DVD object using the title to satisfy the constructors requirements
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(MpaaRating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setUserRating(userRating);
        currentDvd.setStudio(studio);
        return currentDvd;
    }
    
    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");  
    }
    
    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created. Please hit enter to continue");
    }
    
    public void displayDvdList(List <Dvd> dvdList) {
        for (Dvd currentDvd: dvdList) {
            String dvdInfo = String.format("%s : %s : %s : %s : %s : %s", 
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getDirectorName(),
                    currentDvd.getUserRating(),
                    currentDvd.getStudio());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue");
    }
    public void displayDvdListBanner() {
        io.print("=== Display all DVDs ===");
    }
    
    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }
    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release date: " + dvd.getReleaseDate());
            io.print("MPAA rating: " + dvd.getMpaaRating());
            io.print("Director's name: " + dvd.getDirectorName());
            io.print("User rating: " + dvd.getUserRating());
            io.print("Studio: "+ dvd.getStudio());
        } else {
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }
    
    public void displayRemoveResult(Dvd dvdRecord) {
        if (dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good bye!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown command!");
    }
    
    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
        
    }
    public int printEditMenuAndGetSelection() {
        io.print("Which field do you want to change?");
        io.print("Edit DVD menu");
        io.print("1. Release date");
        io.print("2. MPAA rating");
        io.print("3. Director's name");
        io.print("4. User rating");
        io.print("5. Studio name");
        io.print("6. Exit edit menu");
        return io.readInt("Please select from the above choices.", 1,6);
    }
    
    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }
    
    public void displayNullDvd(){
        io.print("No such DVD");
    }

    public String getReleaseDate() {
        return io.readString("Please enter the new DVD release date.");
    }
    
    public void displayEditResult(){
        io.print("DVD Successfully edited.");
    }
    
    public String getMpaaRating() {
        return io.readString("Please enter the new DVD MPAA rating.");
    }
    
    public String getDirectorName() {
        return io.readString("Please enter the new director's name.");
    }
    
    public String getUserRating() {
        return io.readString("Please enter the new user rating.");
    }
    
    public String getStudioName() {
        return io.readString("Please enter the studio name.");
    }
    
//    public String getStudioAddress() {
//        return io.readString("Please enter the studio address.");
//    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
