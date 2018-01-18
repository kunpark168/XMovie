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
import app.group20.gtnm.xmovie.main.detailMovie.DetailUpcomingActivity;
import app.group20.gtnm.xmovie.main.search.SearchActivity;

public class MoreUpcomingMovie extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgPostermp1, imgPostermp2, imgPostermp3, imgPostermp4, imgPostermp5, imgPostermp6, imgPostermp7, imgPostermp8, imgPostermp9 , imgPostermp10,
            imgPostermp11, imgPostermp12, imgPostermp13, imgPostermp14, imgPostermp15, imgBack;
    private EditText edtSearchUpcoming;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_upcoming_movie);
        addControls ();
    }
    private void addControls() {
        imgBack = findViewById(R.id.imgBackMoreUpcoming);
        edtSearchUpcoming = findViewById(R.id.edtSearchUpcoming);
        edtSearchUpcoming.setOnClickListener(this);
        imgBack.setOnClickListener(this);
        imgPostermp1 = (ImageView) findViewById(R.id.imgPostermu1);
        imgPostermp2 = (ImageView) findViewById(R.id.imgPostermu2);
        imgPostermp3 = (ImageView) findViewById(R.id.imgPostermu3);
        imgPostermp4 = (ImageView) findViewById(R.id.imgPostermu4);
        imgPostermp5 = (ImageView) findViewById(R.id.imgPostermu5);
        imgPostermp6 = (ImageView) findViewById(R.id.imgPostermu6);
        imgPostermp7 = (ImageView) findViewById(R.id.imgPostermu7);
        imgPostermp8 = (ImageView) findViewById(R.id.imgPostermu8);
        imgPostermp9 = (ImageView) findViewById(R.id.imgPostermu9);
        imgPostermp10 = (ImageView) findViewById(R.id.imgPostermu10);
        imgPostermp11 = (ImageView) findViewById(R.id.imgPostermu11);
        imgPostermp12 = (ImageView) findViewById(R.id.imgPostermu12);
        imgPostermp13 = (ImageView) findViewById(R.id.imgPostermu13);
        imgPostermp14 = (ImageView) findViewById(R.id.imgPostermu14);
        imgPostermp15 = (ImageView) findViewById(R.id.imgPostermu15);

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
        if (id == R.id.imgPostermu1 || id == R.id.imgPostermu2 || id == R.id.imgPostermu3 ||
                id == R.id.imgPostermu4 || id == R.id.imgPostermu5 || id == R.id.imgPostermu6 ||
                id == R.id.imgPostermu7 || id == R.id.imgPostermu8 || id == R.id.imgPostermu9 ||
                id == R.id.imgPostermu10 || id == R.id.imgPostermu11 || id == R.id.imgPostermu12 ||
                id == R.id.imgPostermu13 || id == R.id.imgPostermu14 || id == R.id.imgPostermu15 ){
            Intent intent = new Intent(this, DetailUpcomingActivity.class);
            startActivity(intent);
        }
        if (id == R.id.edtSearchUpcoming){
            startActivity(new Intent(MoreUpcomingMovie.this, SearchActivity.class));
        }
        if (id == R.id.imgBackMoreUpcoming){
            finish();
        }
    }
}
