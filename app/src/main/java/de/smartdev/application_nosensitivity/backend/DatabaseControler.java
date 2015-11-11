package de.smartdev.application_nosensitivity.backend;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukas on 11.11.15.
 */
public class DatabaseControler {

    private SQLiteDatabase db;
    private SQLiteDatabaseHelper dbHelper;
    private String[] anzeigeColumns = {"ID","ANZEIGEN_TEXT","TAGS","ADRESSE","LIFETIME","USER_ANZEIGE_ID"};

    public DatabaseControler(Context context){
        dbHelper = new SQLiteDatabaseHelper(context);
    }

    public void open() throws SQLException{
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Anzeige createAnzeige( String anzeigenText, String tags, String adresse, int lifetime, int userId){

        ContentValues values = new ContentValues();
        values.put("ANZEIGEN_TEXT",anzeigenText);
        values.put("TAGS",tags);
        values.put("ADRESSE",adresse);
        values.put("LIFETIME",lifetime);
        values.put("USER_ANZEIGE",userId);


        long insertId = db.insert("ANZEIGEN_TABLE",null,values);

        Cursor cursor = db.query("ANZEIGEN_TABLE",anzeigeColumns,"ID = "+ insertId,null,null,null,null,null);
        cursor.moveToFirst();

        return cursorToAnzeige(cursor);
    }
    private Anzeige cursorToAnzeige(Cursor cursor) {

        Anzeige anzeige = new Anzeige();
        anzeige.setId(cursor.getLong(0));
        anzeige.setAnzeigentxt(cursor.getString(1));
        anzeige.setTags(cursor.getString(2));
        anzeige.setAdresse(cursor.getString(3));
        anzeige.setLifetime(cursor.getInt(4));
        anzeige.setUserAnzeigeId(cursor.getLong(5));

        return anzeige;


    }


    public List<Anzeige> getAllAnzeigen(){

        List<Anzeige> allList= new ArrayList<Anzeige>();

        Cursor cursor = db.query("ANZEIGEN_TABLE",anzeigeColumns,null,null,null,null,null,null);
        cursor.moveToFirst();

        if(cursor.getCount()==0) return allList;

        while(cursor.isAfterLast()==false){
            Anzeige anzeige = cursorToAnzeige(cursor);
            allList.add(anzeige);
            cursor.moveToNext();
        }
        cursor.close();

        return allList;


    }





}