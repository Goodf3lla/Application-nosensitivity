package de.smartdev.application_nosensitivity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import de.smartdev.application_nosensitivity.R;

public class SignInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
    }

    @Override
    public void onBackPressed() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SignInActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }


}
