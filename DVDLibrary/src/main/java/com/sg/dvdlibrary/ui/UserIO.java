
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dao.DVDDaoException;

public interface UserIO {

    void print(String message) throws DVDDaoException;

    String readString(String prompt) throws DVDDaoException;

    int readInt(String prompt) throws DVDDaoException;

    int readInt(String prompt, int min, int max) throws DVDDaoException;

    double readDouble(String prompt) throws DVDDaoException;

    double readDouble(String prompt, double min, double max) throws DVDDaoException;

    float readFloat(String prompt) throws DVDDaoException;

    float readFloat(String prompt, float min, float max) throws DVDDaoException;

    long readLong(String prompt) throws DVDDaoException;

    long readLong(String prompt, long min, long max) throws DVDDaoException;
    
    //LocalDate readDate(String date) throws DVDDaoException;

}
