package com.example.semana3_3.presentador;

import android.content.Context;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.adaptador.MascotaAdaptador;
import com.example.semana3_3.db.ConstructorMascota;
import com.example.semana3_3.fragment.IRecyclerViewFragment;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment=iRecyclerViewFragment;
        this.context=context;
        obtenerMascotasDB();
    }


    @Override
    public void obtenerMascotasDB() {
        //EXTRAER LOS DATOS DE UNA FUENTE
        constructorMascota=new ConstructorMascota(context);
        this.mascotas=constructorMascota.obtenerDatos();
        mostrarMascotaDB();
    }

    @Override
    public void mostrarMascotaDB() {
        //DAR LOS DATOS A LA VISTA
    iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
    iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}
