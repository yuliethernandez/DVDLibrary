
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.ClassDVDAuditDao;
import com.sg.dvdlibrary.dao.ClassDVDPersistenceException;
import com.sg.dvdlibrary.dao.DVDDaoException;
import com.sg.dvdlibrary.dao.DVDDaoInterface;
import com.sg.dvdlibrary.dao.DVDDaoInterfaceImpl;
import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassDVDServiceLayerImpl implements ClassDVDServiceLayer{
    DVDDaoInterface dao;
    private ClassDVDAuditDao auditDao;
    
    public ClassDVDServiceLayerImpl(DVDDaoInterfaceImpl dao, ClassDVDAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void addDVD(DVD dvd) throws ClassDVDDuplicateIdException, ClassDVDDataValidationException, 
            ClassDVDPersistenceException, ClassDVDPersistenceException {
        //validating no null DVD
        DVD dvdGet = null;
        try {
            dvdGet = dao.getDVD(dvd.getTitle());
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dvdGet!= null){
            throw new ClassDVDDuplicateIdException("ERROR: Could not create student.  Student Id "
                    + dvd.getTitle() + " already exists");
        }
        validateDVDData(dvd);
        try {
            dao.addDVD(dvd);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        auditDao.writeAuditEntry("DVD " + dvd.getTitle() + " CREATED.");
    }

    @Override
    public DVD removeDVD(String title) throws ClassDVDPersistenceException {
        DVD removedStudent = null;
        try {
            removedStudent = dao.removeDVD(title);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Write to audit log
        auditDao.writeAuditEntry("Student " + title + " REMOVED.");
        return removedStudent;
    }

    @Override
    public ArrayList<DVD> listAllDVD() throws ClassDVDPersistenceException {
        ArrayList<DVD> list = null ;
        try {
            list = dao.listAllDVD();
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public DVD getDVD(String title) throws ClassDVDPersistenceException {
        DVD dvd = null;
        try {
             dvd = dao.getDVD(title);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvd;
    }

    @Override
    public DVD searchDVD(String title) throws ClassDVDPersistenceException {
        return this.getDVD(title);
    }

    @Override
    public ArrayList<DVD> searchDvdSudio(String studio) throws ClassDVDPersistenceException {
        ArrayList<DVD> list = null ;
        try {
            list = dao.searchDvdSudio(studio);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<DVD> searchDvdMpaa(String mpaa) throws ClassDVDPersistenceException {
        ArrayList<DVD> list = null ;
        try {
            list = dao.searchDvdMpaa(mpaa);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<DVD> searchDvdRating(String rating) throws ClassDVDPersistenceException {
        ArrayList<DVD> list = null ;
        try {
            list = dao.searchDvdRating(rating);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<DVD> searchDvdDate(String date) throws ClassDVDPersistenceException {
        ArrayList<DVD> list = null ;
        try {
            list = dao.searchDvdDate(date);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public DVD editDVDTitle(DVD dvd, String newTitle) throws ClassDVDDataValidationException {
        DVD dvdGet = null;
        try {
            dvdGet = dao.getDVD(dvd.getTitle());
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dvdGet==null){
            throw new ClassDVDDataValidationException("The DVD: " + dvd.getTitle() + " doesn't exist.");
        }
        DVD dvdEdited = null;
        try {
             dvdEdited = dao.editDVDTitle(dvd, newTitle);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvdEdited;
    }

    @Override
    public DVD editDVDStudio(DVD dvd, String newStudio) throws ClassDVDDataValidationException {
        DVD dvdGet = null;
        try {
            dvdGet = dao.getDVD(dvd.getTitle());
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dvdGet==null){
            throw new ClassDVDDataValidationException("The DVD: " + dvd.getTitle() + " doesn't exist.");
        }
        DVD dvdEdited = null;
        try {
            dvdEdited = dao.editDVDStudio(dvd, newStudio);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvdEdited;
    }

    @Override
    public DVD editDVDMpaa(DVD dvd, String newMpaa) throws ClassDVDDataValidationException {
        DVD dvdGet = null;
        try {
            dvdGet = dao.getDVD(dvd.getTitle());
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dvdGet==null){
            throw new ClassDVDDataValidationException("The DVD: " + dvd.getTitle() + " doesn't exist.");
        }
        DVD dvdEdited = null;
        try {
            dvdEdited = dao.editDVDMpaa(dvd, newMpaa);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvdEdited;
    }

    @Override
    public DVD editDVDRating(DVD dvd, String newUserRating) throws ClassDVDDataValidationException {
        DVD dvdGet = null;
        try {
            dvdGet = dao.getDVD(dvd.getTitle());
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dvdGet==null){
            throw new ClassDVDDataValidationException("The DVD: " + dvd.getTitle() + " doesn't exist.");
        }
        DVD dvdEdited = null;
        try {
            dvdEdited = dao.editDVDRating(dvd, newUserRating);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvdEdited;
    }

    @Override
    public DVD editDVDDate(DVD dvd, String newDate) throws ClassDVDDataValidationException {
        DVD dvdGet = null;
        try {
            dvdGet = dao.getDVD(dvd.getTitle());
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(dvdGet==null){
            throw new ClassDVDDataValidationException("The DVD: " + dvd.getTitle() + " doesn't exist.");
        }
        DVD dvdEdited = null;
        try {
             dvdEdited = dao.editDVDDate(dvd, newDate);
        } catch (DVDDaoException ex) {
            Logger.getLogger(ClassDVDServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvdEdited;
    }
    
    private void validateDVDData(DVD dvd) throws ClassDVDDataValidationException {

        if (dvd.getTitle() == null
                || dvd.getTitle().trim().length() == 0
                || dvd.getMPAA_Rating() == null
                || dvd.getMPAA_Rating().trim().length() == 0
                || dvd.getReleaseDate() == null
                || dvd.getReleaseDate().trim().length() == 0
                || dvd.getStudio() == null
                || dvd.getStudio().trim().length() == 0
                || dvd.getUserRating() == null
                || dvd.getUserRating().trim().length() == 0){

            throw new ClassDVDDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
    }
}
}
