package com.example.pau.myapplication3.modelo;

import android.graphics.Bitmap;

/**
 * Created by Pau on 03/08/2016.
 */
public class Producto {

    private String id;
    private String nombre;
    private String precio;
    private String unidades;
    private String descripcion;
    private String fechaVisto;
    private String imagen;

    public Bitmap getImagenBitMap() {
        return imagenBitMap;
    }

    public void setImagenBitMap(Bitmap imagenBitMap) {
        this.imagenBitMap = imagenBitMap;
    }

    private Bitmap imagenBitMap;

    public Producto(String id, String nombre, String precio, String unidades, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", unidades='" + unidades + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaVisto='" + fechaVisto + '\'' +
                ", imagen='" + imagen + '\'' +
                ", imagenBitMap=" + imagenBitMap +
                '}';
    }
    public Producto(String nombre, String precio, String unidades, String descripcion, Bitmap imagenBitMap) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.imagenBitMap = imagenBitMap;
    }

    public Producto(String nombre, Bitmap imagenBitMap, String fechaVisto) {
        this.nombre = nombre;
        this.imagenBitMap = imagenBitMap;
        this.fechaVisto = fechaVisto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaVisto() {
        return fechaVisto;
    }

    public void setFechaVisto(String fechaVisto) {
        this.fechaVisto = fechaVisto;
    }

    public String getId() {
        return id;
    }



    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }



    public String getPrecio() {
        return precio;
    }



    public String getUnidades() {
        return unidades;
    }



    public String getDescripcion() {
        return descripcion;
    }

}