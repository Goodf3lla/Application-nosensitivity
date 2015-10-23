package de.smartdev.application_nosensitivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andi on 23.10.2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    static final String dbName = "AnzeigenDB";

    static final String AnzeigenTabelle = "Anzeigenshown";   //erste Tabelle
    static final String anzID = "AnzeigenID";
    static final String anzText = "AnzeigenName";
    static final String anzTTL = "TimeToLife";


    static final String anzMarkedTabelle = "Anzeienmarked";   //zweie Tabelle
    static final String anz_markedID = "Anzeigen_markedID";
    static final String anz_markedText = "Anzeigen_markedName";
    static final String anz_markedTTL = "TimeToLife_marked";

    static final String viewTest = "ViewTest";

    public DatabaseHelper(Context context, String databasename, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, databasename, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL("CREATE TABLE "+deptTable+" ("+colDeptID+ " INTEGER PRIMARY KEY , "+
                colDeptName+ " TEXT)");


        db.execSQL("CREATE VIEW " + viewTest +
                        " AS SELECT " + AnzeigenTabelle + "." + colID + " AS _id," +
                        " " + AnzeigenTabelle + "." + colName + "," +
                        " " + AnzeigenTabelle + "." + colAge + "," +
                        " " + deptTable + "." + colDeptName + "" +
                        " FROM " + AnzeigenTabelle + " JOIN " + deptTable +
                        " ON " + AnzeigenTabelle + "." + colDept + " =" + deptTable + "." + colDeptID
        );
*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
