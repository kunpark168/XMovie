package app.group20.gtnm.xmovie.main.popular;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import app.group20.gtnm.xmovie.R;
import app.group20.gtnm.xmovie.main.detailMovie.DetailPopularActivity;
import app.group20.gtnm.xmovie.main.detailMovie.DetailUpcomingActivity;

public class PopularFragment extends android.app.Fragment implements View.OnClickListener {

    private ImageView imgPosteri1, imgPosteri2, imgPosteri3, imgPosteri4, imgPosteri5, imgPosteri6, imgPosteri7, imgPosteri8, imgPosteri9;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        imgPosteri1 = (ImageView) view.findViewById(R.id.imgPosteri1);
        imgPosteri2 = (ImageView) view.findViewById(R.id.imgPosteri2);
        imgPosteri3 = (ImageView) view.findViewById(R.id.imgPosteri3);
        imgPosteri4 = (ImageView) view.findViewById(R.id.imgPosteri4);
        imgPosteri5 = (ImageView) view.findViewById(R.id.imgPosteri5);
        imgPosteri6 = (ImageView) view.findViewById(R.id.imgPosteri6);
        imgPosteri7 = (ImageView) view.findViewById(R.id.imgPosteri7);
        imgPosteri8 = (ImageView) view.findViewById(R.id.imgPosteri8);
        imgPosteri9 = (ImageView) view.findViewById(R.id.imgPosteri9);
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
        Intent intent = new Intent(getActivity(), DetailPopularActivity.class);
        intent.putExtra("Type", 2);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.imgPosteri1 || id == R.id.imgPosteri2 || id == R.id.imgPosteri3 ||
                id == R.id.imgPosteri4 || id == R.id.imgPosteri5 ||
                id == R.id.imgPosteri6 || id == R.id.imgPosteri7 ||
                id == R.id.imgPosteri8 || id == R.id.imgPosteri9){
            addEvents();
        }
    }
}
