package com.example.semana3_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.adaptador.MascotaAdaptador;
import com.example.semana3_3.db.ConstantesBaseDatos;
import com.example.semana3_3.db.ConstructorMascota;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar actionbar;
    Mascota mascota;
    ArrayList<Mascota> mascotas_fab,mascotas;
    RecyclerView rvMascota_fab;
    MascotaAdaptador mascotaAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        actionbar=findViewById(R.id.miActionBar);
        setSupportActionBar(actionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvMascota_fab = findViewById(R.id.rvMascota_fab);
//        try{
        ConstructorMascota constructorMascota=new ConstructorMascota(this);
        mascotas_fab=constructorMascota.obtenerUltimosRegistros();
            Toast.makeText(this, "DATOS"+mascotas_fab.get(0).getNombre(), Toast.LENGTH_SHORT).show();

            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rvMascota_fab.setLayoutManager(llm);
            mascotaAdaptador = new MascotaAdaptador(mascotas_fab, this);
            rvMascota_fab.setAdapter(mascotaAdaptador);
//        }catch (Exception e){
//            Toast.makeText(this, "No hay favoritos"+e.getCause()+e, Toast.LENGTH_LONG).show();
//        }
    }
}