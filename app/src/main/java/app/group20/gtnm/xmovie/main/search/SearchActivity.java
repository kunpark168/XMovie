package app.group20.gtnm.xmovie.main.search;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import app.group20.gtnm.xmovie.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layoutSearch1, layoutSearch2, layoutSearch3 ,layoutSearch4, layoutSearch5 ,layoutSearch6, layoutSearch7;
    private ImageView imgBackSearch;
    private int index = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        addControls ();
        addEvents ();
    }

    private void addEvents() {
        imgBackSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void addControls() {
        imgBackSearch = (ImageView) findViewById(R.id.imgBackSearch);
        layoutSearch1 = (LinearLayout) findViewById(R.id.layoutSearch1);
        layoutSearch2 = (LinearLayout) findViewById(R.id.layoutSearch2);
        layoutSearch3 = (LinearLayout) findViewById(R.id.layoutSearch3);
        layoutSearch4 = (LinearLayout) findViewById(R.id.layoutSearch4);
        layoutSearch5 = (LinearLayout) findViewById(R.id.layoutSearch5);
        layoutSearch6 = (LinearLayout) findViewById(R.id.layoutSearch6);
        layoutSearch7 = (LinearLayout) findViewById(R.id.layoutSearch7);


    }

    public void deleteItemSearch(View view) {
        int id = view.getId();
        if (id == R.id.imgDelete1){
            index = 1;
        }else if (id == R.id.imgDelete2){
            index = 2;
        }else if (id == R.id.imgDelete3){
            index = 3;
        }else if (id == R.id.imgDelete4){
            index = 4;
        }else if (id == R.id.imgDelete5){
            index = 5;
        }else if (id == R.id.imgDelete6){
            index = 6;
        }else if (id == R.id.imgDelete7){
            index = 7;
        }
        AlertDialog.Builder mBuider = new AlertDialog.Builder(this);
        mBuider.setMessage("Do you want to delete?");
        mBuider.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (index == 1){
                    layoutSearch1.setVisibility(View.GONE);
                }else if (index == 2){
                    layoutSearch2.setVisibility(View.GONE);
                }else if (index == 3){
                    layoutSearch3.setVisibility(View.GONE);
                }else if (index == 4){
                    layoutSearch4.setVisibility(View.GONE);
                }else if (index == 5){
                    layoutSearch5.setVisibility(View.GONE);
                }else if (index == 6){
                    layoutSearch6.setVisibility(View.GONE);
                }else if (index == 7){
                    layoutSearch7.setVisibility(View.GONE);
                }
                Toast.makeText(SearchActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClick(View view) {

    }
}
