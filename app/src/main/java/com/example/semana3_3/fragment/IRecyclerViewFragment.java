package com.example.semana3_3.fragment;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.adaptador.MascotaAdaptador;

import java.util.ArrayList;
// Para GENERAR UN MVP
public interface IRecyclerViewFragment {
    public  void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> Mascotas);
    public  void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
