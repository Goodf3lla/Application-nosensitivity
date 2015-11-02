package de.smartdev.application_nosensitivity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.smartdev.application_nosensitivity.MainActivity;
import de.smartdev.application_nosensitivity.R;

public class SignUpActivity extends AppCompatActivity {
    private String email;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        final Button button = (Button) findViewById(R.id.button_Sign_Up);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                        i.putExtra("message", "used sign up");
                        i.putExtra("is_signed_in", true);
                        startActivity(i);
                        finish();
                    }
                });
            }
        });
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
