/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chloe.dvdlibrary;

import com.chloe.dvdlibrary.controller.DvdLibraryController;
import com.chloe.dvdlibrary.dao.DvdLibraryDao;
import com.chloe.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.chloe.dvdlibrary.dto.Dvd;
import com.chloe.dvdlibrary.ui.DvdLibraryView;
import com.chloe.dvdlibrary.ui.UserIO;
import com.chloe.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author User
 */
public class App {
    public static void main(String[] args) {
          //Dependency injection
          //Code below ensures that the App class configures, instantiates and assembles the classes in the application.
          //An object should not be responsible for directly instantiating the
          //the implementation of any of its member fields that might have more than 
          //one implementation.
          //The App class acts as the application assembler, it chooses the implementations of the dependencies and 
          //wires them together.
          UserIO myIo = new UserIOConsoleImpl();
          DvdLibraryView myView = new DvdLibraryView(myIo);
          DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
          DvdLibraryController controller = new DvdLibraryController(myDao, myView);

          controller.run();        

       


    }
}






          
//        DvdLibraryController controller = new DvdLibraryController();
//        controller.run();
//          Dvd dvd1 = new Dvd("The Shawshank Redemption","17-Feb-1995","15", "Frank Darabont", "9.3");
//          Dvd dvd2 = new Dvd("Schlinder's List","18-Feb-1994","15", "Steven Spielberg", "9.3");
//          Dvd dvd3 = new Dvd("Forrest Gump","07-Oct-1994","12", "Robert Zemeckis", "8.8");
//          Dvd dvd4 = new Dvd("Mean Girls","18-Jun-2004","12A", "Mark Waters", "7.0");
//          Dvd dvd5 = new Dvd("Greenland","05-Feb-2021","15", "Ric Roman Waugh", "6.4");
//          Dvd dvd6 = new Dvd("The Big Short","22-Jan-2016","15", "Adam McKay", "7.8");