package com.example.joan.databasemanager;

/**
 * Created by A8Alumno on 23/11/2017.
 */

public class ConstantUtils {
    public static final String INTERNAL_MEMORY_FILE = "internalMemoryFile.txt";
    public static final String EXTERNAL_MEMORY_FILE = "externalMemoryFile.txt";
    public static final String EXTERNAL_MEMORY_DIRECTORY = "myDirectory/subDirectory";

    public static final String MY_DATABASE_NAME = "MyDatabase";
    public static final int MY_DATABASE_VERSION = 1;

    // Constantes tabla PASSPORT
    public static final String ID = "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,";
    public static final String PASSPORT_TABLE_NAME = "Passport";
    public static final String COLUMN_NAME = "Nombre";
    public static final String COLUMN_APELLIDOS = "Apellidos";
    public static final String COLUMN_FOTO = "Foto";
    public static final String COLUMN_SPINNER_SELECTION = "SpinnerSelection";
    public static final String COLUMN_CHECKBOX_STATE = "CheckBoxState";

    // Constantes tabla PASSPORT
    public static final int ID_INDEX = 0;
    public static final int COLUMN_NAME_INDEX = 1;
    public static final int COLUMN_APELLIDOS_INDEX = 2;
    public static final int COLUMN_FOTO_INDEX = 3;
    public static final int COLUMN_SPINNER_SELECTION_INDEX = 4;
    public static final int COLUMN_CHECKBOX_STATE_INDEX = 5;

    public static final String MY_DATABASE_CREATE_TABLE =
            "CREATE TABLE " + PASSPORT_TABLE_NAME +
                    "(" + ID  +
                    COLUMN_NAME + "TEXT," +
                    COLUMN_APELLIDOS + "TEXT," +
                    COLUMN_FOTO + "TEXT," +
                    COLUMN_SPINNER_SELECTION + "INTEGER," +
                    COLUMN_CHECKBOX_STATE + "INTEGER);"; // No existe boolean en SQLite

    public static final String MY_DATABASE_INSERT_DATA = "INSERT INTO " + PASSPORT_TABLE_NAME +
            "(" + COLUMN_NAME + "," +
            COLUMN_APELLIDOS + "," +
            COLUMN_FOTO + "," +
            COLUMN_SPINNER_SELECTION + "," +
            COLUMN_CHECKBOX_STATE + ") " +
            "VALUES ('%1', '%2', '%3', %4, %5)";
}
