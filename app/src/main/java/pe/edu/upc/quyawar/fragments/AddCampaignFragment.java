package pe.edu.upc.quyawar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.quyawar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCampaignFragment extends Fragment {


    public AddCampaignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_campaign, container, false);
    }

}
