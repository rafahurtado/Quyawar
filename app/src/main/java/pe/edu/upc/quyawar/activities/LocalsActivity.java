package pe.edu.upc.quyawar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.adapters.SedeLocalsAdapter;
import pe.edu.upc.quyawar.models.Local;
import pe.edu.upc.quyawar.network.LocalsApiService;

public class LocalsActivity extends AppCompatActivity {
    //private Local local;
    private List<Local> locals;
    public static String TAG = "QuyawarLocalsApp";
    RecyclerView localsRecyclerView;
    SedeLocalsAdapter localsAdapter;
    RecyclerView.LayoutManager localsLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        locals = new ArrayList<>();
        localsAdapter = new SedeLocalsAdapter();
        localsLayoutManager = new LinearLayoutManager(this);

        localsRecyclerView = (RecyclerView)findViewById(R.id.localsRecyclerView);
        localsRecyclerView.setLayoutManager(localsLayoutManager);
        localsRecyclerView.setAdapter(localsAdapter);

        updateLocals();
    }

    private void updateLocals(){
        locals = new ArrayList<>();
        AndroidNetworking
                .get(LocalsApiService.LOCALS_URL)
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "response length -> " + String.valueOf(response.length()) );
                        locals = Local.build(response);
                        localsAdapter.setLocals(locals);
                        localsAdapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, "anError : " + anError.getMessage());
                    }
                });

    }
    /*
        private void updateCampaigns(){
        AndroidNetworking
                .get(QuyawarApiService.CAMPAIGN_URL)
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int res = response.length();
                        Log.d(TAG, "response length -> " + String.valueOf(response.length()) );
                        campaigns = Campaign.build(response);
                        campaignsAdapter.setCampaigns(campaigns);
                        campaignsAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, "anError : " + anError.getMessage());
                    }
                });
    }
     */



    /*
        private void updateQuotes(){
        quotes = new ArrayList<>();
        AndroidNetworking
                .get(QuotesAPIServices.QUOTES_URL)
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jresponse = response.getJSONObject(i);
                                String id = jresponse.getString("id");
                                String author = jresponse.getString("author");
                                String quote = jresponse.getString("quote");
                                String permalink = jresponse.getString("permalink");
                                quotes.add(i,new Quote(id,author,quote,permalink));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        int size = quotes.size();
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }
     */

}
