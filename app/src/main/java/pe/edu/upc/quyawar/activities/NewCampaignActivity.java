package pe.edu.upc.quyawar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.models.Local;
import pe.edu.upc.quyawar.network.QuyawarApiService;

public class NewCampaignActivity extends AppCompatActivity {

    private static String TAG = "QuyawarApp";
    List<Local> locals;
    Spinner localsSpinner;
    //SpinnerAdapter localsSpinnerAdapter;
    ArrayAdapter spinner_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_campaign);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        locals = new ArrayList<>();

        localsSpinner = (Spinner)findViewById(R.id.localSpinner);

        updateLocals();

    }


    private void updateLocals(){
        AndroidNetworking
                .get(QuyawarApiService.LOCALS_URL)
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "response length -> " + String.valueOf(response.length()) );
                        locals = Local.build(response);

                        spinner_adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locals);
                        //Añadimos el layout para el menú y se lo damos al spinner
                        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        localsSpinner.setAdapter(spinner_adapter);
                        spinner_adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, "anError : " + anError.getMessage());
                    }
                });
    }

}
