package pe.edu.upc.quyawar.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.models.Local;

/**
 * Created by joseluis on 25/07/17.
 */

public class SedeLocalsAdapter extends RecyclerView.Adapter<SedeLocalsAdapter.ViewHolder>{
    private static final String TAG = "QuyawarLocalsApp";
    List<Local> locals;

    public void setLocals(List<Local> locals) {
        this.locals = locals;
    }
    public SedeLocalsAdapter(){
        this.locals = new ArrayList<>();
    }

    @Override
    public SedeLocalsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_locals, parent, false));

    }

    @Override
    public void onBindViewHolder(SedeLocalsAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "position: " + String.valueOf(position));
        Log.d(TAG, "locals size " + String.valueOf(locals));

        holder.localNameTextView.setText(locals.get(position).getName());
        holder.localAddressTextView.setText(locals.get(position).getAddress());

        /*

        holder.campaignCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuyawarApp.getInstance().setCurrentCampaign(campaigns.get(position));
                view.getContext().startActivity(new Intent(view.getContext(), CampaignActivity.class));
            }
        });
         */
    }

    @Override
    public int getItemCount() {
        return locals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView localNameTextView;
        TextView localAddressTextView;
        CardView localCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            localCardView = (CardView) itemView.findViewById(R.id.localCardView);
            localNameTextView = (TextView) itemView.findViewById(R.id.localNameTextView);
            localAddressTextView = (TextView) itemView.findViewById(R.id.localAddressTextView);
        }

    }
}
