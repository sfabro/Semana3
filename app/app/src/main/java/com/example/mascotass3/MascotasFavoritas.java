package com.example.mascotass3;

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

        mascotas.add(new Mascota ("Chicho4","2", R.drawable.perro4));
        mascotas.add(new Mascota ("Chicho3","3", R.drawable.perro3));
        mascotas.add(new Mascota ("Chicho2","1", R.drawable.perro2));
        mascotas.add(new Mascota ("Chicho5","5", R.drawable.perro5));
        mascotas.add(new Mascota ("Chicho1","2", R.drawable.perro1));
    }
}
