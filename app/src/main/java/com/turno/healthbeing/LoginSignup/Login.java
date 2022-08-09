package com.turno.healthbeing.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.turno.healthbeing.AllFeatures;
import com.turno.healthbeing.R;

public class Login extends AppCompatActivity {

    ImageView loginbackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbackbtn = findViewById(R.id.login_back_button);

        loginbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.super.onBackPressed();
            }
        });
    }




}