package pe.edu.upc.quyawar;

import java.util.List;

import pe.edu.upc.quyawar.models.AccessHelper;
import pe.edu.upc.quyawar.models.Campaign;
import pe.edu.upc.quyawar.models.LastAuthenticated;
import pe.edu.upc.quyawar.network.BloodTypeService;

/**
 * Created by Rafael on 22/07/2017.
 */

public class QuyawarApp {

    private static QuyawarApp instance;

    private boolean firstTime;
    private boolean authenticated;

    private AccessHelper accessHelper;

    private BloodTypeService bloodTypeService;

    private Campaign current_campaign;

    public QuyawarApp() {
        firstTime = true;
        authenticated = false;

        bloodTypeService = new BloodTypeService();

    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public BloodTypeService getBloodTypeService() {
        return bloodTypeService;
    }


    public String getLastAuthenticated(){
        String last_authenticated = "";
        List<LastAuthenticated> last_authenticateds = LastAuthenticated.listAll(LastAuthenticated.class);
        if(last_authenticateds.size() > 0){
            last_authenticated = last_authenticateds.get(0).getEmail();
        }

        return last_authenticated;
    }

    public void setLastAuthenticated(String current_authenticated){
        LastAuthenticated last_authenticated;
        List<LastAuthenticated> last_authenticateds = LastAuthenticated.listAll(LastAuthenticated.class);
        if(last_authenticateds.size() > 0){
            last_authenticated = last_authenticateds.get(0);
        }else{
            last_authenticated = new LastAuthenticated();
        }
        last_authenticated.setEmail(current_authenticated);
        last_authenticated.save();
    }

    public Campaign getCurrentCampaign() {
        return current_campaign;
    }

    public void setCurrentCampaign(Campaign current_campaign) {
        this.current_campaign = current_campaign;
    }

    //********************
    public static QuyawarApp getInstance(){
        if(instance == null){
            instance = new QuyawarApp();
        }

        return instance;
    }

}
