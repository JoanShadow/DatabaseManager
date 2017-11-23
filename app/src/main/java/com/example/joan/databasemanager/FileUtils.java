package com.example.joan.databasemanager;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by A8Alumno on 23/11/2017.
 * Guardar datos en memoria interna
 * Guardar datos en memoria externa
 * Cargar datos de memoria interna/externa
 */

public class FileUtils {
    public boolean saveInternalMemory(Context context, String saveText) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(ConstantUtils.INTERNAL_MEMORY_FILE, Context.MODE_PRIVATE);
            fileOutputStream.write(saveText.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            if(BuildConfig.DEBUG)
            e.printStackTrace();
            return false;
            // Feedback usuario..
            // Código alternativo
        }
        return true;
    }

    public boolean saveExternalMemory(String saveText) {

        /*** CREACIÓN  DIRECTORIO Y ARCHIVO ***/
        // File = path memoria externa + mi directorio
        File myExternalFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),ConstantUtils.EXTERNAL_MEMORY_DIRECTORY);

        // Consultar si existe el directorio, si es false creamos el directorio
        if(!myExternalFolder.exists()) {
            myExternalFolder.mkdirs();
        }

        Log.i(FileUtils.class.getSimpleName(), "-> Path = " + myExternalFolder.getAbsolutePath());

        /*** GUARDAR EL ARCHIVO ***/
        try {
            File myFile = new File(myExternalFolder.getAbsoluteFile() + "/" + ConstantUtils.EXTERNAL_MEMORY_FILE);
            FileOutputStream fileOutputStream = new FileOutputStream(myFile.getAbsolutePath().toString());
            fileOutputStream.write(saveText.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
    }

    public String loadInternalMemory() {
        // TODO implementar loadInternalMemory
        return  null;
    }

    public String loadExternalMemory() {
        // TODO implementar loadExternalMemory
        return  null;
    }
}
