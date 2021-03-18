package com.example.semana3_3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.R;
import com.example.semana3_3.adaptador.MascotaAdaptador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    RecyclerView rvMascota;
    ArrayList<Mascota> mascotas;
    MascotaAdaptador mascotaAdaptador;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_recycler_view, container, false);
        rvMascota = v.findViewById(R.id.rvMascota);

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Daisy", 5, "Perro", "Terry", "Margarita", R.drawable.dog1));
        mascotas.add(new Mascota("Sky", 2, "Perro", "Cruza", "Susana", R.drawable.dog2));
        mascotas.add(new Mascota("Georgi", 4, "Perro", "Korki", "Tania", R.drawable.dog3));
        mascotas.add(new Mascota("Hunter", 7, "Perro", "Cruza", "Valeria", R.drawable.dog4));
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5));

//        LinearLayoutManager llm = new LinearLayoutManager(getContext());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        rvMascota.setLayoutManager(llm);
        aspectoLineal();
        mascotaAdaptador = new MascotaAdaptador(mascotas, getContext());
        rvMascota.setAdapter(mascotaAdaptador);

        return v;
    }

    public void aspectoLineal(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascota.setLayoutManager(llm);
    }
    public void aspectoGrid(){
        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        rvMascota.setLayoutManager(glm);
    }
}