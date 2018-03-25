package com.example.anthony_pc.top10movies;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pelicula> arrayPelicula = new ArrayList<>();
    private GridView gridView;
    private GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);

        new readHTML().execute("http://www.imdb.com/list/ls064079588/");


    }


    class readHTML extends AsyncTask<String, Void, Void> {

        protected Void doInBackground(String... urls) {
            try {
                Document doc = Jsoup.connect("http://www.imdb.com/list/ls064079588/").get();
                Elements imagenes = doc.select("div.lister-item.mode-detail div.lister-item-image.ribbonize a img");


                Elements titulos = doc.select("div.lister-item-content h3.lister-item-header a");
                Elements estrellas = doc.select("div.lister-item-content div.ratings-bar div.inline-block.ratings-imdb-rating strong");

                Elements metascores = doc.select("div.lister-item-content div.ratings-bar div.inline-block.ratings-metascore span.metascore");


                for(int i=0;i<20;i++)
                {
                    InputStream is = (InputStream) new URL(imagenes.get(i).attr("loadlate")).getContent();

                    Drawable d = Drawable.createFromStream(is, "");

                    Pelicula pelicula = new Pelicula(i,titulos.get(i).html(),metascores.get(i).html(),
                            estrellas.get(i).html(),d);
                    arrayPelicula.add(pelicula);

                }



            } catch (Exception e) {
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            gridAdapter = new GridAdapter(getApplicationContext(),arrayPelicula);

            gridView.setAdapter(gridAdapter);


        }
    }
}
