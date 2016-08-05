package com.example.pau.myapplication3.fragment;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pau.myapplication3.DescargarImagenes;
import com.example.pau.myapplication3.ObtenerProductos;
import com.example.pau.myapplication3.R;
import com.example.pau.myapplication3.adapter.ProductoAdapter;
import com.example.pau.myapplication3.utils.Internet;
import com.example.pau.myapplication3.modelo.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by Pau on 03/08/2016.
 */
public class ProductoFragment extends Fragment {
    public static RecyclerView recyclerView;
    public static ArrayList<Producto> productos;

    public ProductoFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Context context = getActivity();

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_productos,
                container,
                false
        );
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);

        if(Internet.isNetworkAvailable(getActivity())){
            try {
                productos = new ObtenerProductos(context).execute().get();
                for (int i = 0; i < productos.size(); i++){
                    String url = productos.get(i).getImagen();
                    productos.get(i).setImagenBitMap(new DescargarImagenes(url).execute().get());
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            } catch (ExecutionException e){
                e.printStackTrace();
            }
        }

        ProductoAdapter adapter = new ProductoAdapter(context, productos);
        LinearLayoutManager llm = new LinearLayoutManager(context);

        ProductoFragment.recyclerView.setAdapter(adapter);
        ProductoFragment.recyclerView.setLayoutManager(llm);
        ProductoFragment.recyclerView.setHasFixedSize(true);

        return rootView;
    }
}
