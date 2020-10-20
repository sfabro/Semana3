package com.example.mascotass3;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton ibMascotasFavoritas;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)  findViewById(R.id.actionBarMascota);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        ibMascotasFavoritas = (ImageButton) findViewById(R.id.ibMascotasFavoritas);
        ibMascotasFavoritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mascotasFav = new Intent(getApplicationContext(),MascotasFavoritas.class);
                startActivityForResult(mascotasFav,0);
            }
        });

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota ("Chicho1","1", R.drawable.perro1));
        mascotas.add(new Mascota ("Chicho2","2", R.drawable.perro2));
        mascotas.add(new Mascota ("Chicho3","3", R.drawable.perro3));
        mascotas.add(new Mascota ("Chicho4","4", R.drawable.perro4));
        mascotas.add(new Mascota ("Chicho5","5", R.drawable.perro5));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}