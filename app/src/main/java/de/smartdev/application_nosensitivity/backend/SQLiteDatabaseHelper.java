package de.smartdev.application_nosensitivity.backend;

/**
 * Created by lukas on 11.11.15.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lukas on 10.11.15.
 */
public class SQLiteDatabaseHelper extends SQLiteOpenHelper{


    private static final  String DATABASE_NAME = "eatSmart.db";
    private static final int DATABASE_VERSION = 1;


    private static final String ANZEIGEN_STRING =
            "CREATE TABLE ANZEIGEN_TABLE ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ANZEIGEN_TEXT text,"
                    + "TAGS text,"
                    + "ADRESSE text,"
                    + "LIFETIME int,"
                    + "USER_ANZEIGE_ID int)";




    public SQLiteDatabaseHelper (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ANZEIGEN_STRING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ANZEIGEN_TABLE");
        onCreate(db);
    }
}
