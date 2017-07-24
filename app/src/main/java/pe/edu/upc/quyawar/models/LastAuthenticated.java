package pe.edu.upc.quyawar.models;

import com.orm.SugarRecord;

/**
 * Created by rhurtado on 24/07/2017.
 */

public class LastAuthenticated extends SugarRecord {

    String email;

    public LastAuthenticated() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
