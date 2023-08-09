
package com.sg.dvdlibrary.service;

public class ClassDVDDuplicateIdException extends Exception{
      public ClassDVDDuplicateIdException(String message) {
        super(message);
    }

    public ClassDVDDuplicateIdException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
