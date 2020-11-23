package com.danielcirilo.examenpm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class FragmentDetalle extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle,container,false);
    }
    public void mostrarDetalle(Star star){
        TextView tvDetalleid = getView().findViewById(R.id.tvDetalleid);
        tvDetalleid.setText(star.getId());
        TextView tvDetallebf = getView().findViewById(R.id.tvDetalleBf);
        tvDetallebf.setText(star.getBf());
        TextView tvDetalleHip = getView().findViewById(R.id.tvDetalleHip);
        tvDetalleHip.setText(star.getHip());
        TextView tvDetalleDistancia = getView().findViewById(R.id.tvDetalleDistancia);
        tvDetalleDistancia.setText(String.valueOf(star.getDist()));
        TextView tvDetalleMagnitu = getView().findViewById(R.id.tvDetalleMagnitu);
        tvDetalleMagnitu.setText(String.valueOf(star.getMag()));
        TextView tvTipoSpectral = getView().findViewById(R.id.tvDetalleTipoEspectral);
        tvTipoSpectral.setText(star.getSpect());
        TextView tvRa = getView().findViewById(R.id.tvDetalleRa);
        tvRa.setText(String.valueOf(star.getRa()));
        TextView tvdec = getView().findViewById(R.id.tvDetalleDec);
        tvdec.setText(String.valueOf(star.getDec()));




    }
}
