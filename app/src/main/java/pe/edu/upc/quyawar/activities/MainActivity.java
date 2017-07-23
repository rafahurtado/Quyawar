package pe.edu.upc.quyawar.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import pe.edu.upc.quyawar.QuyawarApp;
import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.fragments.AddCampaignFragment;
import pe.edu.upc.quyawar.fragments.EditProfileFragment;
import pe.edu.upc.quyawar.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity implements AddCampaignFragment.OnFragmentInteractionListener {

    private static String TAG = "QuyawarApp";

   BottomNavigationView.OnNavigationItemSelectedListener mListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           navigateAccording(item.getItemId());
           return true;
       }
   };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        BottomNavigationView navigation =  (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mListener);

        //navigateAccording(R.id.navigation_home);


        Button createCampaignButton = (Button) findViewById(R.id.createCampaignButton);
        Button donationsHomeButton = (Button) findViewById(R.id.donationsButton);
        Button listCampaignsHomeButton = (Button) findViewById(R.id.seeCampaignsButton);

        createCampaignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewCampaignActivity.class);
                startActivity(intent);
            }
        });
        donationsHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        listCampaignsHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CampaignsActivity.class));
            }
        });

    }


    private boolean navigateAccording(int id){

        Intent intent;

        switch (id){
            case R.id.navigation_home:
                //navigateToFragment( new HomeFragment());
            case R.id.navigation_add_campaign:
                intent = new Intent(MainActivity.this, NewCampaignActivity.class);
                startActivity(intent);
            case R.id.navigation_see_campaign:
                intent = new Intent(MainActivity.this, CampaignsActivity.class);
                startActivity(intent);
            case R.id.navigation_my_donations:
                intent = new Intent(MainActivity.this, DonationsActivity.class);
                startActivity(intent);
            case R.id.navigation_edit_profile:
                intent = new Intent(MainActivity.this, EditProfileActivity.class);
                startActivity(intent);
        }

        return false;
    }
/*
    private void navigateToFragment(Fragment fragment){
        try{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_edit_profile) {
            startActivity( new Intent(MainActivity.this, EditProfileActivity.class));
            return true;
        }else if (id == R.id.action_sign_out) {
            startActivity( new Intent(MainActivity.this, SignOutActivity.class));
            return true;
        }else if (id == R.id.action_terms_conditions) {
            startActivity( new Intent(MainActivity.this, TermsConditionsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //***
        if ( QuyawarApp.getInstance().isFirstTime()) {
            Intent iWelcome = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(iWelcome);
        }else {
            if (!QuyawarApp.getInstance().isAuthenticated()) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }
        // ...
    }
}
