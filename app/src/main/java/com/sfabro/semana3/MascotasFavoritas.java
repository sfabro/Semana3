package com.sfabro.semana3;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    ImageButton ibVolverActionBar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);


        Toolbar miActionBar = (Toolbar)  findViewById(R.id.actionBarMascota);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        ibVolverActionBar = (ImageButton) findViewById(R.id.ibVolverActionBar);
        ibVolverActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(home,0);
            }
        });



    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota ("Dog4","2", R.drawable.pet4));
        mascotas.add(new Mascota ("Dog3","3", R.drawable.pet3));
        mascotas.add(new Mascota ("Dog2","1", R.drawable.pet2));
        mascotas.add(new Mascota ("Dog5","5", R.drawable.pet5));
        mascotas.add(new Mascota ("Dog1","2", R.drawable.pet1));
    }
}
