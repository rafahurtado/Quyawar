package pe.edu.upc.quyawar.models;

import android.location.LocationManager;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.network.QuyawarApiService;

/**
 * Created by Rafael on 23/07/2017.
 */

public class Local {

    private static String TAG = "QuyawarApp";


    private int id;
    private String name;
    private String address;
    private String phone;
    private double lat;
    private double lon;
    private int pictureId;

    public Local() {
    }

    public int getId() {
        return id;
    }

    public Local setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Local setName(String name) {
        this.name = name;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAddress() {
        return address;
    }

    public Local setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Local setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }


    //patron builder
    public static Local build(JSONObject jsonLocal){
        Local local = new Local();

        if(jsonLocal == null) { return null; }

        Log.d(TAG, "jsonLocal: " + jsonLocal.toString());

        try {
            local.setId(jsonLocal.getInt("srlIdSedesalud"))
                    .setName(jsonLocal.getString("strNombre"))
                    .setAddress(jsonLocal.getString("strDireccion"))
                    .setPhone(jsonLocal.getString("strTelefono") + " - " + jsonLocal.getString("strCelular"));

            String[] parts = jsonLocal.getString("strUbicacion").split(",");
            //Log.d(TAG, "" +  jsonCampaign.getJSONObject("idSedesalud").getString("strNombre"));
            local.setLat(Double.valueOf( parts[0]));
            local.setLon(Double.valueOf( parts[1]));

            //** seleccion de la imagen a mostrar
            switch (local.getId()){
                case 1:
                    local.setPictureId(R.drawable.if_rebagliati);
                    break;
                case 2:
                    local.setPictureId(R.drawable.if_dosmayo);
                    break;
                case 3:
                    local.setPictureId(R.drawable.if_loayza);
                    break;
                case 200:
                    local.setPictureId(R.drawable.if_sangabriel);
                    break;
                case 201:
                    local.setPictureId(R.drawable.if_cssanmiguel);
                    break;
                default:
                    local.setPictureId(R.drawable.if_hospital_32);
                    break;
            }

            return local;

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "Error build object : " + e.getMessage());
        }

        return null;
    }
    public static List<Local> build(JSONArray jsonLocals){
        Log.d(TAG, "Start build array ");
        List<Local> locals = new ArrayList<>();
        int length = jsonLocals.length();
        Log.d(TAG, "length value " + String.valueOf(length));
        for (int i = 0; i < length; i++){
            try {
                locals.add(Local.build(jsonLocals.getJSONObject(i)));
                Log.d(TAG, "new size locals : " + String.valueOf(locals.size()));
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d(TAG, "Error build array : " + e.getMessage());
            }
        }
        return locals;
    }




}
