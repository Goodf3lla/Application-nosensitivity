package de.smartdev.application_nosensitivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andi on 23.10.2015.
 * TODO: http://www.codeproject.com/Articles/119293/Using-SQLite-Database-with-Android
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    static final String dbName = "AnzeigenDB";

    static final String anzeigenTabelle = "Anzeigenshown";   //erste Tabelle
    static final String anzID = "AnzeigenID"; //TODO: im tutorial string, wäre evtl besser n int zu nehmen?
    static final String anzText = "AnzeigenName";
    static final String anzTTL = "TimeToLife";


    static final String anzMarkedTabelle = "Anzeienmarked";   //zweie Tabelle
    static final String anz_markedID = "Anzeigen_markedID";
    static final String anz_markedText = "Anzeigen_markedName";
    static final String anz_markedTTL = "TimeToLife_marked";

    static final String profilTabelle = "ProfilTabelle"; //TODO: update dataset aka die sachen die gespeichert werden müssen hier eintragen
    static final String surname = "Vorname";
    static final String lastname = "Nachname";

    static final String viewTest = "ViewTest";

    public DatabaseHelper(Context context, String databasename, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, databasename, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS" + anzeigenTabelle + " (" + anzID + " INTEGER PRIMARY KEY , " +
                anzText + " TEXT" + anzTTL + " TEXT)");

        db.execSQL("CREATE VIEW " + viewTest +
                " AS SELECT " + anzText + "." +
                " FROM " + anzeigenTabelle);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + anzeigenTabelle);
        db.execSQL("DROP VIEW IF EXISTS " + viewTest);
        onCreate(db);
    }

    public void insertDB() { //TODO: find best practice, do we insert data in onCreate or do we create a new method (done here, not sure about the method parameter)
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(anzID, 1);
        cv.put(anzText, "Test, test even more test");
        db.insert(anzeigenTabelle, anzID, cv);

        cv.put(anzID, 2);
        cv.put(anzText, "Lore ipsum...");
        db.insert(anzeigenTabelle, anzID, cv);
        //if (db.isDbLockedByCurrentThread()) { //TODO: necessary?
        db.close();
        //}

    }
}

