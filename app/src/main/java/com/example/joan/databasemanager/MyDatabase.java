package com.example.joan.databasemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A8Alumno on 23/11/2017.
 */

public class MyDatabase extends SQLiteOpenHelper {

    public MyDatabase(Context context) {
        super(context, ConstantUtils.MY_DATABASE_NAME, null, ConstantUtils.MY_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstantUtils.MY_DATABASE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
