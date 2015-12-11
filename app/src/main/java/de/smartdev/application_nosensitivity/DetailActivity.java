package de.smartdev.application_nosensitivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        int index = intent.getIntExtra("position", 0);
        String message = Integer.toString(index);
        Toast toast = Toast.makeText(DetailActivity.this, message, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onBackPressed() {//TODO: pass sign in data
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
