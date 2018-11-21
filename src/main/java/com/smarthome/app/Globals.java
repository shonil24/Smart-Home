package com.smarthome.app;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Application;

public class Globals extends Application{
    private TextView togtxt;
    private static int flag;

    private Globals(){

    }
    public void setFlag(int t){
        Globals.flag=t;
    }
    public int getFlag(){
        return Globals.flag;
    }


}
