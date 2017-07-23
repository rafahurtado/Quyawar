package pe.edu.upc.quyawar;

/**
 * Created by Rafael on 22/07/2017.
 */

public class QuyawarApp {

    private static QuyawarApp instance;

    boolean firstTime;



    public QuyawarApp() {
        firstTime = true;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    //********************
    public static QuyawarApp getInstance(){
        if(instance == null){
            instance = new QuyawarApp();
        }

        return instance;
    }

}
