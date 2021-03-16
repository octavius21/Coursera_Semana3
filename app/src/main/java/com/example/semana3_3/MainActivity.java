package com.example.semana3_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.semana3_3.Objetos.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    RecyclerView rvMascota;
    MascotaAdaptador mascotaAdaptador;
    androidx.appcompat.widget.Toolbar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionbar = findViewById(R.id.miActionBar);
        setSupportActionBar(actionbar);
        rvMascota = findViewById(R.id.rvMascota);
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Daisy", 5, "Perro", "Terry", "Margarita", R.drawable.dog1));
        mascotas.add(new Mascota("Sky", 2, "Perro", "Cruza", "Susana", R.drawable.dog2));
        mascotas.add(new Mascota("Georgi", 4, "Perro", "Korki", "Tania", R.drawable.dog3));
        mascotas.add(new Mascota("Hunter", 7, "Perro", "Cruza", "Valeria", R.drawable.dog4));
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascota.setLayoutManager(llm);
        mascotaAdaptador = new MascotaAdaptador(mascotas, this);
        rvMascota.setAdapter(mascotaAdaptador);
    }

    private void setSupportActionBar(Toolbar actionbar) {
    }

    //Para que se ponga en mi action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorit:
//                Bundle bundle=new Bundle();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("arreglo",mascotas);
                startActivity(intent);
                return true;
            case R.id.opciones:
               return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}