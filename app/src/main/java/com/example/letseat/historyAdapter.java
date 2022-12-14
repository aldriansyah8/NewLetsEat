package com.example.letseat;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class historyAdapter extends FirebaseRecyclerAdapter<History,historyAdapter.historyViewholder> {

    //private String name;

    public historyAdapter(
            @NonNull FirebaseRecyclerOptions<History> options)
    {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull historyViewholder holder,
                     int position, @NonNull History model)
    {
        String tanggal = model.getTanggal();
        String asam = model.getAsamurat();
        String koles = model.getKolestrol();
        String gula = model.getGuladarah();


        holder.tanggaltv.setText(tanggal);
        holder.asamtv.setText(asam);
        holder.kolestv.setText(koles);
        holder.gulatv.setText(gula);


    }

    // Function to tell the class about the Card view (here
    // "History.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public historyViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new historyAdapter.historyViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "History.xml")
    class historyViewholder
            extends RecyclerView.ViewHolder {
        TextView tanggaltv, asamtv,kolestv,gulatv;
        public historyViewholder(@NonNull View itemView)
        {
            super(itemView);

            tanggaltv = itemView.findViewById(R.id.his_tanggal_tv);
            asamtv = itemView.findViewById(R.id.his_asam_tv);
            kolestv = itemView.findViewById(R.id.his_kol_tv);
            gulatv = itemView.findViewById(R.id.his_gd_tv);
        }
    }


}