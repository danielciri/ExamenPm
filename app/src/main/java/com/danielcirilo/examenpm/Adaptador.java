package com.danielcirilo.examenpm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.StarViewHolder>{

    private IStarListener listener;
    private ArrayList<Star> stars;

    public Adaptador(IStarListener listener, ArrayList<Star> stars) {
        this.listener = listener;
        this.stars = stars;
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_star,parent,false);
        return new StarViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star star = stars.get(position);
        holder.bindStar(star);
    }

    @Override
    public int getItemCount() {
        return stars.size();
    }


    public static class StarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvId;
        private TextView tvProper;
        private TextView tvDist;
        private TextView tvMag;
        private TextView tvSpect;
        private IStarListener listener;
        public StarViewHolder(@NonNull View itemView, IStarListener listener) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvid);
            tvProper = itemView.findViewById(R.id.tvProper);
            tvDist = itemView.findViewById(R.id.tvDist);
            tvMag = itemView.findViewById(R.id.tvMag);
            tvSpect = itemView.findViewById(R.id.tvSpect);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindStar(Star star){
            tvId.setText(String.valueOf(star.getId()));
            tvProper.setText(star.getProper());
            tvDist.setText(String.valueOf(star.getDist()));
            tvMag.setText(String.valueOf(star.getMag()));
            tvSpect.setText(star.getSpect());
        }


        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.onItemSeleccionado(getAdapterPosition());
            }
        }
    }
}