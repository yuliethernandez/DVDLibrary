
package com.sg.dvdlibrary.dao;

public class DVDDaoException extends Exception{
    public DVDDaoException(String msg){
        super(msg);
    }
    public DVDDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
