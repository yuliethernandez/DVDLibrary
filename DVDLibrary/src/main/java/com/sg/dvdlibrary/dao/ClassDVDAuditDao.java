
package com.sg.dvdlibrary.dao;

public interface ClassDVDAuditDao {
    public void writeAuditEntry(String entry) throws ClassDVDPersistenceException;
}
