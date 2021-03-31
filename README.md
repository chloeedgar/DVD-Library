"# dvd-library-chloeedgar" 

The program follows a MVC design approach, uses dependency injection and was developed using an Agile approach.

The agile approach was achieved by taking the following steps:

I read first over the problem statement and identified and created the different packages and empty files and 
interfaces so I could create the shell of the program and also so I could implement the Model-View-Control 
design. The program includes a DTO, DAO, a user interface and a controller which orchestrates the objects in the
program.

I then created the menu system. I first set up the UserIO interface and the UserIOConsoleImpl class which 
implements the UserIO interface.
I then moved onto the controller which should control when the menu system is displayed. The first version 
was not back by any functionality but allowed the program to be run and to navigate through the menu options. 
Instead, for the sake of testing, it would print out a message e.g. the menu option for add DVD would print 
‘add DVD’. This ensured that this functionality performed as required. To test this functionality, the 
controller was instantiated in the App class and the run method was called.

Once, this functionality and structure was confirmed, the menu system was refactored so that the layout is 
in the DvdLibraryView class. The controller was then set up so that it could delegate to the view to perform this action. 

I then implemented each use case one by one to include: Add DVD, Remove DVD, List DVDs, List information for one DVD
and Edit the DVD (which includes the release date, the MPPA rating, the director's name, the user rating and the studio.

I followed the same pattern for each use case – I updated the DAO implementation, updated the view and updated the controller.

I built all functionality without file persistence to begin with. Once all features were finished and tested to ensure 
they functioing as expected, I added the file persistence which used code to read from and write to files and handled 
the associated exceptions.