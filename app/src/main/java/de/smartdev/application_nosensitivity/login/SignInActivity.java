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

public class SignInActivity extends AppCompatActivity {
    LoginVerify verify = new LoginVerify();
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
        final Context context = getApplicationContext();
        final Button button = (Button) findViewById(R.id.button_Sign_In);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        EditText mEdit_user = (EditText) findViewById(R.id.etUserName_si);
                        username = mEdit_user.getText().toString();
                        EditText mEdit_pass = (EditText) findViewById(R.id.etPass_si);
                        password = mEdit_pass.getText().toString();
                        if (verify.checkSign_in(username, password) == false) {
                            Toast toast = Toast.makeText(context, "something failed", Toast.LENGTH_LONG);
                            toast.show();
                        } else {
                           /* mEdit_user.getText().clear();
                            mEdit_pass.getText().clear();  */
                            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                            intent.putExtra("message", "used sign in sucessfully");
                            intent.putExtra("is_signed_in", true);
                            startActivity(intent);
                            finish();
                        }
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
