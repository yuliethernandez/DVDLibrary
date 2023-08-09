
package com.sg.dvdlibrary.service;

public class ClassDVDDataValidationException extends Exception{

    public ClassDVDDataValidationException(String message) {
        super(message);
    }

    public ClassDVDDataValidationException(String message,
            Throwable cause) {
        super(message, cause);
    }    
}
