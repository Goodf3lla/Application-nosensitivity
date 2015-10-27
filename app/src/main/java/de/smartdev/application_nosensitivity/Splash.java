package de.smartdev.application_nosensitivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import de.smartdev.application_nosensitivity.login.LoginActivity;

/**
 * Created by Andi on 27.09.2015.
 */
public class Splash extends Activity {
    private static int zeit = 1000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, LoginActivity.class);
                startActivity(i);
                finish();

            }
        }, zeit);
    }
}
