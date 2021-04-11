///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.chloe.dvdlibrary.dao;
//
//import com.chloe.dvdlibrary.dto.Dvd;
//import java.io.FileWriter;
//import java.time.LocalDate;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
///**
// *
// * @author User
// */
//public class DvdLibraryDaoFileImplTest {
//    DvdLibraryDao testDao;   //confused at why we are using the interface.
//    
//    public DvdLibraryDaoFileImplTest() {
//    }
//    
////    @BeforeAll
////    public static void setUpClass() {
////        //run once before the test class is instantiated and can be used to set up external resources.
////    }
////    
////    @AfterAll
////    public static void tearDownClass() {
////        //Run once after all of the tests have been run and can be used to clean up external resources.
////    }
//    
//    @BeforeEach
//    public void setUp() throws Exception {
//        //non-static method, is run once before each test method in the JUnit test class. It can be used
//        //to clean up after each test.
//        //used to put the system into a known good state before each test. Need to ensure we aren't messing up
//        //production data. 
//        String testFile = "testLibrary.txt";
//        //use the FileWriter to quickly blank the file
//        new FileWriter(testFile);
//        testDao = new DvdLibraryDaoFileImpl(testFile); //initilising the DAO 
//        //this ensures we are starting with a fresh, empty DAO object
//    }
//    
////    @AfterEach
////    public void tearDown() {
////        //non-static method, run once after each test method in the JUnit test completes. It can be used
////        //to clean up after each test.
////    }
//
//    @Test
//    public void testAddGetDvd() throws Exception {
//        //Create our method test inputs
//        String testFile = "testLibrary.txt";
//        //use the FileWriter to quickly blank the file
//        new FileWriter(testFile);
//        testDao = new DvdLibraryDaoFileImpl(testFile); //initilising the DAO 
//        //this ensures we are starting with a fresh, empty DAO object
//        
//        String title = "Movie title 1";
//        Dvd dvd = new Dvd(title);
//        dvd.setDirectorName("Director name");
//        dvd.setMpaaRating("12A");
//        dvd.setReleaseDate(LocalDate.parse("23-Mar-20"));  /// THIS IS WRONG FORMAT?
//        dvd.setStudio("studio name");
//        dvd.setUserRating("10");
//        
//        //Add the DVD to the DAO
//        testDao.addDvd(title, dvd);
//        //Get the DVD from the DAO
//        Dvd retrievedDvd = testDao.getDvd(title);
//        
//        //Check if the data is equal
//        assertEquals(dvd, retrievedDvd);
//        //Example different- checks every value?
//        
//        
//    }
//    @Test
//    public void testAddGetAllDvds() throws Exception {
//        String testFile = "testLibrary.txt";
//        //use the FileWriter to quickly blank the file
//        new FileWriter(testFile);
//        testDao = new DvdLibraryDaoFileImpl(testFile); //initilising the DAO 
//        //this ensures we are starting with a fresh, empty DAO object
//        
//        //Create DVD 1
//        String title1 = "Movie title 1";
//        Dvd dvd1 = new Dvd(title1);
//        dvd1.setDirectorName("Director name");
//        dvd1.setMpaaRating("12A");
//        dvd1.setReleaseDate("23-Mar-20");
//        dvd1.setStudio("studio name");
//        dvd1.setUserRating("10");
//        //Create DVD 2
//        String title2 = "Movie title 2";
//        Dvd dvd2 = new Dvd(title2);
//        dvd2.setDirectorName("Director name2");
//        dvd2.setMpaaRating("12A - 2");
//        dvd2.setReleaseDate("23-Mar-20 - 2");
//        dvd2.setStudio("studio name - 2");
//        dvd2.setUserRating("10 - 2");
//        
//        //Add both to the DAO
//        testDao.addDvd(title1, dvd1);
//        testDao.addDvd(title2, dvd2);
//        
//        //Retrieve the list of all the DVDs in the DAO
//        List <Dvd> dvdList = testDao.getAllDvds();
//        
//        //First check the general contents of the list - not empty and contains two
//        assertNotNull(dvdList, "The list of DVDs should not be null");
//        assertEquals(2, dvdList.size(), "There should be two DVDs in the list");
//        
//        //Then the specifics
//        assertTrue(dvdList.contains(dvd1), "The DVD list should contain dvd1");
//        assertTrue(dvdList.contains(dvd2), "The DVD list should contain dvd2");
//        
//    }
//    
//    @Test
//    public void testRemoveStudent() throws Exception {
//        String testFile = "testLibrary.txt";
//        //use the FileWriter to quickly blank the file
//        new FileWriter(testFile);
//        testDao = new DvdLibraryDaoFileImpl(testFile); //initilising the DAO 
//        //this ensures we are starting with a fresh, empty DAO object
//        
//        //Create DVD 1
//        String title1 = "Movie title 1";
//        Dvd dvd1 = new Dvd(title1);
//        dvd1.setDirectorName("Director name");
//        dvd1.setMpaaRating("12A");
//        dvd1.setReleaseDate("23-Mar-20");
//        dvd1.setStudio("studio name");
//        dvd1.setUserRating("10");
//        //Create DVD 2
//        String title2 = "Movie title 2";
//        Dvd dvd2 = new Dvd(title2);
//        dvd2.setDirectorName("Director name2");
//        dvd2.setMpaaRating("12A - 2");
//        dvd2.setReleaseDate("23-Mar-20 - 2");
//        dvd2.setStudio("studio name - 2");
//        dvd2.setUserRating("10 - 2");
//        
//        //Add both to the DAO
//        testDao.addDvd(title1, dvd1);
//        testDao.addDvd(title2, dvd2);
//        
//        //Remove the first DVD - dvd1
//        Dvd removedDvd = testDao.removeDvd(title1);
//        
//        //check that the correct DVD was removed
//        assertEquals(dvd1, removedDvd, "The removed dvd should be dvd1");
//        
//        //Get all the DVDs
//        List <Dvd> dvdList = testDao.getAllDvds();
//        
//        //First check the general contents of the list
//        assertNotNull(dvdList,"The DVD list should not be null");
//        assertEquals(dvdList.size(), 1, "The DVD list should contain 1 DVD");
//        
//        //Then the specifics
//        assertFalse(dvdList.contains(dvd1),"The DVD list should not contain dvd1");
//        assertTrue(dvdList.contains(dvd2), "The DVD list should contain dvd2");
//        
//        //Remove the second student
//        Dvd removedDvd2 = testDao.removeDvd(title2);
//        
//        //check that the correct DVD was removed
//        assertEquals(dvd2, removedDvd2, "The removed dvd should be dvd2");
//        
//        //Get all the DVDs
//        List <Dvd> dvdList2 = testDao.getAllDvds();
//        
//        assertTrue(dvdList2.isEmpty(),"The DVD list should be empty");
//       
//        //Try to get both students by their old id - should be null
//        Dvd retrievedDvd = testDao.getDvd(title1);
//        assertNull(retrievedDvd, "Dvd1 was removed, should be null");
//
//        Dvd retrievedDvd2 = testDao.getDvd(title2);
//        assertNull(retrievedDvd2, "Dvd2 was removed, should be null");
//       
//    }
//    @Test
//    public void testAddChangeDirectorName() throws Exception {
//        String testFile = "testLibrary.txt";
//        //use the FileWriter to quickly blank the file
//        new FileWriter(testFile);
//        testDao = new DvdLibraryDaoFileImpl(testFile); //initilising the DAO 
//        //this ensures we are starting with a fresh, empty DAO object
//        
//        //Create DVD 1
//        String title1 = "Movie title 1";
//        Dvd dvd1 = new Dvd(title1);
//        dvd1.setDirectorName("Director name");
//        dvd1.setMpaaRating("12A");
//        dvd1.setReleaseDate("23-Mar-20");
//        dvd1.setStudio("studio name");
//        dvd1.setUserRating("10");
//        //Create DVD 2
//        String title2 = "Movie title 2";
//        Dvd dvd2 = new Dvd(title2);
//        dvd2.setDirectorName("Director name2");
//        dvd2.setMpaaRating("12A - 2");
//        dvd2.setReleaseDate("23-Mar-20 - 2");
//        dvd2.setStudio("studio name - 2");
//        dvd2.setUserRating("10 - 2");
//        
//        //Add both to the DAO
//        testDao.addDvd(title1, dvd1);
//        testDao.addDvd(title2, dvd2);
//        
//        //Change the director name for dvd1
//        String newDirectorName = "new name";
//        testDao.changeDirectorName(title1, newDirectorName);
//        
//        //Check that the correct DVD had it's name changed
//        //Check that the dvd2 did not change
//        assertEquals(testDao.getDvd(title2).getDirectorName(), "Director name2","Dvd2 director should be Director name2 ");
//        //Check that DVD 1 has been changed to the correct name
//        assertEquals(testDao.getDvd(title1).getDirectorName(),"new name", "Dvd1 director should be new name");
//        //to get this to work I had to use the testDao.get...get
//    }
//    
//    
//    
//}
