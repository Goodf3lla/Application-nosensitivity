package de.smartdev.application_nosensitivity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import de.smartdev.application_nosensitivity.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
    }

    @Override
    public void onBackPressed() { //fängt die zurück taste des handys ab sodass nicht die app geschlossen wird sondern die loginactivity nochmal aufgerufen wird
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
