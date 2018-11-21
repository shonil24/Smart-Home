package com.smarthome.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuthenticationActivity extends AppCompatActivity {

    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        log = findViewById(R.id.Login);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(AuthenticationActivity.this,MainActivity.class);
                startActivity(l);
            }
        });
    }
}
