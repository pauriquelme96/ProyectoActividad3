package com.example.pau.myapplication3.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pau.myapplication3.R;

/**
 * Created by Pau on 04/08/2016.
 */
public class ProductoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nombre;
    TextView precio;
    ImageView imagen;
    private ItemClickListener itemClickListener;

    public ProductoHolder(View itemView){
        super(itemView);

        nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
        precio = (TextView) itemView.findViewById(R.id.tv_precio);
        imagen = (ImageView) itemView.findViewById(R.id.iv_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener=ic;

    }
}
