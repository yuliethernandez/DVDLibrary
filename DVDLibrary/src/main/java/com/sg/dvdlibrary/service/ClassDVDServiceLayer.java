
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.ClassDVDPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;

public interface ClassDVDServiceLayer {
    
    void addDVD(DVD dvd) throws ClassDVDDuplicateIdException, ClassDVDDataValidationException,
            ClassDVDPersistenceException;

    DVD removeDVD(String title) throws ClassDVDPersistenceException;

    ArrayList<DVD> listAllDVD() throws ClassDVDPersistenceException;

    DVD getDVD(String title) throws ClassDVDPersistenceException;

    DVD searchDVD(String title) throws ClassDVDPersistenceException; 
            
    ArrayList<DVD> searchDvdSudio(String studio) throws ClassDVDPersistenceException;
    
    ArrayList<DVD> searchDvdMpaa(String mpaa) throws ClassDVDPersistenceException;
    
    ArrayList<DVD> searchDvdRating(String rating) throws ClassDVDPersistenceException;
    
    ArrayList<DVD> searchDvdDate(String date) throws ClassDVDPersistenceException;
    
    DVD editDVDTitle(DVD dvd, String newTitle) throws ClassDVDDataValidationException;
    
    DVD editDVDStudio(DVD dvd, String newStudio) throws ClassDVDDataValidationException;
    
    DVD editDVDMpaa(DVD dvd, String newMpaa) throws ClassDVDDataValidationException;
    
    DVD editDVDRating(DVD dvd, String newUserRating) throws ClassDVDDataValidationException;
    
    DVD editDVDDate(DVD dvd, String newDate) throws ClassDVDDataValidationException;

}
