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

        private Exception exception;

        protected Void doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                Document doc = Jsoup.connect("http://www.imdb.com/list/ls064079588/").get();

                Elements imagenes = doc.select("div.lister-item.mode-detail div.lister-item-image.ribbonize a img");

                String link = imagenes.attr("loadlate");
                //Log.i("titulo", doc.title());
                Elements titulos = doc.select("div.lister-item-content h3.lister-item-header a");
                Elements estrellas = doc.select("div.lister-item-content div.ratings-bar div.inline-block.ratings-imdb-rating strong");
                //Log.i("estrellas", estrellas.html());
                Elements metascores = doc.select("div.lister-item-content div.ratings-bar div.inline-block.ratings-metascore span.metascore");
                //Log.i("metascores", metascores.html());
                //Log.i("imagenes", imagenes.html().toString());
                //Log.i("titulos", titulos.html());

                for(int i=0;i<20;i++)
                {
                    InputStream is = (InputStream) new URL(imagenes.get(i).attr("loadlate")).getContent();

                    Drawable d = Drawable.createFromStream(is, "");

                    Pelicula pelicula = new Pelicula(i,titulos.get(i).html(),metascores.get(i).html(),
                            Float.valueOf(estrellas.get(i).html()),d);

                    //System.out.println(imagenes.get(i).attr("loadlate"));
                    //System.out.println(metascores.get(i).html());
//                    System.out.println(titulos.get(i).html());
//                    System.out.println(estrellas.get(i).html());
                    arrayPelicula.add(pelicula);

                }

                System.out.println(arrayPelicula.size());

            } catch (Exception e) {
                this.exception = e;

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
