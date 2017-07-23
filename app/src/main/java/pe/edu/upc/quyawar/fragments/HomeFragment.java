package pe.edu.upc.quyawar.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import pe.edu.upc.quyawar.R;
import pe.edu.upc.quyawar.activities.NewCampaignActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    Button createHomeButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = (LinearLayout)inflater.inflate(R.layout.fragment_home, container, false);

        //** fragment Home
        createHomeButton = (Button) rootView.findViewById(R.id.createCampaignHomeButton);
        Button donationsHomeButton = (Button) rootView.findViewById(R.id.donationsHomeButton);
        Button listCampaignsHomeButton = (Button) rootView.findViewById(R.id.seeCampaignsHomeButton);

        createHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NewCampaignActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}
