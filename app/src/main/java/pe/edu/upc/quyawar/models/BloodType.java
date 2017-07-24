package pe.edu.upc.quyawar.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rhurtado on 24/07/2017.
 */

public class BloodType  {

    private static final String TAG = "QuyawarApp";

    Integer idBloodType;
    String bloodType;

    public BloodType(Integer idBloodType, String bloodType) {
        this.idBloodType = idBloodType;
        this.bloodType = bloodType;
    }

    public BloodType() {
    }

    public Integer getIdBloodType() {
        return idBloodType;
    }

    public BloodType setIdBloodType(Integer idBloodType) {
        this.idBloodType = idBloodType;
        return this;
    }

    public String getBloodType() {
        return bloodType;
    }

    public BloodType setBloodType(String bloodType) {
        this.bloodType = bloodType;
        return this;
    }


    //** patron builder
    public static BloodType build(JSONObject jsonBloodType){
        BloodType bloodType = new BloodType();

        if(jsonBloodType == null){ return null; }
        try {

            bloodType.setIdBloodType(jsonBloodType.getInt("srlIdCatalogo"))
                    .setBloodType(jsonBloodType.getString("strDescripcion"));


        }catch (JSONException e){
            e.printStackTrace();
            Log.d(TAG, "");
            Log.d(TAG, e.getMessage());
        }
        return bloodType;
    }
    public static List<BloodType> build(JSONArray jsonBloodTypes){
        List<BloodType> bloodTypes = new ArrayList<>();

        int length = jsonBloodTypes.length();
        for (int i = 0; i < length; i++){
            try {

                if(jsonBloodTypes.getJSONObject(i).getJSONObject("idTipoCatalogo").getString("srlIdCatalogo").equalsIgnoreCase("3") ) {

                    bloodTypes.add(BloodType.build(jsonBloodTypes.getJSONObject(i)));
                }

            }catch (JSONException e){
                e.printStackTrace();
                Log.d(TAG, "jsonBloodTypes size : " + String.valueOf(jsonBloodTypes.length()));
                Log.d(TAG, e.getMessage());
            }
        }

        return bloodTypes;
    }

}
