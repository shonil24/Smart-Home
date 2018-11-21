package com.smarthome.app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class homefragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getActivity() != null) {
            getActivity().setTitle("Home");
        }
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton doorbtn, livingbtn, diningbtn, bedroombtn, bathroombtn;
        /*if(getActivity()!=null) {
            getActivity().setTitle("Home");
        }*/

        doorbtn = view.findViewById(R.id.doorimg);
        livingbtn = view.findViewById(R.id.livroomimg);
        diningbtn = view.findViewById(R.id.diningroomimg);
        bedroombtn = view.findViewById(R.id.bedroomimg);
        bathroombtn = view.findViewById(R.id.bathroomimg);

        doorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Door", Toast.LENGTH_LONG).show();

                Fragment ndoorActivity = new doorActivity();
                FragmentManager fm = getActivity().getSupportFragmentManager(); //dont use getChildFragmentManager() app crashes
                //as its nested under activity use this
                FragmentTransaction ft = fm.beginTransaction();//either use this or getActivity().getFragmentManager()
                //get child bcoz this one comes from activity as a fragment

                Fragment hfragment = new homefragment();//check if exists but it alredy exits
                ft.hide(hfragment);
                //just hide when back is pressed from next fragment all saved dta is shown

                ft.add(R.id.content_frame, ndoorActivity, "door frag"); //its actually Window.ID_ANDROID_CONTENT
                //as we need to make a stack process will run in background
                //replace will just replace with othe screen not remove from stack(but as its 2nd last fragment after this is next
                // last fragment so use add and use container for all fragments)
                ft.addToBackStack("Door");
                //added to back stack
                ft.commit();
            }
        });
        livingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Living Room", Toast.LENGTH_LONG).show();

                Fragment nlivingActivity = new livingActivity();  //this javaclass are actually fragment(ignore names)
                FragmentManager fm = getActivity().getSupportFragmentManager(); //dont use getChildFragmentManager() app crashes

                FragmentTransaction ft = fm.beginTransaction();
                Fragment hfragment = new homefragment();//check if exists but it alredy exits
                ft.hide(hfragment);
                ft.add(R.id.content_frame, nlivingActivity, "living frag");
                ft.addToBackStack("Living Room");
                ft.commit();

            }
        });
        diningbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Dining Room", Toast.LENGTH_LONG).show();

                Fragment ndiningActivity = new diningActivity();
                FragmentManager fm = getActivity().getSupportFragmentManager(); //dont use getChildFragmentManager() app crashes

                FragmentTransaction ft = fm.beginTransaction();
                Fragment hfragment = new homefragment();//check if exists but it alredy exits
                ft.hide(hfragment);
                ft.add(R.id.content_frame, ndiningActivity, "dining frag");
                ft.addToBackStack("Dining Room");
                ft.commit();

            }
        });
        bedroombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Bedroom", Toast.LENGTH_LONG).show();

                Fragment nbedroomActivity = new bedroomActivity();
                FragmentManager fm = getActivity().getSupportFragmentManager(); //dont use getChildFragmentManager() app crashes

                FragmentTransaction ft = fm.beginTransaction();
                Fragment hfragment = new homefragment();//check if exists but it alredy exits
                ft.hide(hfragment);
                ft.add(R.id.content_frame, nbedroomActivity, "bedroom frag");
                ft.addToBackStack("Bedroom");
                ft.commit();

            }
        });
        bathroombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Bathroom", Toast.LENGTH_LONG).show();

                Fragment nbathroomActivity = new bathroomActivity();
                FragmentManager fm = getActivity().getSupportFragmentManager(); //dont use getChildFragmentManager() app crashes

                FragmentTransaction ft = fm.beginTransaction();
                Fragment hfragment = new homefragment();//check if exists but it alredy exits
                ft.hide(hfragment);
                ft.add(R.id.content_frame, nbathroomActivity, "bathroom frag");
                ft.addToBackStack("Bathroom");
                ft.commit();

            }
        });


    }
}