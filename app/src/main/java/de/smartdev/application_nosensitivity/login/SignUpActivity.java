package de.smartdev.application_nosensitivity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.smartdev.application_nosensitivity.MainActivity;
import de.smartdev.application_nosensitivity.R;

public class SignUpActivity extends AppCompatActivity {
    LoginVerify verify = new LoginVerify();
    private String email;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        final Context context = getApplicationContext();
        final Button button = (Button) findViewById(R.id.button_Sign_Up);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText mEdit_email = (EditText) findViewById(R.id.etEmail_su);
                email = mEdit_email.getText().toString();
                EditText mEdit_user = (EditText) findViewById(R.id.etUserName_su);
                username = mEdit_user.getText().toString();
                EditText mEdit_pass = (EditText) findViewById(R.id.etPass_su);
                password = mEdit_pass.getText().toString();
                if (verify.checkSign_up(email, username, password) == false) {
                    Toast toast = Toast.makeText(context, "something failed while signing up", Toast.LENGTH_LONG);
                    toast.show();
                } else {//TODO: safe data in DB
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
