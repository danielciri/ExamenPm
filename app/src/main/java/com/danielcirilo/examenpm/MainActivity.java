package com.danielcirilo.examenpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IStarListener {
    private FragmentListado frgListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frgListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.frgListado);
        frgListado.setListener(this);
    }

    @Override
    public void onItemSeleccionado(int position) {
        Star star = frgListado.getStars().get(position);
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.frgDetalle) != null);
        if(hayDetalle) {
            FragmentDetalle frgDetalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
            frgDetalle.mostrarDetalle(star);
        }else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, star);
            startActivity(i);
        }



    }
}