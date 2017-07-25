package pe.edu.upc.quyawar.adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.quyawar.QuyawarApp;
import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.activities.CampaignActivity;
import pe.edu.upc.quyawar.models.Campaign;

/**
 * Created by rhurtado on 24/07/2017.
 */

public class CampaignsAdapter extends RecyclerView.Adapter<CampaignsAdapter.ViewHolder> {

    private static final String TAG = "QuyawarApp";
    List<Campaign> campaigns;

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public CampaignsAdapter() {
        this.campaigns = new ArrayList<>();
    }

    @Override
    public CampaignsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.card_campaign, parent, false));
    }

    @Override
    public void onBindViewHolder(CampaignsAdapter.ViewHolder holder, final int position) {

        Log.d(TAG, "position: " + String.valueOf(position));
        Log.d(TAG, "campaigns size " + String.valueOf(campaigns));

        holder.descriptionTextView.setText(campaigns.get(position).getDescription());
        holder.localTextView.setText(campaigns.get(position).getLocalDonation() + " - " +
                                    campaigns.get(position).getDistrito());
        holder.bloodTypeTextView.setText(campaigns.get(position).getBloodType());

        holder.campaignCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuyawarApp.getInstance().setCurrentCampaign(campaigns.get(position));
                view.getContext().startActivity(new Intent(view.getContext(), CampaignActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return campaigns.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTextView;
        TextView localTextView;
        TextView bloodTypeTextView;
        CardView campaignCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            campaignCardView = (CardView) itemView.findViewById(R.id.campaignCardView);
            descriptionTextView = (TextView)itemView.findViewById(R.id.descriptionTextView);
            localTextView = (TextView)itemView.findViewById(R.id.localTextView);
            bloodTypeTextView = (TextView)itemView.findViewById(R.id.bloodTypeTextView);
        }
    }
}
