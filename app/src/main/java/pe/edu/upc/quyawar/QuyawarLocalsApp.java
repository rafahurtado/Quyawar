package pe.edu.upc.quyawar;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import pe.edu.upc.quyawar.models.Local;
import pe.edu.upc.quyawar.network.LocalsApiService;

/**
 * Created by joseluis on 25/07/17.
 */

public class QuyawarLocalsApp extends Application{
    private LocalsApiService localsApiService;
    private static  QuyawarLocalsApp instance;
    public QuyawarLocalsApp(){
        super();
        instance = this;
    }

    public static QuyawarLocalsApp getInstance(){return instance;}
    @Override
    public void onCreate() {
        super.onCreate();
        // Fast Android Networking Setup
        AndroidNetworking.initialize(getApplicationContext());
        localsApiService = new LocalsApiService();
    }

    public Local getCurrentLocal(){
        return localsApiService.getCurrentLocal();
    }

    public QuyawarLocalsApp setCurrentLocal(Local local){
        localsApiService.setCurrentLocal(local);
        return this;
    }
}
