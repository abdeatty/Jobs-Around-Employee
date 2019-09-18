package com.amaz.jobsaround.ui.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amaz.jobsaround.R;
import com.amaz.jobsaround.ui.activities.verification_phone_number.VerificationPhoneNumberActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.send_code_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this , VerificationPhoneNumberActivity.class));
            }
        });
    }
}
