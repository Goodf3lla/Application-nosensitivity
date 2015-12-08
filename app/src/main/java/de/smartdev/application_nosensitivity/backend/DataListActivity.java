package de.smartdev.application_nosensitivity.backend;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import de.smartdev.application_nosensitivity.R;

public class DataListActivity extends AppCompatActivity {


    ListView list;
    AnzeigenDbHelper helper;
    SQLiteDatabase db;

    Cursor cursor;
    ListDataAdapter listDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        list = (ListView) findViewById(R.id.listView_anzeigenList);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout_anzeige);
        list.setAdapter(listDataAdapter);

        helper = new AnzeigenDbHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        cursor = helper.getAnzeigenInfo(db);

        if (cursor.moveToFirst()) {

            do {
                String id, text, tags, adresse, lifetime, userId;
                id = cursor.getString(0);
                text = cursor.getString(1);
                tags = cursor.getString(2);
                adresse = cursor.getString(3);
                lifetime = cursor.getString(4);
                userId = cursor.getString(5);

                AnzeigeEntry entry = new AnzeigeEntry(id, text, tags, adresse, lifetime, userId);
                listDataAdapter.add(entry);

            } while (cursor.moveToNext());
        }
    }

}

