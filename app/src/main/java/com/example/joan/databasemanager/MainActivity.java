package com.example.joan.databasemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FileUtils fileUtils = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveIntern:
                // TODO guardar en memoria interna
                break;
            case R.id.saveExtern:
                // TODO guardar en memoria externa
                break;
            case R.id.createDatabase:
                // TODO crear base de datos
                break;
            case R.id.btnOk:
                // TODO boton de enviar
                break;
        }
    }
}
