package app.group20.gtnm.xmovie.main.movielist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import app.group20.gtnm.xmovie.R;
import app.group20.gtnm.xmovie.main.detailMovie.DetailPopularActivity;
import app.group20.gtnm.xmovie.main.detailMovie.DetailTheaterActivity;
import app.group20.gtnm.xmovie.main.search.SearchActivity;

public class MoreTheaterMovieActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgPostermp1, imgPostermp2, imgPostermp3, imgPostermp4, imgPostermp5, imgPostermp6, imgPostermp7, imgPostermp8, imgPostermp9 , imgPostermp10,
            imgPostermp11, imgPostermp12, imgPostermp13, imgPostermp14, imgPostermp15, imgBack;
    private EditText edtSearchTheater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_theater_movie);
        addControls ();
    }
    private void addControls() {
        imgBack = findViewById(R.id.imgBackMoreTheater);
        edtSearchTheater = findViewById(R.id.edtSearchTheater);
        imgBack.setOnClickListener(this);
        edtSearchTheater.setOnClickListener(this);
        imgPostermp1 = (ImageView) findViewById(R.id.imgPostermi1);
        imgPostermp2 = (ImageView) findViewById(R.id.imgPostermi2);
        imgPostermp3 = (ImageView) findViewById(R.id.imgPostermi3);
        imgPostermp4 = (ImageView) findViewById(R.id.imgPostermi4);
        imgPostermp5 = (ImageView) findViewById(R.id.imgPostermi5);
        imgPostermp6 = (ImageView) findViewById(R.id.imgPostermi6);
        imgPostermp7 = (ImageView) findViewById(R.id.imgPostermi7);
        imgPostermp8 = (ImageView) findViewById(R.id.imgPostermi8);
        imgPostermp9 = (ImageView) findViewById(R.id.imgPostermi9);
        imgPostermp10 = (ImageView) findViewById(R.id.imgPostermi10);
        imgPostermp11 = (ImageView) findViewById(R.id.imgPostermi11);
        imgPostermp12 = (ImageView) findViewById(R.id.imgPostermi12);
        imgPostermp13 = (ImageView) findViewById(R.id.imgPostermi13);
        imgPostermp14 = (ImageView) findViewById(R.id.imgPostermi14);
        imgPostermp15 = (ImageView) findViewById(R.id.imgPostermi15);

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
        if (id == R.id.imgPostermi1 || id == R.id.imgPostermi2 || id == R.id.imgPostermi3 ||
                id == R.id.imgPostermi4 || id == R.id.imgPostermi5 || id == R.id.imgPostermi6 ||
                id == R.id.imgPostermi7 || id == R.id.imgPostermi8 || id == R.id.imgPostermi9 ||
                id == R.id.imgPostermi10 || id == R.id.imgPostermi11 || id == R.id.imgPostermi12 ||
                id == R.id.imgPostermi13 || id == R.id.imgPostermi14 || id == R.id.imgPostermi15 ){
            Intent intent = new Intent(this, DetailTheaterActivity.class);
            startActivity(intent);
        }
        if (id == R.id.edtSearchTheater){
            startActivity(new Intent(MoreTheaterMovieActivity.this, SearchActivity.class));
        }
        if (id == R.id.imgBackMoreTheater){
            finish();
        }
    }
}
