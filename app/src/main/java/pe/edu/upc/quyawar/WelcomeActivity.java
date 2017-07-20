package pe.edu.upc.quyawar;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

/*
        Button btnIngresar = (Button) findViewById(R.id.);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptWelcome();
            }
        });
*/
    }

    private  void attemptWelcome(){
        TextView tv = (TextView) findViewById( R.id.tv_welcome);
        tv.setText(R.string.app_name);

        //setContentView(R.layout.activity_login);
    }

}
