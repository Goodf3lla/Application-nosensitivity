package de.smartdev.application_nosensitivity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.smartdev.application_nosensitivity.MainActivity;
import de.smartdev.application_nosensitivity.R;

public class SignInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
        final Button button = (Button) findViewById(R.id.button_Sign_In);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(SignInActivity.this, MainActivity.class);
                        i.putExtra("message", "used sign in");
                        i.putExtra("is_signed_in", true);
                        startActivity(i);
                        finish();
                    }
                });
            }
        });
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
