package com.example.anthony_pc.top10movies;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Anthony-PC on 22/3/2018.
 */

public class GridAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Pelicula> peliculaArray;

    public GridAdapter(Context context, ArrayList<Pelicula> peliculaArray) {
        this.context = context;
        this.peliculaArray = peliculaArray;
    }

    @Override
    public int getCount() {
        return peliculaArray.size();
    }

    @Override
    public Object getItem(int i) {
        return peliculaArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        TextView title;
        TextView metascore;
        ImageView imgView;
        RatingBar ratingBar;
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                //((Activity) context).getLayoutInflater();

        if(row == null){
            //row = new View(context);


            row = layoutInflater.inflate(R.layout.grid_item,null);
            System.out.println(peliculaArray.get(i).getMetascore());

            title = (TextView) row.findViewById(R.id.txtTitulo);
            title.setText(peliculaArray.get(i).getTitulo());
            metascore = (TextView) row.findViewById(R.id.txtMetascore);
            metascore.setText(peliculaArray.get(i).getMetascore());
            imgView = (ImageView) row.findViewById(R.id.imgView);
            imgView.setImageDrawable(peliculaArray.get(i).getImage());
            ratingBar = (RatingBar) row.findViewById(R.id.ratingBar);
            ratingBar.setRating(peliculaArray.get(i).getRate());

        }
//        System.out.println(peliculaArray.get(i).getTitulo());
//        System.out.println(peliculaArray.get(i).getMetascore());
//        System.out.println(peliculaArray.get(i).getRate());
//        System.out.println(peliculaArray.get(i).getId());


//        title.setText("sadfasdf");
//        System.out.println("JEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//        TextView metascore = (TextView) view.findViewById(R.id.txtMetascore);
//        metascore.setText(peliculaArray.get(i).getMetascore());
//        ImageView imgView = (ImageView) view.findViewById(R.id.imgView);
//        //imgView.setImageDrawable(peliculaArray.get(i).getImage());
//        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);
//        ratingBar.setRating(peliculaArray.get(i).getRate());


        return row;
    }
}
