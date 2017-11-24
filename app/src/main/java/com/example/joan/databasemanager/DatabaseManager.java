package com.example.joan.databasemanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by A8Alumno on 24/11/2017.
 */

public class DatabaseManager {

    public void insertData(Context context, String nombre, String apellidos, String foto, int spinnerSelection, int checkBoxState) {
        // Insert data in DB
        MyDatabase myDatabase = new MyDatabase(context);
        SQLiteDatabase sqLiteDatabase = myDatabase.getWritableDatabase();
        String query = ConstantUtils.MY_DATABASE_INSERT_DATA;
        Log.i(DatabaseManager.class.getSimpleName(), "-> query = " + query);
        query = query.replace("%1", nombre);
        query = query.replace("%2", apellidos);
        query = query.replace("%3", foto);
        query = query.replace("%4", String.valueOf(spinnerSelection));
        query = query.replace("%5", String.valueOf(checkBoxState));
        sqLiteDatabase.execSQL(query);
    }

    public Cursor getPassports(Context context) {
        MyDatabase myDatabase = new MyDatabase(context);
        SQLiteDatabase sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ConstantUtils.PASSPORT_TABLE_NAME, null);
        return cursor;// Cursor
    }

    /*public Cursor getPassportsByName(Context context, String name) {
        MyDatabase myDatabase = new MyDatabase(context);
        SQLiteDatabase sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ConstantUtils.PASSPORT_TABLE_NAME + "WHERE " +
                ConstantUtils.COLUMN_NAME + " = '" + name + "'", null);// Cursor
        //sqLiteDatabase.close();
        return cursor;
    }*/
}
