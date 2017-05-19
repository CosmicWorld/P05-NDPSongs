package com.example.a15017381.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017381 on 19/5/2017.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> song;
    TextView tvYear, tvTitle, tvSingers;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5;

    public SongAdapter(Context context, int resource, ArrayList<Song> song) {
        super(context, resource, song);
        this.context = context;
        this.song = song;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables
        tvYear = (TextView) rowView.findViewById(R.id.textViewYear);
        tvTitle = (TextView) rowView.findViewById(R.id.textViewTitle);
        tvSingers = (TextView) rowView.findViewById(R.id.textViewSingers);
        iv1 = (ImageView) rowView.findViewById(R.id.imageViewStar1);
        iv2 = (ImageView) rowView.findViewById(R.id.imageViewStar2);
        iv3 = (ImageView) rowView.findViewById(R.id.imageViewStar3);
        iv4 = (ImageView) rowView.findViewById(R.id.imageViewStar4);
        iv5 = (ImageView) rowView.findViewById(R.id.imageViewStar5);

        Song current = song.get(position);
        tvYear.setText("" + current.getYear());
        tvTitle.setText(current.getTitle());
        tvSingers.setText(current.getSingers());
        int stars = current.getStars();

        if (stars <= 4) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
        }

        if (stars <= 3) {
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
        }

        if (stars <= 2) {
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
        }

        if (stars <= 1) {
            iv2.setImageResource(android.R.drawable.btn_star_big_off);
        }

        if (stars <= 0) {
            iv1.setImageResource(android.R.drawable.btn_star_big_off);
        }

        return rowView;
    }
}
