package com.example.pau.myapplication3.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pau.myapplication3.R;

/**
 * Created by Pau on 03/08/2016.
 */

public class DetalleActivity extends Activity {
    /**
     * DetalleActivity no se llega a ejecutar, pero el intent que la llama si, CUAL ES EL PROBLEMA??
     *
     * Preguntar a Vale
     *
     */
    private TextView nombreTv, precioTv, unidadesTv, descripcionTv;
    private ImageView imagenIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Intent i=getIntent();

        final String nombre = i.getExtras().getString("Nombre");
        final String precio = i.getExtras().getString("Precio");
        final String unidades = i.getExtras().getString("Unidades");
        final String descripcion = i.getExtras().getString("Descripcion");
        final Bitmap imagen = i.getExtras().getParcelable("Imagen");

        nombreTv = (TextView) findViewById(R.id.nombreTxt);
        precioTv = (TextView) findViewById(R.id.precioTxt);
        unidadesTv = (TextView) findViewById(R.id.unidadesTxt);
        descripcionTv = (TextView) findViewById(R.id.descripcionTxt);
        imagenIv = (ImageView) findViewById(R.id.imagedetalle);

        nombreTv.setText("Producto :   " + nombre);
        precioTv.setText("Precio : " + precio + "€");
        unidadesTv.setText("Unidades : " + unidades);
        descripcionTv.setText("Descripcion : " + descripcion);
        imagenIv.setImageBitmap(imagen);
    }
}
