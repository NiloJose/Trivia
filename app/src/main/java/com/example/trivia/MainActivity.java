package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.trivia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
FragmentoNombre fragmentoNombre;
FragmentoPregunta fragmentoPregunta;
FragmentoResultado fragmentoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentoNombre = new FragmentoNombre();
        fragmentoPregunta = new FragmentoPregunta();
        fragmentoResultado = new FragmentoResultado();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragmentoNombre).commit();}
    }
