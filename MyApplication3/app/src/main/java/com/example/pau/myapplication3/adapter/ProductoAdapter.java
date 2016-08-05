package com.example.pau.myapplication3.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pau.myapplication3.R;
import com.example.pau.myapplication3.Utils;
import com.example.pau.myapplication3.activity.DetalleActivity;
import com.example.pau.myapplication3.modelo.Producto;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Pau on 04/08/2016.
 */
public class ProductoAdapter extends RecyclerView.Adapter<ProductoHolder> {
    private ArrayList<Producto> productos;
    private Context context;
    private int idProducto;
    //fichero de preferecias.xml - PREGUNTAR
    public final static String LISTA_PRODUCTOS = "historico";


    public ProductoAdapter(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @Override
    public ProductoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.productos_card_item,null);

        ProductoHolder holder=new ProductoHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProductoHolder holder, int position) {
        idProducto = Integer.parseInt(productos.get(position).getId());

        holder.nombre.setText(productos.get(position).getNombre());
        holder.precio.setText(productos.get(position).getPrecio() + "€");
        holder.imagen.setImageBitmap(productos.get(position).getImagenBitMap());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                String fechaHoraActual = (DateFormat.format("dd-MM-yyyy hh:mm:ss", new java.util.Date()).toString());

                SharedPreferences prefs = context.getSharedPreferences(LISTA_PRODUCTOS,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(fechaHoraActual, productos.get(pos).getNombre()+";"+productos.get(pos).getImagen());
                editor.commit();

                Map<String, ?> allEntries = prefs.getAll();

                for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                    Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
                }

                Intent intent = new Intent(context,DetalleActivity.class);

                intent.putExtra("Nombre",productos.get(pos).getNombre());
                intent.putExtra("Precio",productos.get(pos).getPrecio());
                intent.putExtra("Unidades",productos.get(pos).getUnidades());
                intent.putExtra("Descripcion",productos.get(pos).getDescripcion());

                Bitmap imagenGrande = productos.get(pos).getImagenBitMap();
                Bitmap imagenPequena = Utils.scaleDownBitmap(imagenGrande,200,context);
                intent.putExtra("Imagen", imagenPequena);

                /**
                 * No lanza la actividad DetalleActivity, Porque??
                 * Mismo problema que Estefania, Preguntar a Valeriano
                 */
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }
}