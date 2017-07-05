package pe.edu.upc.quyawar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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
/*
        Spinner spinner = (Spinner) getView().findViewById(R.id.spinner_type_blood);
        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource((getActivity().getBaseContext()), R.array.blood_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
*/

/*
        Button.OnClickListener mListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionButton();
            }
        };

        Button btnCancelar = getView().findViewById(R.id.btn_cancelar);
        Button btnSiguiente = getView().findViewById(R.id.btn_siguiente);

        btnCancelar.setOnClickListener(mListener);
        btnCancelar.setOnClickListener(mListener);
*/


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_campaign, container, false);
    }


    private void actionButton(){
        EditText edMensaje =  (EditText)getView().findViewById(R.id.et_mensaje);
        edMensaje.setText("hice click");
    }

}
