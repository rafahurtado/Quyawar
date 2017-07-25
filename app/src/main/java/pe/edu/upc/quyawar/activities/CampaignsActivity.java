package pe.edu.upc.quyawar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.adapters.CampaignsAdapter;
import pe.edu.upc.quyawar.models.Campaign;
import pe.edu.upc.quyawar.network.QuyawarApiService;

public class CampaignsActivity extends AppCompatActivity {

    public static String TAG = "QuyawarApp";
    List<Campaign> campaigns;
    RecyclerView campaignsRecyclerView;
    CampaignsAdapter campaignsAdapter;
    RecyclerView.LayoutManager campaignsLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaigns);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampaignsActivity.this, NewCampaignActivity.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        campaigns = new ArrayList<>();
        campaignsAdapter = new CampaignsAdapter(campaigns);
        campaignsLayoutManager = new LinearLayoutManager(this);
        campaignsRecyclerView = (RecyclerView)findViewById(R.id.campaignsRecyclerView);
        campaignsRecyclerView.setLayoutManager(campaignsLayoutManager);
        campaignsRecyclerView.setAdapter(campaignsAdapter);
        updateCampaigns();

    }

    private void updateCampaigns(){
        AndroidNetworking
                .get(QuyawarApiService.CAMPAIGN_URL)
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d(TAG, "response object " + String.valueOf(response.getJSONArray("").length()) );
                            campaigns = Campaign.build(response.getJSONArray(""));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        campaignsAdapter.setCampaigns(campaigns);
                        campaignsAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, "anError : " + anError.getMessage());
                    }
                });
    }

}
