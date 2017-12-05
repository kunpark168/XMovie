package app.group20.gtnm.xmovie.main.inTheater;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import app.group20.gtnm.xmovie.R;
import app.group20.gtnm.xmovie.main.detailMovie.DetailPopularActivity;
import app.group20.gtnm.xmovie.main.detailMovie.DetailTheaterActivity;


public class InTheaterFragment extends android.app.Fragment implements View.OnClickListener {

    private ImageView imgPosteri1, imgPosteri2, imgPosteri3, imgPosteri4, imgPosteri5, imgPosteri6, imgPosteri7, imgPosteri8, imgPosteri9;
    public InTheaterFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_in_theater, container, false);
        imgPosteri1 = (ImageView) view.findViewById(R.id.imgPosterp1);
        imgPosteri2 = (ImageView) view.findViewById(R.id.imgPosterp2);
        imgPosteri3 = (ImageView) view.findViewById(R.id.imgPosterp3);
        imgPosteri4 = (ImageView) view.findViewById(R.id.imgPosterp4);
        imgPosteri5 = (ImageView) view.findViewById(R.id.imgPosterp5);
        imgPosteri6 = (ImageView) view.findViewById(R.id.imgPosterp6);
        imgPosteri7 = (ImageView) view.findViewById(R.id.imgPosterp7);
        imgPosteri8 = (ImageView) view.findViewById(R.id.imgPosterp8);
        imgPosteri9 = (ImageView) view.findViewById(R.id.imgPosterp9);
        imgPosteri1.setOnClickListener(this);
        imgPosteri2.setOnClickListener(this);
        imgPosteri3.setOnClickListener(this);
        imgPosteri4.setOnClickListener(this);
        imgPosteri5.setOnClickListener(this);
        imgPosteri6.setOnClickListener(this);
        imgPosteri7.setOnClickListener(this);
        imgPosteri8.setOnClickListener(this);
        imgPosteri9.setOnClickListener(this);
        return view;
    }
    private void addEvents() {
        Intent intent = new Intent(getActivity(), DetailTheaterActivity.class);
        intent.putExtra("Type", 0);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.imgPosterp1 || id == R.id.imgPosterp2 || id == R.id.imgPosterp3 ||
                id == R.id.imgPosterp4 || id == R.id.imgPosterp5 ||
                id == R.id.imgPosterp6 || id == R.id.imgPosterp7 ||
                id == R.id.imgPosterp8 || id == R.id.imgPosterp9){
            addEvents();
        }
    }
}
