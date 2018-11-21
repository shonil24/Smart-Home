package com.smarthome.app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar ;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        //set title text color of toolbar i.e ancient game to white color

        drawerLayout =  findViewById(R.id.drawer_layout);// a layout for nav items

        navigationView =  findViewById(R.id.navigation_view);// a view on layout to be placed and viewed
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        //actionbar 2nd arg Drawer obj ,3rd arg toolbar obj
        //4th,4th arg for opening and closing nav drawer
        //This adds 3 horizontal lines button on main from where u toggle nav drawer//
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        displaySelectedScreen(R.id.home);//keep by default checked

    }


    @Override
    public void onBackPressed() {
        //Goto Code Menu -> Overrride methods -> search onbackpressed -> click ok {Pressing back button executes code within this function}
        //This as clicking back button even if nav drawer is open exits app directly.Instead only nav should be close 1st and  then Again pressing
        //backbutton should close the app.Making this so if nav drawer is open 1st back button click closes nav drawer and then 2nd click closes app

        //everytime back pressed changed the title of toolbar
        FragmentManager frm = getSupportFragmentManager();  //this line
        int count = frm.getBackStackEntryCount();           //this line is uesless its for checking count<=0 to end current fragment
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) { //if nav drawer open from left(gravity start means from left)

            drawerLayout.closeDrawer(GravityCompat.START); //if open close it to left side of screen
        }
        else if(count<=-1){
            finish();
        }
        else {
            String title = frm.getBackStackEntryAt(count-1).getName();
            if(title.equals("Door") || title.equals("Living Room") || title.equals("Bathroom") || title.equals("Bedroom") || title.equals("Dining Room")){
                super.onBackPressed();
                //displaySelectedScreen(R.id.home);
                toolbar.setTitle("Home");

                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
                drawerLayout.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                toggle.syncState();
            }

        }

    }

    @SuppressWarnings("StatementwithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        displaySelectedScreen(item.getItemId());
        return true;
    }

    //main code for any item selection{its called in abve function}
    private void displaySelectedScreen(int itemId){
        //creating fragment obj
        homefragment fragment = null;
        //above actual class name or fragment name of home class which extends fragment class
        //when user selects any of nav drawer items code below inside itemselected is executed
        //int id = item.getItemId(); returns item id of item selected by user(replaced with itemid)

        switch (itemId) {
            case R.id.home:
                Toast.makeText(getApplicationContext(),"home",Toast.LENGTH_LONG).show();
                fragment = new homefragment();

                //following for when again i goto home previous all fragments replaced and backbutton changed to
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
                drawerLayout.addDrawerListener(toggle);
                toggle.setDrawerIndicatorEnabled(true);
                toggle.syncState();
                break;
            case R.id.appliances:
                Toast.makeText(getApplicationContext(),"appliances",Toast.LENGTH_LONG).show();
                break;
            case R.id.security:
                Toast.makeText(getApplicationContext(),"security",Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Toast.makeText(getApplicationContext(),"settings",Toast.LENGTH_LONG).show();
                break;
            case R.id.about:
                Toast.makeText(getApplicationContext(),"about",Toast.LENGTH_LONG).show();
                break;
            case R.id.logout:
                Toast.makeText(getApplicationContext(),"user logged out",Toast.LENGTH_LONG).show();
                Intent inten = new Intent(MainActivity.this,AuthenticationActivity.class);
                // Closing all the Activities in stack .bcoz even if u logout and pressed back button still mainactivity is displayed
                //we want after logout login screen must be displayed and after that pressing back should exit app instead showing last activity used e.g mainactivity
                inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //clears top activity from stack
                inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); //clears all the task

                // Add new Flag to start new Activity which will be launching activity (login activity)
                inten.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(inten);
                finish(); //finish logout instance so this will end logout and clear stack part
                break;
            //Toast displays the text written in quotes of makeText for each selection of item
            //getApplicationContext() = gets the current activity which is running or upon the user is
            //1st 4 are in one group so when any of 4 selected and it still remains selected even after after selecting
            //items other than this group i.e e.g share ,setings are of other group or submenu
        }

        //replacing fragment
        if(fragment!=null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, "home frag");  //can use replace/add as well
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commitNowAllowingStateLoss();
        }
        //Close drawer after selecting an item

        drawerLayout.closeDrawer(GravityCompat.START); //(gravity start) means nav drawer close to left side of screen
    }
}
