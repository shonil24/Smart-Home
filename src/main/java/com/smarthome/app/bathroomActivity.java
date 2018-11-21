package com.smarthome.app;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class bathroomActivity extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_bathroom, container, false);

        if(getActivity()!=null){
            getActivity().setTitle("Bathroom");
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        //This will set the back button on toolbar when door layout is displayed


        setHasOptionsMenu(true); //This to make sure options is true as pressing back button will open the drawer and
        //wait for menu item to be pressed so it has to know it is already enabled
        //what happends after back button click is it opends drawer code is written in manacivity where button listener is available
        //Listener is overrriding onOptionsSelected which will be called when button is clicked


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button tlight;
        final TextView togtxt;
       // final Globals g = (Globals) getActivity();
        tlight = view.findViewById(R.id.roomslightimg);
        togtxt = view.findViewById(R.id.togglebathlit);
        tlight.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.roomslightimg:
                //final Globals g = getActivity();
                //g.setFlag(0);


                break;
        }
    }

}

