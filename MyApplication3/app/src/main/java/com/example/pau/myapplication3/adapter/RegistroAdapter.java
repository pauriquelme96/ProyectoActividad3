package com.example.pau.myapplication3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pau.myapplication3.R;
import com.example.pau.myapplication3.modelo.Producto;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Pau on 20/06/16.
 */
public class RegistroAdapter extends RecyclerView.Adapter<RegistroAdapter.MyViewHolder> {
    private ArrayList<Producto> productos;
    private Context context;

    public RegistroAdapter(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
        Collections.reverse(productos);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreTv;
        public TextView fechaTv;
        public ImageView imageIv;

        public MyViewHolder(View v) {
            super(v);

            nombreTv = (TextView) v.findViewById(R.id.tv_nombre_historico);
            fechaTv = (TextView) v.findViewById(R.id.tv_fecha_historico);
            imageIv = (ImageView) v.findViewById(R.id.iv_image_historico);
        }
    }


    @Override
    public RegistroAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.historico_card_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nombreTv.setText(productos.get(position).getNombre());
        holder.fechaTv.setText(productos.get(position).getFechaVisto());
        holder.imageIv.setImageBitmap(productos.get(position).getImagenBitMap());
    }

    @Override
    public int getItemCount() {
       return productos.size();
    }
}