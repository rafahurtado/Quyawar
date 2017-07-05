package pe.edu.upc.quyawar.activities;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.fragments.AddCampaignFragment;
import pe.edu.upc.quyawar.fragments.EditProfileFragment;
import pe.edu.upc.quyawar.fragments.HomeFragment;
import pe.edu.upc.quyawar.fragments.MyDonationsFragment;
import pe.edu.upc.quyawar.fragments.SeeCampaignFragment;

public class MainActivity extends AppCompatActivity {

    boolean firstTime = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateAccording(item.getItemId());
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (firstTime) {
            setContentView(R.layout.activity_welcome);
        }else {
            setContentView(R.layout.activity_main);
        }

        BottomNavigationView navigation =  (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private Fragment getFragmentFor(int id){

        TextView tvMensaje = (TextView) findViewById(R.id.tv_message);

        switch (id){
            case R.id.navigation_home:
                tvMensaje.setText(R.string.title_home);
                return new HomeFragment();
            case R.id.navigation_add_campaign:
                tvMensaje.setText(R.string.title_add_camp);
                return new AddCampaignFragment();
            case R.id.navigation_see_campaign:
                tvMensaje.setText("R.string.title_see_campaign");
                return new SeeCampaignFragment();
            case R.id.navigation_my_donations:
                tvMensaje.setText(R.string.title_my_donations);
                return new MyDonationsFragment();
            case R.id.navigation_edit_profile:
                tvMensaje.setText("R.string.title_edit_profile");
                ((TextView) findViewById(R.id.tv_message)).setText("Editar");

                return new EditProfileFragment();
        }
        return null;
    }

    private boolean navigateAccording(int id){
        try{

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content,getFragmentFor(id))
                    .commit();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
