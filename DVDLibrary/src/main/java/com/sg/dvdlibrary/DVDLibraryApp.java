
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.dao.*;
import com.sg.dvdlibrary.service.ClassDVDDataValidationException;
import com.sg.dvdlibrary.service.ClassDVDDuplicateIdException;
import com.sg.dvdlibrary.service.ClassDVDServiceLayer;
import com.sg.dvdlibrary.service.ClassDVDServiceLayerImpl;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOImplementation;
import com.sg.dvdlibrary.ui.DVDUserView;

public class DVDLibraryApp {

    public static void main(String[] args) throws DVDDaoException, ClassDVDPersistenceException, ClassDVDDuplicateIdException, ClassDVDDataValidationException {
        //DVDLibraryController controllerDVD = new DVDLibraryController(new DVDDaoInterfaceImpl(), new DVDUserView());
        
        UserIO myIo = new UserIOImplementation();
        // Instantiate the View and wire the UserIO implementation into it
        DVDUserView myView = new DVDUserView(myIo);
        // Instantiate the DAO
        DVDDaoInterface myDao = new DVDDaoInterfaceImpl();
        // Instantiate the Audit DAO
        ClassDVDAuditDao myAuditDao = new ClassDVDAuditDaoFileImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        ClassDVDServiceLayer myService = new ClassDVDServiceLayerImpl((DVDDaoInterfaceImpl) myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        DVDLibraryController controller = new DVDLibraryController(myView, myService);
        //DVDLibraryController controller = new DVDLibraryController(myService, myView);
        // Kick off the Controller
        controller.run();
        
    }
}
