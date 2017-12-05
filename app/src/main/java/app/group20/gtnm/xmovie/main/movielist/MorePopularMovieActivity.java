package app.group20.gtnm.xmovie.main.movielist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import app.group20.gtnm.xmovie.R;
import app.group20.gtnm.xmovie.main.detailMovie.DetailPopularActivity;

public class MorePopularMovieActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgPostermp1, imgPostermp2, imgPostermp3, imgPostermp4, imgPostermp5, imgPostermp6, imgPostermp7, imgPostermp8, imgPostermp9 , imgPostermp10,
                      imgPostermp11, imgPostermp12, imgPostermp13, imgPostermp14, imgPostermp15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_popular_movie);
        addControls ();
    }

    private void addControls() {
        imgPostermp1 = (ImageView) findViewById(R.id.imgPostermp1);
        imgPostermp2 = (ImageView) findViewById(R.id.imgPostermp2);
        imgPostermp3 = (ImageView) findViewById(R.id.imgPostermp3);
        imgPostermp4 = (ImageView) findViewById(R.id.imgPostermp4);
        imgPostermp5 = (ImageView) findViewById(R.id.imgPostermp5);
        imgPostermp6 = (ImageView) findViewById(R.id.imgPostermp6);
        imgPostermp7 = (ImageView) findViewById(R.id.imgPostermp7);
        imgPostermp8 = (ImageView) findViewById(R.id.imgPostermp8);
        imgPostermp9 = (ImageView) findViewById(R.id.imgPostermp9);
        imgPostermp10 = (ImageView) findViewById(R.id.imgPostermp10);
        imgPostermp11 = (ImageView) findViewById(R.id.imgPostermp11);
        imgPostermp12 = (ImageView) findViewById(R.id.imgPostermp12);
        imgPostermp13 = (ImageView) findViewById(R.id.imgPostermp13);
        imgPostermp14 = (ImageView) findViewById(R.id.imgPostermp14);
        imgPostermp15 = (ImageView) findViewById(R.id.imgPostermp15);

        imgPostermp1.setOnClickListener(this);
        imgPostermp2.setOnClickListener(this);
        imgPostermp3.setOnClickListener(this);
        imgPostermp4.setOnClickListener(this);
        imgPostermp5.setOnClickListener(this);
        imgPostermp6.setOnClickListener(this);
        imgPostermp7.setOnClickListener(this);
        imgPostermp8.setOnClickListener(this);
        imgPostermp9.setOnClickListener(this);
        imgPostermp10.setOnClickListener(this);
        imgPostermp11.setOnClickListener(this);
        imgPostermp12.setOnClickListener(this);
        imgPostermp13.setOnClickListener(this);
        imgPostermp14.setOnClickListener(this);
        imgPostermp15.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.imgPostermp1 || id == R.id.imgPostermp2 || id == R.id.imgPostermp3 ||
                id == R.id.imgPostermp4 || id == R.id.imgPostermp5 || id == R.id.imgPostermp6 ||
                id == R.id.imgPostermp7 || id == R.id.imgPostermp8 || id == R.id.imgPostermp9 ||
                id == R.id.imgPostermp10 || id == R.id.imgPostermp11 || id == R.id.imgPostermp12 ||
                id == R.id.imgPostermp13 || id == R.id.imgPostermp14 || id == R.id.imgPostermp15 ){
            Intent intent = new Intent(this, DetailPopularActivity.class);
            startActivity(intent);
        }
    }
}
