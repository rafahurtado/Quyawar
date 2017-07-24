package pe.edu.upc.quyawar.models;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rhurtado on 24/07/2017.
 */

public class Campaign {

    Integer id;
    String description;

    String bloodType;

    String localDonation;
    String distrito;
    Double lat;
    Double lon;



    public Campaign() {
    }

    public Integer getId() {
        return id;
    }

    public Campaign setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Campaign setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBloodType() {
        return bloodType;
    }

    public Campaign setBloodType(String bloodType) {
        this.bloodType = bloodType;
        return this;
    }

    public String getLocalDonation() {
        return localDonation;
    }

    public Campaign setLocalDonation(String localDonation) {
        this.localDonation = localDonation;
        return this;
    }

    public String getDistrito() {
        return distrito;
    }

    public Campaign setDistrito(String distrito) {
        this.distrito = distrito;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public Campaign setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLon() {
        return lon;
    }

    public Campaign setLon(Double lon) {
        this.lon = lon;
        return this;
    }


    //patron builder
    public static Campaign build(JSONObject jsonCampaign){
       Campaign campaign = new Campaign();

        if(jsonCampaign == null) { return null; }

        try {
            campaign.setId(jsonCampaign.getInt("srlIdCampania"))
                    .setDescription(jsonCampaign.getString("strDescripcion"))
                    .setDistrito(jsonCampaign.getString("strUbicacion"))
                    .setBloodType(jsonCampaign.getJSONObject("idTipoSangre").getString("strDescripcion"))
                    .setLocalDonation(jsonCampaign.getJSONObject("idSedesalud").getString("strNombre"));

            String[] parts = jsonCampaign.getJSONObject("idSedesalud").getString("strNombre").split(",");
            campaign.setLat(Double.valueOf( parts[0]));
            campaign.setLon(Double.valueOf( parts[1]));


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static List<Campaign> build(JSONArray jsonCampaigns){
        List<Campaign> campaigns = new ArrayList<>();
        int length = jsonCampaigns.length();
        for (int i = 0; i < length; i++){
            try {
                campaigns.add(Campaign.build(jsonCampaigns.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return campaigns;
    }


}
