package com.example.semana3_3.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.semana3_3.Objetos.Mascota;

import java.util.ArrayList;

import static com.example.semana3_3.db.ConstantesBaseDatos.DATABASE_NAME;
import static com.example.semana3_3.db.ConstantesBaseDatos.DATABASE_VERSION;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_LIKES;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_LIKES_ID_FK;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_LIKES_ID_PK;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_LIKES_RATE;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_MASCOTA;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_MASCOTA_DUEÑO;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_MASCOTA_EDAD;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_MASCOTA_ESPECIE;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_MASCOTA_FOTO;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_MASCOTA_ID_PK;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE;
import static com.example.semana3_3.db.ConstantesBaseDatos.TABLE_MASCOTA_RAZA;


public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota="CREATE TABLE IF NOT EXISTS "+TABLE_MASCOTA+"("+
                TABLE_MASCOTA_ID_PK +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TABLE_MASCOTA_NOMBRE + " TEXT, "+
                TABLE_MASCOTA_EDAD + " INTEGER, "+
                TABLE_MASCOTA_ESPECIE + " TEXT, "+
                TABLE_MASCOTA_RAZA + " TEXT, "+
                TABLE_MASCOTA_DUEÑO + " TEXT,"+
                TABLE_MASCOTA_FOTO + " INTEGER "+
                ");";
        db.execSQL(queryCrearTablaMascota);
        String queryCrearTablaLikes="CREATE TABLE IF NOT EXISTS "+TABLE_LIKES+"("+
                TABLE_LIKES_ID_PK +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TABLE_LIKES_ID_FK +" INTEGER, "+
                TABLE_LIKES_RATE + " INTEGER, "+
                "FOREIGN KEY("+TABLE_LIKES_ID_FK+") "+"REFERENCES "+TABLE_MASCOTA+ " ("+TABLE_MASCOTA_ID_PK+")"+
                ");";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LIKES);
        onCreate(db);
    }
    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas=new ArrayList<>();
        String query="SELECT * FROM "+TABLE_MASCOTA;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros =db.rawQuery(query, null);
        while(registros.moveToNext()){
            Mascota mascotaactual=new Mascota();
            mascotaactual.setId(registros.getInt(0));
            mascotaactual.setNombre(registros.getString(1));
            mascotaactual.setEdad(registros.getInt(2));
            mascotaactual.setEspecie(registros.getString(3));
            mascotaactual.setRaza(registros.getString(4));
            mascotaactual.setNombre(registros.getString(5));
            mascotaactual.setFoto(registros.getInt(6));
            String queryLikes="SELECT COUNT("+TABLE_LIKES_RATE+") as likes "+
                    "FROM "+TABLE_LIKES+
                    " WHERE "+TABLE_LIKES_ID_FK+"="+mascotaactual.getId();
            Cursor registrosLikes=db.rawQuery(queryLikes,null);
            if(registrosLikes.moveToNext()){
                mascotaactual.setRate(registrosLikes.getInt(0));
            }else{
                mascotaactual.setRate(0);
            }
            mascotas.add(mascotaactual);
        }
        db.close();
        return mascotas;
    }
    public  void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(TABLE_MASCOTA,null,contentValues);
        db.close();
    }
    public void insertarLikeMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_LIKES,null,contentValues);
        db.close();
    }
    public int obtenerLikesMascota(Mascota mascota){
        int likes=0;
        String query="SELECT COUNT("+TABLE_LIKES_RATE+") FROM "+TABLE_LIKES
                +" WHERE "+ TABLE_LIKES_ID_FK+"="+mascota.getId();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registro=db.rawQuery(query,null);
        while(registro.moveToNext()){
            likes=registro.getInt(0);
        }
        db.close();
        return likes;
    }
    public ArrayList<Mascota> obtenerUltimosLikes(){
        ArrayList<Mascota> mascotas=new ArrayList<>();
        String query="SELECT "+"L."+TABLE_LIKES_ID_FK +", M."+TABLE_MASCOTA_NOMBRE+", M."+TABLE_MASCOTA_FOTO+
                " FROM "+TABLE_LIKES+" L,"+TABLE_MASCOTA+" M WHERE M."
                +TABLE_MASCOTA_ID_PK+"= L."+TABLE_LIKES_ID_FK+
                " ORDER BY L."+TABLE_MASCOTA_ID_PK+" DESC LIMIT 5";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros =db.rawQuery(query, null);
        while(registros.moveToNext()) {
            Mascota mascotaactual=new Mascota();
            mascotaactual.setId(registros.getInt(0));
            mascotaactual.setNombre(registros.getString(1));
            mascotaactual.setFoto(registros.getInt(2));

            String queryLikes="SELECT COUNT("+TABLE_LIKES_RATE+") as likes "+
                    "FROM "+TABLE_LIKES+
                    " WHERE "+TABLE_LIKES_ID_FK+"="+mascotaactual.getId();
            Cursor registrosLikes=db.rawQuery(queryLikes,null);
            if(registrosLikes.moveToNext()){
                mascotaactual.setRate(registrosLikes.getInt(0));
            }else{
                mascotaactual.setRate(0);
            }
            mascotas.add(mascotaactual);
        }
        db.close();
        return mascotas;
    }
}
