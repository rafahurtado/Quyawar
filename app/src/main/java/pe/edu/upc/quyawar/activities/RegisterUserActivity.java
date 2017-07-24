package pe.edu.upc.quyawar.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANResponse;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndJSONArrayRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;
import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.adapters.BloodTypeAdapter;
import pe.edu.upc.quyawar.network.CatalogoService;
import pe.edu.upc.quyawar.network.DonanteService;
import pe.edu.upc.quyawar.network.LoginService;

public class RegisterUserActivity extends AppCompatActivity {

    AutoCompleteTextView emailRegistredTextView;
    AutoCompleteTextView passwordRegistredTextView;
    AutoCompleteTextView passwordConfirmedTextView;
    Spinner bloodTypeSpinner;
    Button registerUserButton;

    String email_user;
    String password_user, password_user2;

    Integer blood_type_id;
    BloodTypeAdapter bloodTypeAdapter;
    private static String TAG = "QuyawarApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        emailRegistredTextView = (AutoCompleteTextView)findViewById(R.id.registerEmailTextView);
        passwordRegistredTextView = (AutoCompleteTextView)findViewById(R.id.registerPasswordTextView);
        passwordConfirmedTextView = (AutoCompleteTextView)findViewById(R.id.confirmPasswordTextView);

        bloodTypeSpinner = (Spinner) findViewById(R.id.bloodTypeSpinner);

        cargarBloodTypes();

        registerUserButton = (Button)findViewById(R.id.user_sign_up_button);
        registerUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email_user = emailRegistredTextView.getText().toString();
                password_user = passwordRegistredTextView.getText().toString();
                password_user2 = passwordConfirmedTextView.getText().toString();
                blood_type_id = bloodTypeSpinner.getSelectedItemPosition();

                if(validCredentials()){
                    if(register_user()){
                        finish();
                    }
                }
            }
        });


    }


    private boolean validCredentials(){

        if (email_user.length() == 0){
            Log.d(TAG, "Necesario el Email");
            return false;
        }
        if(!email_user.contains("@")){
            Log.d(TAG, "Email inválido");
            return false;
        }
        if (password_user.length() == 0){
            Log.d(TAG, "Necesario password");
            return false;
        }
        if (password_user.equals(password_user2)){
            return true;
        }else{
            Log.d(TAG, "Reconfirmar el password correctamente");
        }

        return false;
    }

    private boolean register_user() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("strNumDni", "11223344");
            jsonObject.put("strNombre", email_user);
            jsonObject.put("strAppaterno", email_user);
            jsonObject.put("strApmaterno", email_user);
            jsonObject.put("strCorreo", email_user);
            jsonObject.put("strClaveUsuario", password_user);
            long idBloodType = bloodTypeAdapter.getItemId(bloodTypeSpinner.getSelectedItemPosition());
            jsonObject.put("intIndTipo", idBloodType);
            AndroidNetworking.post(DonanteService.DONANTE_URL)
                    .addJSONObjectBody(jsonObject)
                    .setTag(TAG_BLOOD_TYPE)
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsOkHttpResponse(new OkHttpResponseListener() {
                        @Override
                        public void onResponse(Response response) {
                            Log.d(TAG, "Registro Usuario Ok");
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.d(TAG,anError.getErrorBody());
                            Log.d(TAG,anError.getErrorDetail());
                            anError.printStackTrace();
                        }
                    });
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        Log.d(TAG, "Usuario registrado");
        return true;
    }


    String TAG_BLOOD_TYPE = "BloodTypeSpinner";
    private void cargarBloodTypes() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AndroidNetworking.get(CatalogoService.CATALOGO_URL)
                        .setTag(TAG_BLOOD_TYPE)
                        .build()
                        .getAsJSONArray(new JSONArrayRequestListener() {
                            @Override
                            public void onResponse(JSONArray response) {
                                List<String> items = new ArrayList<String>();
                                List<Long> values = new ArrayList<Long>();
                                try {
                                    for(int i = 0; i< response.length();i++) {
                                        if(response.getJSONObject(i).getJSONObject("idTipoCatalogo").getInt("srlIdCatalogo") ==3) {
                                            items.add(response.getJSONObject(i).getString("strDescripcion"));
                                            values.add(response.getJSONObject(i).getLong("srlIdCatalogo"));
                                        }
                                    }
                                    bloodTypeAdapter = new BloodTypeAdapter(RegisterUserActivity.this.getApplicationContext());
                                    bloodTypeAdapter.setItems(items);
                                    bloodTypeAdapter.setValues(values);
                                    bloodTypeSpinner.setAdapter(bloodTypeAdapter);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                anError.printStackTrace();
                            }
                        });
            }
        });



    }

}
