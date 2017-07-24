package pe.edu.upc.quyawar.network;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

import java.util.List;

import pe.edu.upc.quyawar.QuyawarApp;
import pe.edu.upc.quyawar.models.BloodType;
import pe.edu.upc.quyawar.network.QuyawarApiService;

/**
 * Created by rhurtado on 24/07/2017.
 */

public class BloodTypeService {

    private final String TAG = "QuyawarApp";

    private List<BloodType> bloodTypes ;

    public BloodTypeService() {

    }


    public List<BloodType> getBloodTypes() {
        if( this.bloodTypes == null || this.bloodTypes.size() == 0){
            //this.initialize_blood_type();
            //this.bloodTypes = BloodType.listAll(BloodType.class);

            updateBloodTypes();
        }

        return bloodTypes;
    }

    public BloodType getBloodTypeById(int id){
        int position = -1;
        for (int i = 0; i < getBloodTypes().size(); i++){
            if(bloodTypes.get(i).getIdBloodType().equals(id)){
                position = i;
                break;
            }
        }
        if(position > -1){
            return getBloodTypes().get(position);
        }else{
            return null;
        }
    }

    private void updateBloodTypes(){
        AndroidNetworking.get(QuyawarApiService.CATALOG_URL)
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response != null){
                            bloodTypes = BloodType.build(response);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, anError.toString());
                    }
                });
    }

    /*
    private void initialize_blood_type(){

        this.save_bloodType("A+");
        this.save_bloodType("A-");
        this.save_bloodType("B+");
        this.save_bloodType("B-");
        this.save_bloodType("AB+");
        this.save_bloodType("AB-");
        this.save_bloodType("O+");
        this.save_bloodType("O-");
    }
    */

    /*
    private void save_bloodType(String bloodType){
        BloodType newBloodType = new BloodType();
        newBloodType.setBloodType(bloodType);
        newBloodType.save();
    }
*/


}
