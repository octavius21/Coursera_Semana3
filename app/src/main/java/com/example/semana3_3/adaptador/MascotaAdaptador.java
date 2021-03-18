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

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota>mascotas;
    Context context;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Context context){
        this.mascotas=mascotas;
        this.context=context;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota=mascotas.get(position);
        mascotaViewHolder.iperro.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.ibBone.setEnabled(true);
        mascotaViewHolder.tvRate.setText(String.valueOf(mascota.getRate()));
        mascotaViewHolder.ibBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setRate(mascota.getRate()+1);
                Toast.makeText(context, "¡Le diste Like!", Toast.LENGTH_SHORT).show();
                mascotaViewHolder.ibBone.setEnabled(false);
                mascotaViewHolder.tvRate.setText(String.valueOf(mascota.getRate()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView iperro;
        private TextView tvNombre;
        private TextView tvRate;
        private ImageButton ibBone;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            iperro=itemView.findViewById(R.id.iperro);
            tvNombre=itemView.findViewById(R.id.tvName);
            tvRate=itemView.findViewById(R.id.tvRate);
            ibBone=itemView.findViewById(R.id.ibBone);

        }

    }

}
