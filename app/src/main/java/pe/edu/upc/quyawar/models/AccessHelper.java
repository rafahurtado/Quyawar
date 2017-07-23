package pe.edu.upc.quyawar.models;

import com.orm.SugarRecord;

/**
 * Created by Rafael on 23/07/2017.
 */

public class AccessHelper extends SugarRecord {

    boolean firstAccess;
    String email;
    String last_access;

    public AccessHelper() {
    }

    public boolean isFirstAccess() {
        return firstAccess;
    }

    public AccessHelper setFirstAccess(boolean firstAccess) {
        this.firstAccess = firstAccess;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AccessHelper setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLast_access() {
        return last_access;
    }

    public AccessHelper setLast_access(String last_access) {
        this.last_access = last_access;
        return this;
    }
}
