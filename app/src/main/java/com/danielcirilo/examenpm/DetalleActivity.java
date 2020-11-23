package com.danielcirilo.examenpm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "com.danielcirilo.EXTRA_TEXTO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        FragmentDetalle detalle = (FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        detalle.mostrarDetalle((Star) getIntent().getSerializableExtra(EXTRA_TEXTO));
    }
}