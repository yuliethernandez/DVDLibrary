
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.ClassDVDPersistenceException;
import com.sg.dvdlibrary.dao.DVDDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.ClassDVDDataValidationException;
import com.sg.dvdlibrary.service.ClassDVDDuplicateIdException;
import com.sg.dvdlibrary.ui.DVDUserView;
import com.sg.dvdlibrary.service.ClassDVDServiceLayer;
import java.util.ArrayList;

public class DVDLibraryController {
    //DVDDaoInterfaceImpl service;
    DVDUserView view;
    ClassDVDServiceLayer service; 
    
    public DVDLibraryController(/*DVDDaoInterfaceImpl service, */DVDUserView view, ClassDVDServiceLayer service){
        //this.service = service;
        this.view = view;
        this.service=service;
    }
    
    public void run() throws DVDDaoException, ClassDVDPersistenceException, ClassDVDDuplicateIdException, ClassDVDDataValidationException{
        messageWellcome();
        while(true){
            int opt = getMainMenuOption();
            switch(opt){
                case 1:{
                    addDVDToLibrary();
                    break;
                }
                case 2:{
                    removeDVD();
                    break;
                }
                case 3:{
                    editDVD();
                    break;
                }
                case 4:{
                    listAllDVD();
                    break;
                }
                case 5:{
                    getDVDInformation();
                    break;
                }
                case 6:{
                    searchDVD();
                    break;
                }
                case 7:{                    
                    messageExit();
                    System.exit(0);
                    break;
                }
                default:{
                    unknownCommand();
                }
            }
        }
    }

    public void messageWellcome() throws DVDDaoException{
        view.messageWellcome();
    }
    
    public int getMainMenuOption() throws DVDDaoException{
        return view.getMainMenuOption();
    }
    
    public void addDVDToLibrary() throws DVDDaoException, ClassDVDDuplicateIdException, ClassDVDDataValidationException, ClassDVDPersistenceException{
        DVD newDVD = view.createNewDvd();
        service.addDVD(newDVD);
        //service.addDVD(newDVD);
        view.messageSuccesAddDVD();
    }
   
    public void removeDVD() throws DVDDaoException, ClassDVDPersistenceException{
        String title = view.removeDVDMenu();
        DVD dvdRemove = service.removeDVD(title);
        //if(validateDVDNullPointer(dvdRemove)){
            view.messageSuccesRemove(dvdRemove.getTitle());
        /*}else{
            view.messageNotFound();
        }*/
    }
    
    public void editDVD() throws DVDDaoException, ClassDVDPersistenceException, ClassDVDDataValidationException{        
        while(true){            
            view.bannerEditResult();
            String title = view.getTitleDVD();            
            DVD dvd = service.searchDVD(title);
            if(dvd!=null){
                int opt=view.getEditMenuOption();
                switch (opt){
                    case 1:{                        
                        editDvdTitle(dvd);
                        break;
                    }
                    case 2:{
                        editDvdSudio(dvd);
                        break;
                    }
                    case 3:{
                        editDvdMpaa(dvd);
                        break;
                    }
                    case 4:{
                        editDvdRating(dvd);
                        break;
                    }  
                    case 5:{
                        editDvdDate(dvd);
                        break;
                    }
                    case 6:{
                        break;
                    }  
                    default:{
                        unknownCommand();
                    }                        
                }
            }else{
                view.messageNotFound();
            }
            break;
        } 
    }
    
    public void listAllDVD() throws DVDDaoException, ClassDVDPersistenceException{
        ArrayList<DVD> listDVD = service.listAllDVD();
        //if(!listDVD.isEmpty()){
            view.bannerResults();
            view.listAllDVD(listDVD);
        /*}else{
            view.listAllDVD(listDVD);
        }  */       
    }
    
    public void getDVDInformation() throws DVDDaoException, ClassDVDPersistenceException{
        String titleDVD = view.getTitleDVD();
        DVD dvdDisplay = service.getDVD(titleDVD);
        //if(dvdDisplay != null){
            view.displayDVDInformation(dvdDisplay);
        /*}else{
            view.messageNotFound();
        }*/
    }
    
    public void searchDVD() throws DVDDaoException, ClassDVDPersistenceException{
        while(true){
            int opt=view.getSearchOption();
            switch (opt){
                    case 1:{
                        getDVDInformation();
                        break;
                    }
                    case 2:{
                        searchDvdSudio();
                        break;
                    }
                    case 3:{
                        searchDvdMpaa();
                        break;
                    }
                    case 4:{
                        searchDvdRating();
                        break;
                    }  
                    case 5:{
                        searchDvdDate();
                        break;
                    }
                    case 6:{
                        break;
                    }  
                    default:{
                        unknownCommand();
                    }
                        
                }
            break;
        } 
    }
    
    public void searchDvdSudio() throws DVDDaoException, ClassDVDPersistenceException{
        String studio = view.getStudio();
        ArrayList<DVD> listDVD = service.searchDvdSudio(studio);
        //if(validateDVDNullPointer(listDVD)){
            view.listAllDVD(listDVD);
        /*}else{
            view.messageNotFound();
        }  */      
    }
    
    public void searchDvdMpaa() throws DVDDaoException, ClassDVDPersistenceException{
        String mpaa = view.getMpaa();
        ArrayList<DVD> listDVD = service.searchDvdMpaa(mpaa);
        //if(validateDVDNullPointer(listDVD)){
            view.listAllDVD(listDVD);
        /*}else{
            view.messageNotFound();
        }*/        
    }
    
    public void searchDvdRating() throws DVDDaoException, ClassDVDPersistenceException{
        String rating = view.getUserRating();
        ArrayList<DVD> listDVD = service.searchDvdRating(rating);
        //if(validateDVDNullPointer(listDVD)){
            view.listAllDVD(listDVD);
        /*}else{
            view.messageNotFound();
        }   */     
    }
    
    public void searchDvdDate() throws DVDDaoException, ClassDVDPersistenceException{
        String date = view.getReleaseDate();
        ArrayList<DVD> listDVD = service.searchDvdDate(date);
        //if(validateDVDNullPointer(listDVD)){
            view.listAllDVD(listDVD);
        /*}else{
            view.messageNotFound();
        } */       
    }
    
    public void unknownCommand() throws DVDDaoException{
        view.unknownCommand();
    }
    
    public void messageExit() throws DVDDaoException{
        view.messageExit();
    }

    private void editDvdTitle(DVD dvd) throws DVDDaoException, ClassDVDDataValidationException {
        String newTitle = view.getNewTitleDVD();
        service.editDVDTitle(dvd, newTitle);
        view.messageSuccesEdit();      
    }

    private void editDvdSudio(DVD dvd) throws DVDDaoException, ClassDVDDataValidationException {
        String studio = view.getNewStudio();
        service.editDVDStudio(dvd, studio);
        view.messageSuccesEdit();      
    }

    private void editDvdMpaa(DVD dvd) throws DVDDaoException, ClassDVDDataValidationException {
        String mpaa = view.getNewMpaa();
        service.editDVDMpaa(dvd, mpaa);
        view.messageSuccesEdit();      
    }

    private void editDvdRating(DVD dvd) throws DVDDaoException, ClassDVDDataValidationException {
        String rating = view.getNewUserRating();
        service.editDVDRating(dvd, rating);
        view.messageSuccesEdit();        
    }

    private void editDvdDate(DVD dvd) throws DVDDaoException, ClassDVDDataValidationException {
        String date = view.getNewReleaseDate();
        service.editDVDDate(dvd, date);
        view.messageSuccesEdit();       
    }
    
    /*private boolean validateDVDNullPointer(ArrayList<DVD> listDVD) throws DVDDaoException{
        view.bannerResults();
        return !listDVD.isEmpty();
    }
    
    private boolean validateDVDNullPointer(DVD dvd) throws DVDDaoException{
        view.bannerResults();
        if(dvd!=null){            
            return true;
        }else{
            return false;
        } 
    }*/
}
