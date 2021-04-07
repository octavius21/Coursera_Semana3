package com.example.semana3_3.db;

import android.content.ContentValues;
import android.content.Context;
import android.view.contentcapture.ContentCaptureCondition;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.R;


import java.util.ArrayList;
//ESPARA TENER LOS DATOS DE LAS FORMAS
public class ConstructorMascota {
        private Context context;
    ArrayList<Mascota> mascotas;
    private static final Integer like=1;

    public ConstructorMascota(Context context){
            this.context=context;
        }

        public ArrayList<Mascota> obtenerDatos(){
//            mascotas = new ArrayList<Mascota>();
//            mascotas.add(new Mascota("Daisy", 5, "Perro", "Terry", "Margarita", R.drawable.dog1));
//            mascotas.add(new Mascota("Sky", 2, "Perro", "Cruza", "Susana", R.drawable.dog2));
//            mascotas.add(new Mascota("Georgi", 4, "Perro", "Korki", "Tania", R.drawable.dog3));
//            mascotas.add(new Mascota("Hunter", 7, "Perro", "Cruza", "Valeria", R.drawable.dog4));
//            mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5));
//            return mascotas;
            BaseDatos db= new BaseDatos(context);
            insertarMascota(db);
            return db.obtenerTodasLasMascotas();
        }
        public  void insertarMascota(BaseDatos db){
            ContentValues contentValues=new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Daisy");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,5);
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ESPECIE,"Perro");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Terry");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_DUEÑO,"Margarita");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog1);
            db.insertarMascota(contentValues);
            contentValues=new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Sky");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,2);
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ESPECIE,"Perro");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Cruza");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_DUEÑO,"Susana");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog2);
            db.insertarMascota(contentValues);
            contentValues=new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Georgi");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,4);
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ESPECIE,"Perro");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Korki");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_DUEÑO,"Tania");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog3);
            db.insertarMascota(contentValues);
            contentValues=new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Hunter");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,6);
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ESPECIE,"Perro");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Cruza");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_DUEÑO,"Valeria");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog4);
            db.insertarMascota(contentValues);
            contentValues=new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Porfirio");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD,2);
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ESPECIE,"Perro");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA,"Salchica");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_DUEÑO,"Grisel");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.dog5);
            db.insertarMascota(contentValues);


        }

        public void darLikeMascota(Mascota mascota){
            BaseDatos db=new BaseDatos(context);
            ContentValues contentValues=new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_FK,mascota.getId());
            contentValues.put(ConstantesBaseDatos.TABLE_LIKES_RATE,like);
            db.insertarLikeMascota(contentValues);
        }
        public int obtenerLikesMascota(Mascota mascota){
            BaseDatos db=new BaseDatos(context);
            return db.obtenerLikesMascota(mascota);

        }
        public ArrayList<Mascota> obtenerUltimosRegistros(){
        BaseDatos db=new BaseDatos(context);
        return db.obtenerUltimosLikes();
        }
}
