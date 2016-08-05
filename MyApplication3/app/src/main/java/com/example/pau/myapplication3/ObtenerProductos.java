package com.example.pau.myapplication3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.pau.myapplication3.modelo.Producto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pau on 04/08/2016.
 */
public class ObtenerProductos extends AsyncTask<Void, Void, ArrayList<Producto>> {

    private Context context;
    protected ProgressDialog progressDialog;
    private ArrayList<String> str_productos = null;
    public static ArrayList<Producto> productos = new ArrayList<>();

    public ObtenerProductos(Context context){
        this.context = context;
    }

    /**
     * NO APARECE EL MALDITO PROGRESSDIALOG, PORQUEE??
     *
     * Preguntar a Vale
     */
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Estableciendo conexión", "conectando...",true,false);
    }

    @Override
    protected void onPostExecute(ArrayList<Producto> str_productos){
        progressDialog.dismiss();
    }

    protected ArrayList<Producto> doInBackground(Void... params){
        URL dir_obtener_productos = null;
        HttpURLConnection httpURLConnection = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            dir_obtener_productos = new URL(Constantes.URL_SERVICIO_PRODUCTOS);
            httpURLConnection = (HttpURLConnection) dir_obtener_productos.openConnection();
            httpURLConnection.setRequestMethod("GET");

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                is = httpURLConnection.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                String productos_json = "";

                String aux = br.readLine();

                while (null != aux){
                    productos_json += aux;
                    aux = br.readLine();
                }

                Gson gson = new Gson();

                productos = gson.fromJson (productos_json, new TypeToken<ArrayList<Producto>>(){}.getType());
            }

        }catch (EOFException e){

        }catch (Throwable t){
            t.printStackTrace();
        } finally {
            //Se cierra las conexiones
            httpURLConnection.disconnect();

            /**
             * ¿Es necesario cerrar también el br? O basta solo con el httpURLConnection
             *
             * Preguntar a Vale
             */
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return productos;
    }
}
