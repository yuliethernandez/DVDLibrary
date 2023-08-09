
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;

public interface DVDDaoInterface {
    
    void addDVD(DVD dvd) throws DVDDaoException;

    DVD removeDVD(String title) throws DVDDaoException;

    DVD editDVDTitle(DVD dvd, String newTitle) throws DVDDaoException;
    
    DVD editDVDStudio(DVD dvd, String newStudio) throws DVDDaoException;
    
    DVD editDVDMpaa(DVD dvd, String newMpaa) throws DVDDaoException;
    
    DVD editDVDRating(DVD dvd, String newUserRating) throws DVDDaoException;
    
    DVD editDVDDate(DVD dvd, String newDate) throws DVDDaoException;

    ArrayList<DVD> listAllDVD() throws DVDDaoException;

    DVD getDVD(String title) throws DVDDaoException;

    DVD searchDVD(String title) throws DVDDaoException;

    void loadDVDLibrary() throws DVDDaoException;

    void saveDVD() throws DVDDaoException;  
            
    ArrayList<DVD> searchDvdSudio(String studio) throws DVDDaoException;
    
    ArrayList<DVD> searchDvdMpaa(String mpaa) throws DVDDaoException;
    
    ArrayList<DVD> searchDvdRating(String rating) throws DVDDaoException;
    
    ArrayList<DVD> searchDvdDate(String date) throws DVDDaoException;
}
