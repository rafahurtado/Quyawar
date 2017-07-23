package pe.edu.upc.quyawar;

/**
 * Created by Rafael on 22/07/2017.
 */

public class QuyawarApp {

    private static QuyawarApp instance;

    boolean firstTime;
    boolean authenticated;



    public QuyawarApp() {
        firstTime = true;
        authenticated = false;
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

    //********************
    public static QuyawarApp getInstance(){
        if(instance == null){
            instance = new QuyawarApp();
        }

        return instance;
    }

}
