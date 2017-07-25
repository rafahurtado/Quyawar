package pe.edu.upc.quyawar.network;

import pe.edu.upc.quyawar.models.Local;

/**
 * Created by joseluis on 24/07/17.
 */

public class LocalsApiService {
    public static  String LOCALS_URL = "http://characato.club/quyawar/sedeSalud/";

    private Local currentLocal;

    public Local getCurrentLocal() {
        return currentLocal;
    }

    public void setCurrentLocal(Local currentLocal) {
        this.currentLocal = currentLocal;
    }
}
