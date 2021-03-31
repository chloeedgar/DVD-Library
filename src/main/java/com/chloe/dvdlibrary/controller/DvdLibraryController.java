/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chloe.dvdlibrary.controller;

import com.chloe.dvdlibrary.dao.DvdLibraryDao;
import com.chloe.dvdlibrary.dao.DvdLibraryDaoException;
import com.chloe.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.chloe.dvdlibrary.dto.Dvd;
import com.chloe.dvdlibrary.ui.DvdLibraryView;
import com.chloe.dvdlibrary.ui.UserIO;
import com.chloe.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author User
 */
public class DvdLibraryController {
    //The controller orchestrates the work, it does not do any of the work itself.
    
    //With dependency injection:
    private DvdLibraryView view;
    private DvdLibraryDao dao;
    //Without dependency injection:
//    private DvdLibraryView view = new DvdLibraryView(); //Removed this hard-coded reference so that its dependency is injected into the constructor
//    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl(); //Removed this hard-coded reference so that its dependency is injected into the constructor

 //Dependency injection
    //The controller object should not be responsible for directly instantiating the
    //the implementation of any of its member fields that might have more than one
    // implementation(view and dao).
    
    //This is to ensure that the controller and view have no idea which implementation of DAO or 
    //UserIO they are using, ensuring the components are loosely coupled.
    
    
    //Constructor to initialise the dao and view fields
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        //Controller = "brains of the operation". Knows what needs to be done, when it needs
        //to be done and what needs to be done, and what component can do it.
        //It acts as a general contractor, directoring work but never doing the work itself.
        //The controller can talk with the DAO and the view.
        this.dao = dao;
        this.view = view;
    }
    
    
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                        case 1:
                            createDvd();
                            //System.out.println("create");
                            break;
                        case 2:
                            removeDvd();
                            //System.out.println("remove");
                            break;
                        case 3:
                            editDvd();
                            //System.out.println("edit");
                            break;
                        case 4:
                            listDvds();
                            //System.out.println("list all");
                            break;
                        case 5:
                            getDvd();
                            //System.out.println("display DVD info");
                            break;
                        case 6:
                            //System.out.println("exiting");
                            keepGoing = false;
                            break;
                        default:
                            //io.print("Unknown command!");
                            unknownCommand();
                }
            }
            //io.print("exit");
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void createDvd()throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(),newDvd);
        view.displayCreateSuccessBanner();
    }
    private void listDvds() throws DvdLibraryDaoException {
        view.displayDvdListBanner();
        List <Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    private void getDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }
    private void removeDvd() throws DvdLibraryDaoException  {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }
    private void exitMessage() {
        view.displayExitBanner();
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void editDvd() throws DvdLibraryDaoException  {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvdToEdit = dao.getDvd(title);
        if (dvdToEdit==null) {
            view.displayNullDvd();
        } else {
            view.displayDvd(dvdToEdit);
            int editMenuSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                editMenuSelection = view.printEditMenuAndGetSelection();

                switch (editMenuSelection){
                    case 1:
                        //System.out.println("1. Release date");
                        editReleaseDate(title);
                        break;
                    case 2:
                        //System.out.println("2. MPAA rating");
                        editMpaaRating(title);
                        break;
                    case 3:
                        //System.out.println("3. Director's name");
                        editDirectorName(title);
                        break;
                    case 4:
                        //System.out.println("4. User rating");
                        editUserRating(title);
                        break;
                    case 5:
                        //System.out.println("5. Studio name");
                        editStudioName(title);
                        break;
                    case 6:
                        //System.out.println("6. Exit");
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                if (keepGoing == false) {
                    break;
            } 
        }
        }
    }
     

    private void editReleaseDate(String title) throws DvdLibraryDaoException {
        view.displayEditReleaseDateBanner();
        String newReleaseDate = view.getReleaseDate();
        Dvd editedDvd = dao.changeReleaseDate(title, newReleaseDate);
        view.displayEditResult();
    }
    private void editMpaaRating(String title) throws DvdLibraryDaoException {
        //view.displayEditMpaaRatingBanner();
        String newMpaaRating = view.getMpaaRating();
        Dvd editedDvd = dao.changeMpaaRating(title, newMpaaRating);
        view.displayEditResult();
    }
    private void editDirectorName(String title) throws DvdLibraryDaoException {
        //view.displayEditDirectorNameBanner();
        String newDirectorName = view.getDirectorName();
        Dvd editedDvd = dao.changeDirectorName(title, newDirectorName);
        view.displayEditResult();
    }
    private void editUserRating(String title) throws DvdLibraryDaoException {
        String newUserRating = view.getUserRating();
        Dvd editedDvd = dao.changeUserRating(title, newUserRating);
        view.displayEditResult();
    }
    private void editStudioName(String title) throws DvdLibraryDaoException {
        String newStudioName = view.getStudioName();
        Dvd editedDvd = dao.changeStudioName(title, newStudioName);
        view.displayEditResult();
    }

}