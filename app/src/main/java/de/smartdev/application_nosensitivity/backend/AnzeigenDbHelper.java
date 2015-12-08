package de.smartdev.application_nosensitivity.backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by lukas on 08.12.15.
 */
public class AnzeigenDbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "anzeigen.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_ANZEIGE_QUERY =
            "CREATE TABLE " + Anzeigen.AnzeigeInfo.TABLE_NAME + "("
                    + Anzeigen.AnzeigeInfo.ANZEIGE_ID + " TEXT,"
                    + Anzeigen.AnzeigeInfo.ANZEIGE_TEXT + " TEXT,"
                    + Anzeigen.AnzeigeInfo.ANZEIGE_TAGS + " TEXT,"
                    + Anzeigen.AnzeigeInfo.ANZEIGE_ADRESSE + " TEXT,"
                    + Anzeigen.AnzeigeInfo.ANZEIGE_LIFETIME + " INTEGER,"
                    + Anzeigen.AnzeigeInfo.ANZEIGE_USERS_ANZEIGE_ID + " TEXT);";


    public AnzeigenDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATION", "Database created / opened..");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ANZEIGE_QUERY);
        Log.e("DATABASE OPERATION", "Anzeige table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Anzeigen.AnzeigeInfo.TABLE_NAME);
        db.execSQL(CREATE_ANZEIGE_QUERY);
        Log.e("DATABASE OPERATION", "User table created after upgrade");
    }


    public void addAnzeige(String id, String anzeigeText, String tags, String adresse, String lifetime, String anzUserId, SQLiteDatabase db) {

        ContentValues content = new ContentValues();
        content.put(Anzeigen.AnzeigeInfo.ANZEIGE_ID, id);
        content.put(Anzeigen.AnzeigeInfo.ANZEIGE_TEXT, anzeigeText);
        content.put(Anzeigen.AnzeigeInfo.ANZEIGE_TAGS, tags);
        content.put(Anzeigen.AnzeigeInfo.ANZEIGE_ADRESSE, adresse);
        content.put(Anzeigen.AnzeigeInfo.ANZEIGE_LIFETIME, lifetime);
        content.put(Anzeigen.AnzeigeInfo.ANZEIGE_USERS_ANZEIGE_ID, anzUserId);

        db.insert(Anzeigen.AnzeigeInfo.TABLE_NAME, null, content);

        Log.e("DATABASE OPERATION", "One row inserted");
    }

    public Cursor getAnzeigenInfo(SQLiteDatabase db) {

        Log.e("DATABASE OPERATION", "get Anzeigen befor");

        Cursor cursor;
        String[] listOfAnzeigen = {Anzeigen.AnzeigeInfo.ANZEIGE_ID, Anzeigen.AnzeigeInfo.ANZEIGE_TEXT, Anzeigen.AnzeigeInfo.ANZEIGE_TAGS,
                Anzeigen.AnzeigeInfo.ANZEIGE_ADRESSE, Anzeigen.AnzeigeInfo.ANZEIGE_LIFETIME, Anzeigen.AnzeigeInfo.ANZEIGE_USERS_ANZEIGE_ID};
        cursor = db.query(Anzeigen.AnzeigeInfo.TABLE_NAME, listOfAnzeigen, null, null, null, null, null);

        Log.e("DATABASE OPERATION", "get Anzeigen after");

        return cursor;
    }


}