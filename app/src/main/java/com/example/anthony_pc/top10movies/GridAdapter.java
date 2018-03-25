package com.example.anthony_pc.top10movies;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView title,metascore,stars;
        ImageView imgView,imgViewStar;
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if(row == null){
            row = layoutInflater.inflate(R.layout.grid_item,null);

            title =  row.findViewById(R.id.txtTitulo);
            title.setText(peliculaArray.get(i).getTitulo());
            metascore =  row.findViewById(R.id.txtMetascore);
            metascore.setText(peliculaArray.get(i).getMetascore());
            imgView =  row.findViewById(R.id.imgView);
            imgView.setImageDrawable(peliculaArray.get(i).getImage());
            imgViewStar = row.findViewById(R.id.imgViewStar);
            imgViewStar.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.star_big_on));
            stars = row.findViewById(R.id.txtScore);
            stars.setText(peliculaArray.get(i).getRate());


        }


        return row;
    }
}
