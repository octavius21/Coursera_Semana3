package com.example.semana3_3.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.R;

import java.util.ArrayList;

public class MascotaPequena extends RecyclerView.Adapter<MascotaPequena.MascotaPequenaViewHolder> {
    ArrayList<Mascota> mascotas;
    Context context;

    public MascotaPequena(ArrayList<Mascota> mascotas, Context context){
        this.mascotas=mascotas;
        this.context=context;
    }

    @NonNull
    @Override
    public MascotaPequenaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_pequena,parent,false);
        return new MascotaPequenaViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MascotaPequenaViewHolder mascotaPequenaViewHolder, int position) {
        Mascota mascota=mascotas.get(position);
        mascotaPequenaViewHolder.iperro.setImageResource(mascota.getFoto());
        mascotaPequenaViewHolder.tvRate.setText(String.valueOf(mascota.getRate()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaPequenaViewHolder extends RecyclerView.ViewHolder{

        private ImageView iperro;
        private TextView tvRate;


        public MascotaPequenaViewHolder(@NonNull View itemView) {
            super(itemView);
            iperro=itemView.findViewById(R.id.iperropequeno);
            tvRate=itemView.findViewById(R.id.tvRatepequeno);
        }

    }

}
