package com.example.joan.databasemanager;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                MyDatabase myDatabase = new MyDatabase(this);
                SQLiteDatabase sqLiteDatabase = myDatabase.getReadableDatabase();
                break;
            case R.id.btnOk:
                // TODO boton de enviar
                break;
        }
    }
}