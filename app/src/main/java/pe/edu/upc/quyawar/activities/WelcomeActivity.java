package pe.edu.upc.quyawar.activities;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.edu.upc.quyawar.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener  {

    @Override
    public void onClick(View view) {
        attemptWelcome();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        //Button btnWelcome = (Button) findViewById(R.id.btn_welcome);

        //btnWelcome.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        attemptWelcome();
        //    }
        //});

    }

    private  void attemptWelcome(){
        TextView tv = (TextView) findViewById( R.id.tv_welcome);
        tv.setText(R.string.app_name);

        //setContentView(R.layout.activity_login);
    }

}
