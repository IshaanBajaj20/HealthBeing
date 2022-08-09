package com.turno.healthbeing.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.turno.healthbeing.AllFeatures;
import com.turno.healthbeing.R;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    ImageView backBtn;
    TextView titleText;
    Button login, next;
    TextInputLayout fullName, username, email, password;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;
    CountryCodePicker countryCodePicker;
    TextInputLayout phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        backBtn = findViewById(R.id.signup_back_button);
        titleText = findViewById(R.id.signup_title_text);
        login = findViewById(R.id.signup_login_btn);
        next = findViewById(R.id.signup_next_btn);
        fullName = findViewById(R.id.signup_full_name);
        username = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNumber = findViewById(R.id.signup_phone_number);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp.super.onBackPressed();
            }
        });
    }

    public void callVerifyOTPScreen(View view){
        if (!validateFullname() | !validateUsername() | !validateEmail() | !validatePassword() | !validateGender() | !validateAge() | !validatePhoneNumber()){
            return;
        }

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());

        String _gender;
        _gender = selectedGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String _date;
        _date = day +"/"+ month +"/"+year;

        String _fullName = getIntent().getStringExtra("fullName");
        String _email = getIntent().getStringExtra("email");
        String _username = getIntent().getStringExtra("username");
        String _password = getIntent().getStringExtra("password");
        _date = getIntent().getStringExtra("date");
        _gender = getIntent().getStringExtra("gender");

        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _phoneNo = "+"+countryCodePicker.getFullNumber()+_getUserEnteredPhoneNumber;

        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);

        intent.putExtra("fullName", _fullName);
        intent.putExtra("email", _email);
        intent.putExtra("username", _username);
        intent.putExtra("password", _password);
        intent.putExtra("date", _date);
        intent.putExtra("gender", _gender);
        intent.putExtra("phoneNo", _phoneNo);

        startActivity(intent);
    }




    public void openLoginScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }



    private boolean validateFullname(){
        String value =  fullName.getEditText().getText().toString().trim();

        if(value.isEmpty()){
            fullName.setError("Field cannot be empty");
            return false;
        }
        else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername(){
        String value =  username.getEditText().getText().toString().trim();

        if(value.isEmpty()){
            username.setError("Field cannot be empty");
            return false;
        }
        else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail(){
        String value =  email.getEditText().getText().toString().trim();

        if(value.isEmpty()){
            email.setError("Field cannot be empty");
            return false;
        }
        else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){
        String value =  password.getEditText().getText().toString().trim();

        if(value.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select your Gender", Toast.LENGTH_SHORT).show();
            return false;

        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 10) {
            Toast.makeText(this, "You are less than 10 years old", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePhoneNumber(){
        String value =  phoneNumber.getEditText().getText().toString().trim();

        if(value.isEmpty()){
            phoneNumber.setError("Field cannot be empty");
            return false;
        }
        else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }

    }


}