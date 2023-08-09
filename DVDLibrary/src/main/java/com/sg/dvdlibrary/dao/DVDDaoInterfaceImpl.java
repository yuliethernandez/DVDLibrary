
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.*;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOImplementation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class DVDDaoInterfaceImpl implements DVDDaoInterface{
    private final HashMap<String, DVD> dvdLibrary;
    private final UserIO io;
    Scanner sc ;
    public static final String LIBRARY_FILE = "DVDLibrary.txt";
    //public static final String DATE_DELIMITER = "-";
    public static final String DELIMITER = "::";
    
    public DVDDaoInterfaceImpl(){
        this.dvdLibrary = new HashMap<>();
        this.sc= new Scanner(System.in);
        this.io = new UserIOImplementation();
   }

    @Override
    public void addDVD(DVD dvd) throws DVDDaoException{
        loadDVDLibrary();
        dvdLibrary.put(dvd.getTitle(), dvd);
        saveDVD();
    }

    @Override
    public DVD removeDVD(String title) throws DVDDaoException {
        loadDVDLibrary();
        DVD dvd = dvdLibrary.remove(title);
        saveDVD();
        return dvd;
    }

    @Override
    public DVD editDVDTitle(DVD dvd, String newTitle) throws DVDDaoException {
        loadDVDLibrary();
        dvdLibrary.get(dvd.getTitle()).setTitle(newTitle);
        saveDVD();
        return dvd;
    }
    
    @Override
    public DVD editDVDStudio(DVD dvd, String newStudio) throws DVDDaoException {
        loadDVDLibrary();
        dvdLibrary.get(dvd.getTitle()).setStudio(newStudio);
        saveDVD();
        return dvd;
    }
    
    @Override
    public DVD editDVDMpaa(DVD dvd, String newMpaa) throws DVDDaoException {
        loadDVDLibrary();
        dvdLibrary.get(dvd.getTitle()).setMPAA_Rating(newMpaa);
        saveDVD();
        return dvd;
    }
    
    @Override
    public DVD editDVDRating(DVD dvd, String newUserRating) throws DVDDaoException {
        loadDVDLibrary();
        dvdLibrary.get(dvd.getTitle()).setUserRating(newUserRating);
        saveDVD();
        return dvd;
    }
    
    @Override
    public DVD editDVDDate(DVD dvd, String newDate) throws DVDDaoException {
        loadDVDLibrary();
        dvdLibrary.get(dvd.getTitle()).setReleaseDate(newDate);
        saveDVD();
        return dvd;
    }
    
    @Override
    public ArrayList<DVD> listAllDVD() throws DVDDaoException {
        loadDVDLibrary();
        return new ArrayList(dvdLibrary.values());//return a collection of DVD
    }

    @Override
    public DVD getDVD(String title) throws DVDDaoException {
       loadDVDLibrary();
       return dvdLibrary.get(title);
    }

    @Override
    public DVD searchDVD(String title) throws DVDDaoException {
        loadDVDLibrary();
        return dvdLibrary.get(title);
    }
    
    @Override
    public ArrayList<DVD> searchDvdSudio(String studio) throws DVDDaoException{
        loadDVDLibrary();
        ArrayList<DVD> list = new ArrayList<>();
        Collection<DVD> collection= dvdLibrary.values();
        for(DVD dvd: collection){
            if(dvd.getStudio().equalsIgnoreCase(studio)){
                list.add(dvd);
            }
        }
        return list;
    }
    
    @Override
    public ArrayList<DVD> searchDvdMpaa(String mpaa) throws DVDDaoException{
        loadDVDLibrary();
        ArrayList<DVD> list = new ArrayList<>();
        Collection<DVD> collection= dvdLibrary.values();
        for(DVD dvd: collection){
            if(dvd.getMPAA_Rating().equalsIgnoreCase(mpaa)){
                list.add(dvd);
            }
        }
        return list;
    }
    
    @Override
    public ArrayList<DVD> searchDvdRating(String rating) throws DVDDaoException{
        loadDVDLibrary();
        ArrayList<DVD> list = new ArrayList<>();
        Collection<DVD> collection= dvdLibrary.values();
        for(DVD dvd: collection){
            if(dvd.getUserRating().contains(rating)){
                list.add(dvd);
            }
        }
        return list;
    }
    
    @Override
    public ArrayList<DVD> searchDvdDate(String date) throws DVDDaoException{
        loadDVDLibrary();
        ArrayList<DVD> list = new ArrayList<>();
        Collection<DVD> collection= dvdLibrary.values();
        for(DVD dvd: collection){
            if(dvd.getReleaseDate().equalsIgnoreCase(date)){
                list.add(dvd);
            }
        }
        return list;
    }
    
    @Override
    public void loadDVDLibrary() throws DVDDaoException {
        Scanner out;
        try{
            out = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        }catch(FileNotFoundException ex){
            throw new DVDDaoException("Could not load the library.");
        }
        while(out.hasNextLine()){
            DVD dvd = unmarshallDVD(out.nextLine());            
            dvdLibrary.put(dvd.getTitle(), dvd);
        }  
        out.close();
    }

    @Override
    public void saveDVD() throws DVDDaoException {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new FileWriter(LIBRARY_FILE));
            
        } catch (IOException ex) {
            throw new DVDDaoException(ex.getMessage());
        }
        String dvdLine;
            List<DVD> dvdList = listAllDVD();

            for(DVD dvd: dvdList){
                dvdLine = marshallDVD(dvd);
                writer.println(dvdLine);
                writer.flush();
            }
            writer.close();
    }  
    
    private String marshallDVD(DVD dvd){
        String dvdStringLine = dvd.getTitle() + DELIMITER + dvd.getStudio() + DELIMITER + dvd.getMPAA_Rating()+ DELIMITER + dvd.getReleaseDate() 
                + DELIMITER + dvd.getUserRating();
        return dvdStringLine;
    }
    
    private DVD unmarshallDVD(String dvdLineObject){
        String[] arrayString = dvdLineObject.split(DELIMITER);

        String title = arrayString[0];
        String studio = arrayString[1];
        String mpaa = arrayString[2];
        String rating = arrayString[4];
        String date = arrayString[3];
        
        return new DVD(title, studio, mpaa, rating, date);
    }

}