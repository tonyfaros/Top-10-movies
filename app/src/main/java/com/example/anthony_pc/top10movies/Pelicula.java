package com.example.anthony_pc.top10movies;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by Anthony-PC on 22/3/2018.
 */

public class Pelicula {
    private int id;
    private String titulo;
    private String metascore;
    private String rate;
    private Drawable image;

    public Pelicula(int id, String titulo, String metascore,String rate, Drawable image) {
        this.id = id;
        this.titulo = titulo;
        this.metascore = metascore;
        this.rate = rate;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
