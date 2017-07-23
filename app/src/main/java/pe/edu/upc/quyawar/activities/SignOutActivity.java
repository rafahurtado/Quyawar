package pe.edu.upc.quyawar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import pe.edu.upc.quyawar.QuyawarApp;
import pe.edu.upc.quyawar.R;

public class SignOutActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    Button signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);

        signOutButton = (Button) findViewById(R.id.sign_out_button);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                QuyawarApp.getInstance().setAuthenticated(false);
                finish();
            }
        });

    }
}
