package pe.edu.upc.quyawar.models;

import com.orm.SugarRecord;

/**
 * Created by rhurtado on 24/07/2017.
 */

public class LastAuthenticated extends SugarRecord {

    String email;
    //String password;
    //Boolean persist;

    public LastAuthenticated() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPersist() {
        return persist;
    }

    public void setPersist(Boolean persist) {
        this.persist = persist;
    }
    */
}
