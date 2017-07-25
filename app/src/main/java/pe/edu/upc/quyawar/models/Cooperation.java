package pe.edu.upc.quyawar.models;

import com.orm.SugarRecord;

import java.util.List;

import pe.edu.upc.quyawar.QuyawarApp;

/**
 * Created by rhurtado on 25/07/2017.
 */

public class Cooperation extends SugarRecord {

    String email;
    Integer campain;
    Boolean cooperate;

    public Cooperation() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCampaign_id() {
        return campain;
    }

    public void setCampaign_id(Integer campaign_id) {
        this.campain = campaign_id;
    }

    public Boolean getCooperate() {
        return cooperate;
    }

    public void setCooperate(Boolean cooperate) {
        this.cooperate = cooperate;
    }

    //** metodos statticos
    private static void Edit_Cooperation(int campaign_id, boolean isAccept){
        String mEmail = QuyawarApp.getInstance().getLastAuthenticated();

        List<Cooperation> cooperations = Cooperation.findWithQuery(Cooperation.class, "Select * from Cooperation where email = ? and campain = ?",
                mEmail, String.valueOf(campaign_id));

        if(cooperations.size() > 0){
            Cooperation edit_cooperation = cooperations.get(0);
            edit_cooperation.setCooperate(isAccept);
            edit_cooperation.save();
        }else{
            Cooperation new_cooperation = new Cooperation();
            new_cooperation.setEmail(mEmail);
            new_cooperation.setCampaign_id(campaign_id);
            new_cooperation.setCooperate(isAccept);
            new_cooperation.save();
        }
    }

    public static void ACCEPT(int campaign_id) {
        Cooperation.Edit_Cooperation(campaign_id, true);
    }

    public static void DENY(int campaign_id) {
        Cooperation.Edit_Cooperation(campaign_id, false);
    }

    public static Boolean isColaborator(int campaign_id){
        String mEmail = QuyawarApp.getInstance().getLastAuthenticated();

        List<Cooperation> cooperations = Cooperation.findWithQuery(Cooperation.class, "Select * from Cooperation where email = ? and campain = ?",
                mEmail, String.valueOf(campaign_id));

        if(cooperations.size() > 0){
            Cooperation cooperation_registred = cooperations.get(0);
            return cooperation_registred.getCooperate();
        }

        return false;
    }



}
