
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.dao.DVDDaoException;
import java.util.ArrayList;

public class DVDUserView {
    private final UserIO io;
    
    public DVDUserView(UserIO io){
        this.io = io;
    }
    
    //Option's Menu
    public void messageWellcome() throws DVDDaoException{
        io.print("*********Wellcome to the DVD Library Management System*********");
    }
    
    public int getMainMenuOption() throws DVDDaoException{
        String menu = "\n*** MAIN MENU ***"
                + "\n 1. Add a DVD."
                + "\n 2. Remove a DVD."
                + "\n 3. Edit a DVD."
                + "\n 4. List the DVDs."
                + "\n 5. Display information of a DVD."
                + "\n 6. Search DVD."
                + "\n 7. Exit."
                + "\n Please, Select an option: ";
        return io.readInt(menu);
    }
    
    public DVD createNewDvd() throws DVDDaoException{
        io.print("\n*** Create DVD ***");
        String title = io.readString("Please enter the DVD title: ");        
        String date = io.readString("Please enter the Date in the format yyyy-mm-dd: ");        
        String studio = io.readString("Please enter the studio: ");        
        String MPAA_Rating = io.readString("Please enter the MPAA Rating of the DVD: ");
        String userRating = io.readString("Please enter the Rating of the DVD: ");
        
        //Creating the new DVD and returning the object
        return new DVD(title, studio, MPAA_Rating, userRating, date);
    }
    
    public int getSearchOption() throws DVDDaoException{        
        String menu = "\n*** Search DVD ***"
            + "\n 1. Search Title"
            + "\n 2. Search Studio"
            + "\n 3. Search MPAA Rating"
            + "\n 4. Search User Rating"
            + "\n 5. Search Release Date"
            + "\n 6. Exit edit menu"
            + "\nPlease select a choice from above: ";
        return io.readInt(menu, 1, 6);        
    } 
    
    public int getEditMenuOption() throws DVDDaoException{        
        String menu = "\n*** Edit Options ***"
            + "\nWhich field do you want to change? "
            + "\n 1. Edit Title"
            + "\n 2. Edit Studio"
            + "\n 3. Edit MPAA Rating"
            + "\n 4. Edit User Rating"
            + "\n 5. Edit Release Date"
            + "\n 6. Exit edit menu"
            + "\nPlease select a choice from above: ";
        return io.readInt(menu, 1, 6);        
    }
    
    public String getReleaseDate() throws DVDDaoException {
        return io.readString("Please type the DVD release date: ");
    }
    
    public String getStudio() throws DVDDaoException {
        return io.readString("Please type the name of the studio: ");
    }     
    
    public String getMpaa() throws DVDDaoException {
        return io.readString("Please type the DVD MPAA rating: ");
    }
   
    public String getUserRating() throws DVDDaoException {
        return io.readString("Please type the user rating: ");
    }
    
    public String getTitleDVD() throws DVDDaoException{        
        return io.readString("Please, type the title of the DVD: ");
    }   
    
    public String getNewReleaseDate() throws DVDDaoException {
        return io.readString("Please type the new date: ");
    }
    
    public String getNewStudio() throws DVDDaoException {
        return io.readString("Please type the new name of the studio: ");
    }     
    
    public String getNewMpaa() throws DVDDaoException {
        return io.readString("Please type the new DVD MPAA rating: ");
    }
    
    public String getNewUserRating() throws DVDDaoException {
        return io.readString("Please type the new user rating: ");
    }
    
    public String getNewTitleDVD() throws DVDDaoException{        
        return io.readString("Please, type the new title of the DVD: ");
    } 
    
    public void displayDVDInformation(DVD dvdDisplay) throws DVDDaoException{
        io.print("\n*** Displaying Information ***");
        if(dvdDisplay != null){
            io.print("\nTitle: " + dvdDisplay.getTitle() + "\nStudio: " + dvdDisplay.getStudio() 
                    + "\nMPAA Raing: " + dvdDisplay.getMPAA_Rating() + "\nRealease Date: " 
                    + dvdDisplay.getReleaseDate() + "\nUser Rating: " + dvdDisplay.getUserRating() + "\n ");
        }else{
            this.messageNotFound();
        }
    }
    
    public String removeDVDMenu() throws DVDDaoException{
        String menu = "*** Remove Options ***"
                + "\n Please, type the title of the DVD you wish delete: ";
        return io.readString(menu);
    }
    
    public void listAllDVD(ArrayList<DVD> listDVD) throws DVDDaoException{
        String head = String.format("%25s | %20s | %10s | %25s | %10s", 
                "Title",
                "Studio",
                "MPAA Rating",
                "User Rating",
                "Release Date"
                );
        io.print(head);
        for(DVD dvd: listDVD){
            String datasDVD = String.format("%25s | %20s | %10s | %25s | %10s", 
                dvd.getTitle(),
                dvd.getStudio(),
                dvd.getMPAA_Rating(),
                dvd.getUserRating(),
                dvd.getReleaseDate()
                );
        io.print(datasDVD);
        }
    }

    //Messages of Succes
    public void messageSuccesEdit() throws DVDDaoException {
        io.print("\nDVD Successfully edited.\n");        
    }
    
    public void messageSuccesRemove(String title) throws DVDDaoException {
        io.print("The DVD " + title + " was successfully removed.");        
    }
    
    public void messageSuccesCreateDVD() throws DVDDaoException{
        io.print("\nDVD successfully created.\n");
    }
    
    public void messageExit() throws DVDDaoException{
        io.print("Program finished.");
    }
    
    public void unknownCommand() throws DVDDaoException{
        io.print("\nUnknown Command\n");
    }
    
    public void messageSuccesAddDVD() throws DVDDaoException {
        io.print("\nDVD successfully added.\n");
    }
    
    public void displayEditResult() throws DVDDaoException{
        io.print("\nDVD Successfully edited.\n");
    }
    
    public void bannerEditResult() throws DVDDaoException{
        io.print("\n*** Editing DVD ***");
    }
    
    public void messageNotFound() throws DVDDaoException {
        io.print("\nIt was not found in the Library.");        
    }
    
    public void bannerResults() throws DVDDaoException {
        io.print("\n**************** RESULTS ****************");        
    }

}
