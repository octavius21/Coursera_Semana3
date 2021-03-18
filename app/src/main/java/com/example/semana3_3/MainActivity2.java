package com.example.semana3_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.adaptador.MascotaAdaptador;

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
//        rvMascota_fab = findViewById(R.id.rvMascota_fab);
        try{
        mascotas= (ArrayList<Mascota>) getIntent().getSerializableExtra("arreglo");
        mascotas_fab=new ArrayList<Mascota>();

        for(int i=0;i<mascotas.size();i++) {
            if (mascotas.get(i).getRate()==1){
                mascotas_fab.add(new Mascota(mascotas.get(i).getNombre(),
                        mascotas.get(i).getEdad(),
                        mascotas.get(i).getEspecie(),
                        mascotas.get(i).getRaza(),
                        mascotas.get(i).getDueño(),
                        mascotas.get(i).getFoto(),
                        mascotas.get(i).getRate()));
            }else{

            }
        }
            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rvMascota_fab.setLayoutManager(llm);
            mascotaAdaptador = new MascotaAdaptador(mascotas_fab, this);
            rvMascota_fab.setAdapter(mascotaAdaptador);
        }catch (Exception e){
            Toast.makeText(this, "No hay favoritos", Toast.LENGTH_SHORT).show();
        }
    }
}