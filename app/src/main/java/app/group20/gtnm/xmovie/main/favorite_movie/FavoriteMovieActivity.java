package app.group20.gtnm.xmovie.main.favorite_movie;

import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import app.group20.gtnm.xmovie.R;
public class FavoriteMovieActivity extends AppCompatActivity {

    private ImageView imgBack;
    private FrameLayout layoutFavorite1, layoutFavorite2, layoutFavorite3, layoutFavorite4, layoutFavorite5;
    private int index = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_movie);
        addControls ();
        addEvents ();
    }

    private void addEvents() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        layoutFavorite1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                index = 1;
                deleteFavoriteMovie ();
                return false;
            }
        });
        layoutFavorite2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                index = 2;
                deleteFavoriteMovie ();
                return false;
            }
        });
        layoutFavorite3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                index = 3;
                deleteFavoriteMovie ();
                return false;
            }
        });
        layoutFavorite4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                index = 4;
                deleteFavoriteMovie ();
                return false;
            }
        });
        layoutFavorite5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                index = 5;
                deleteFavoriteMovie ();
                return false;
            }
        });


    }

    private void deleteFavoriteMovie() {
        AlertDialog.Builder mBuider = new AlertDialog.Builder(this);
        mBuider.setMessage("Do you want to delete this movie from list?");
        mBuider.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (index == 1){
                    layoutFavorite1.setVisibility(View.GONE);
                }else if (index == 2){
                    layoutFavorite2.setVisibility(View.GONE);
                }else if (index == 3){
                    layoutFavorite3.setVisibility(View.GONE);
                }else if (index == 4){
                    layoutFavorite4.setVisibility(View.GONE);
                }else if (index == 5){
                    layoutFavorite5.setVisibility(View.GONE);
                }
            }
        });
        mBuider.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        mBuider.show();
    }

    private void addControls() {
        imgBack = (ImageView) findViewById(R.id.imgBackFavorite);
        layoutFavorite1 = (FrameLayout) findViewById(R.id.layoutFavorite1);
        layoutFavorite2 = (FrameLayout) findViewById(R.id.layoutFavorite2);
        layoutFavorite3 = (FrameLayout) findViewById(R.id.layoutFavorite3);
        layoutFavorite4 = (FrameLayout) findViewById(R.id.layoutFavorite4);
        layoutFavorite5 = (FrameLayout) findViewById(R.id.layoutFavorite5);


    }
}
