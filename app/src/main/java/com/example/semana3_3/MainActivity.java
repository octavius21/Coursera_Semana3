package com.example.semana3_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.semana3_3.Objetos.Mascota;
import com.example.semana3_3.adaptador.MascotaAdaptador;
import com.example.semana3_3.adaptador.PageAdapter;
import com.example.semana3_3.fragment.PerfilMascotaFragment;
import com.example.semana3_3.fragment.RecyclerViewFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    ArrayList<Fragment>fragments;
    androidx.appcompat.widget.Toolbar actionbar;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fabCamara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        actionbar = findViewById(R.id.miActionBar);
//        setSupportActionBar(actionbar);
        fabCamara=findViewById(R.id.fabCamara);
        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewPager);
        setUpViewPager();
        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        fabCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    private ArrayList<Fragment> AgregarFragments(){
         fragments=new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilMascotaFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),AgregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
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
                Intent intent_user = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent_user);
               return true;
            case R.id.acercade:

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}