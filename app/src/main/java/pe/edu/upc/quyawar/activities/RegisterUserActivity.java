package pe.edu.upc.quyawar.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import pe.edu.upc.quyawar.R;

public class RegisterUserActivity extends AppCompatActivity {

    AutoCompleteTextView emailRegistredTextView;
    AutoCompleteTextView passwordRegistredTextView;
    AutoCompleteTextView passwordConfirmedTextView;
    Spinner bloodTypeSpinner;
    Button registerUserButton;

    String email_user;
    String password_user, password_user2;

    Integer blood_type_id;

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
        Log.d(TAG, "Usuario registrado");
        return true;
    }

}
