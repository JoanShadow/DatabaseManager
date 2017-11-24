package com.example.joan.databasemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FileUtils fileUtils = null;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        fileUtils = new FileUtils();
    }

    private void initLayout() {
        Button btnSaveInternalMemory = findViewById(R.id.saveIntern);
        btnSaveInternalMemory.setOnClickListener(this);

        Button btnSaveExternalMemory = findViewById(R.id.saveExtern);
        btnSaveExternalMemory.setOnClickListener(this);

        Button btnCreateDatabase = findViewById(R.id.createDatabase);
        btnCreateDatabase.setOnClickListener(this);

        Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);

        Button btnQueryDatabase = findViewById(R.id.queryDatabase);
        btnQueryDatabase.setOnClickListener(this);

        // EditText
        editText = findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveIntern:
                if (fileUtils != null) {
                    String text = editText.getText().toString();
                    fileUtils.saveInternalMemory(this, text);
                }
                break;
            case R.id.saveExtern:
                if (fileUtils != null) {
                    String text = editText.getText().toString();
                    fileUtils.saveExternalMemory(text);
                }
                break;
            case R.id.createDatabase:
                DatabaseManager databaseManager = new DatabaseManager();
                databaseManager.insertData(this,
                        "Ruben",
                        "Lopez",
                        "foto.jpg",
                        4,
                        0);
                break;
            case R.id.queryDatabase:
                //Cursor cursor = new DatabaseManager().getPassports(this);
                Cursor cursor = new DatabaseManager().getPassports(this);
                if(cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    for(int i = 0; i < cursor.getCount(); i++) {
                        Log.i(MainActivity.class.getSimpleName(), "-> Passport nº" + i + "\n" +
                                "- Nombre: " + cursor.getString(ConstantUtils.COLUMN_NAME_INDEX) + "\n" +
                                "- Apellidos: " + cursor.getString(ConstantUtils.COLUMN_APELLIDOS_INDEX) + "\n" +
                                "- Foto: " + cursor.getString(ConstantUtils.COLUMN_FOTO_INDEX) + "\n" +
                                "- SpinnerSelection: " + cursor.getInt(ConstantUtils.COLUMN_SPINNER_SELECTION_INDEX) + "\n" +
                                "- CheckBoxState: " + cursor.getInt(ConstantUtils.COLUMN_CHECKBOX_STATE_INDEX) + "\n\n");
                        cursor.moveToNext();
                    }
                    cursor.close();
                    // Cerrar base de datos
                }else {
                    Log.d(MainActivity.class.getSimpleName(), "-> NO PASSPORT DATA!!");
                }
                break;
            case R.id.btnOk:
                // TODO boton de enviar
                break;
        }
    }
}