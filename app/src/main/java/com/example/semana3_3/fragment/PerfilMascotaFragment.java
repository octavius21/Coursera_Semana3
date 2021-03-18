package com.example.semana3_3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.R;
import com.example.semana3_3.adaptador.MascotaAdaptador;
import com.example.semana3_3.adaptador.MascotaPequena;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {
    RecyclerView rvMascotaPequena;
    ArrayList<Mascota> mascotas;
    MascotaPequena mascotaAdaptador;
    public PerfilMascotaFragment() {
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
        View v=inflater.inflate(R.layout.fragment_perfil_mascota, container, false);
        rvMascotaPequena = v.findViewById(R.id.rvMascotaPequena);
        CircularImageView circularImageView = v.findViewById(R.id.circularImageView);
        TextView tvNombrePequeno=v.findViewById(R.id.tvNombrePequeno);
        tvNombrePequeno.setText("PORFIRIO".toString());
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5,58655));
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5,48));
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5,58));
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5,9652));
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5,21));
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5,7623));
        mascotas.add(new Mascota("Porfirio", 1, "Perro", "Salchica", "Grisel", R.drawable.dog5,585));

//        LinearLayoutManager llm = new LinearLayoutManager(getContext());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        rvMascota.setLayoutManager(llm);
        aspectoGrid();
        mascotaAdaptador = new MascotaPequena(mascotas, getContext());
        rvMascotaPequena.setAdapter(mascotaAdaptador);

        return v;
    }

    public void aspectoLineal(){
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotaPequena.setLayoutManager(llm);
    }
    public void aspectoGrid(){
        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        rvMascotaPequena.setLayoutManager(glm);
    }
}