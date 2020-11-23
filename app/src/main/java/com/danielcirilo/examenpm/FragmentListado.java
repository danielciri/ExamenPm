package com.danielcirilo.examenpm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentListado extends Fragment {

    private IStarListener listener;
    private RecyclerView rvListado;
    private ArrayList<Star> stars;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Parser  parser = new Parser(getActivity());
        if (parser.parse()){
            stars = parser.getStars();
        }
        return inflater.inflate(R.layout.fragment_listado,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvListado = getView().findViewById(R.id.rvListado);
        rvListado.setAdapter(new Adaptador(listener, stars));

        rvListado.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
    }

    public void setListener(IStarListener listener) {
        this.listener = listener;
    }

    public ArrayList<Star> getStars() {
        return stars;
    }
}