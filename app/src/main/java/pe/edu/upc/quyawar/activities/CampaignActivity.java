package pe.edu.upc.quyawar.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import pe.edu.upc.quyawar.QuyawarApp;
import pe.edu.upc.quyawar.models.Campaign;

public class CampaignActivity extends AppCompatActivity {

    Campaign campaign;

    TextView descriptionTextView;
    TextView localTextView;
    TextView ubicationTextView;
    TextView bloodTypeTextView;
    ImageButton locationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        campaign = QuyawarApp.getInstance().getCurrentCampaign();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAccept);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action ACCEPT", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FloatingActionButton fabDeny = (FloatingActionButton) findViewById(R.id.fabDeny);
        fabDeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action DENY", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        descriptionTextView = (TextView)findViewById(R.id.descriptionTextView);
        localTextView = (TextView)findViewById(R.id.localTextView);
        ubicationTextView = (TextView)findViewById(R.id.ubicationTextView);
        bloodTypeTextView = (TextView)findViewById(R.id.bloodTypeTextView);
        locationButton = (ImageButton)findViewById(R.id.locationButton);

        descriptionTextView.setText(campaign.getDescription());
        localTextView.setText(campaign.getLocalDonation());
        ubicationTextView.setText(campaign.getDistrito());
        bloodTypeTextView.setText(campaign.getBloodType());
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
