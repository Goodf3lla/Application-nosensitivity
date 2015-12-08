package de.smartdev.application_nosensitivity.backend;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by Andi on 17.11.2015.
 */
public class DatabaseControler {


    AnzeigenDbHelper userHelper;
    SQLiteDatabase db;
    Context context;

    public void insertDataToDatabase(String id, String text, String tags, String adresse, String lifetime, String userId) {

        userHelper = new AnzeigenDbHelper(context);
        db = userHelper.getWritableDatabase();

        userHelper.addAnzeige(id, text, tags, adresse, lifetime, userId, db);
        userHelper.close();
    }


    public void createMock1() {

        String id = "0001";
        String text = "die erste Anzeige";
        String tags = "alles was du willst";
        String adresse = "arcis 20";
        String lifetime = "50";
        String userId = "001";

        insertDataToDatabase(id, text, tags, adresse, lifetime, userId);

    }

    public void createMock2() {

        String id = "0002";
        String text = "Lorem ipsum dolor";
        String tags = "Veganer; Asiatisch";
        String adresse = "Musterstraße 2";
        String lifetime = "55";
        String userId = "002";

        insertDataToDatabase(id, text, tags, adresse, lifetime, userId);

    }
}
