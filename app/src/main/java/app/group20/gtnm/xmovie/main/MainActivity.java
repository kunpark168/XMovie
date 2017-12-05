package app.group20.gtnm.xmovie.main;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import app.group20.gtnm.xmovie.R;
import app.group20.gtnm.xmovie.main.inTheater.InTheaterFragment;
import app.group20.gtnm.xmovie.main.movielist.MorePopularMovieActivity;
import app.group20.gtnm.xmovie.main.movielist.MoreTheaterMovieActivity;
import app.group20.gtnm.xmovie.main.movielist.MoreUpcomingMovie;
import app.group20.gtnm.xmovie.main.popular.PopularFragment;
import app.group20.gtnm.xmovie.main.upComing.UpcomingFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private DrawerLayout drawer;
    private ViewPagerAdapter adapter;
    private ImageView imgSilderMenu;
    private TextView txtMoreMovie;
    private int NUM_PAGES, currentPage;
    private TextView txtIntheaters, txtUpcoming, txtPopular;
    private UpcomingFragment upcomingFragment;
    private int typeMovie = 1, arrPoster_landscape [] = {R.drawable.baner01, R.drawable.baner02, R.drawable.baner03, R.drawable.baner04, R.drawable.baner05};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls ();
        addEvents ();
    }

    private void addEvents() {
        txtIntheaters.setOnClickListener(this);
        txtUpcoming.setOnClickListener(this);
        txtPopular.setOnClickListener(this);
        txtMoreMovie.setOnClickListener(this);
        imgSilderMenu.setOnClickListener(this);
    }

    private void addControls() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        imgSilderMenu = (ImageView) findViewById(R.id.imgSildemenu);
        txtMoreMovie = (TextView) findViewById(R.id.txtMoreMovie);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(this, arrPoster_landscape, viewPager);
        NUM_PAGES = adapter.getCount();
        currentPage = viewPager.getCurrentItem();
        viewPager.setAdapter(adapter);
        setUpTimerForViewPager ();

        txtIntheaters = (TextView) findViewById(R.id.txtInTheaters);
        txtUpcoming = (TextView) findViewById(R.id.txtUpcoming);
        txtPopular = (TextView) findViewById(R.id.txtPopular);
        upcomingFragment = new UpcomingFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (upcomingFragment != null) {
            fragmentTransaction.replace(R.id.containerMovieList, upcomingFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    private void setUpTimerForViewPager() {
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage == NUM_PAGES) {
                            currentPage = 0;
                        }
                        viewPager.setCurrentItem(currentPage++, true);
                    }
                });
            }
        }, 500, 3000);
    }

    @Override
    public void onClick(View v) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        android.app.Fragment newFragment = null;
        int id = v.getId();
        switch (id){
            case R.id.txtInTheaters :
                typeMovie = 0;
                newFragment = new InTheaterFragment();
                changeColorTabbar(0);
                break;
            case R.id.txtUpcoming :
                typeMovie = 1;
                newFragment = new UpcomingFragment();
                changeColorTabbar(1);
                break;
            case R.id.txtPopular :
                typeMovie = 2;
                newFragment = new PopularFragment();
                changeColorTabbar(2);
                break;
            case R.id.txtMoreMovie :
                moveToMoreMovieActivity ();
                break;
            case R.id.imgSildemenu :
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }else {
                    drawer.closeDrawer(GravityCompat.START);
                }
                break;
            default:
                break;
        }
        if (newFragment != null) {
            fragmentTransaction.replace(R.id.containerMovieList, newFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        /*if (id == R.id.txtInTheaters){
           // dialogPink.show();
            typeMovie = 0;
            newFragment = new InTheaterFragment();
            changeColorTabbar(0);

        }else if (id == R.id.txtUpcoming){
          //  dialogBlue.show();
            typeMovie = 1;
            newFragment = new UpcomingFragment();
            changeColorTabbar(1);

        }else if (id == R.id.txtPopular){
           // dialogGreen.show();
            typeMovie = 2;
            newFragment = new PopularFragment();
            changeColorTabbar(2);
        }
        if (id == R.id.txtMoreMovie){
            moveToMoreMovieActivity ();
        }
        if (id == R.id.imgSildemenu){
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
        if (newFragment != null) {
            fragmentTransaction.replace(R.id.containerMovieList, newFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }*/
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void moveToMoreMovieActivity() {
        if (typeMovie == 0 ){
            Intent intent = new Intent(this, MoreTheaterMovieActivity.class);
            startActivity(intent);
        }else if (typeMovie == 1){
            Intent intent = new Intent(this, MoreUpcomingMovie.class);
            startActivity(intent);
        }else if (typeMovie == 2){
            Intent intent = new Intent(this, MorePopularMovieActivity.class);
            startActivity(intent);
        }
    }

    public void changeColorTabbar (int position){
        if (position == 0){
            txtIntheaters.setBackground(getResources().getDrawable(R.drawable.bg_item0_tabbar_selected));
            txtIntheaters.setTextColor(getResources().getColor(R.color.colorBlack));
            txtIntheaters.setTypeface(null, Typeface.NORMAL);
            txtUpcoming.setTypeface(txtUpcoming.getTypeface(), Typeface.BOLD);
            txtPopular.setTypeface(txtPopular.getTypeface(), Typeface.BOLD);

            txtUpcoming.setBackground(getResources().getDrawable(R.drawable.bg_item1_tabbar_nonselected));
            txtUpcoming.setTextColor(getResources().getColor(R.color.colorYellow));
            txtPopular.setBackground(getResources().getDrawable(R.drawable.bg_item2_tabbar_nonselected));
            txtPopular.setTextColor(getResources().getColor(R.color.colorYellow));
        }else if (position == 1){
            txtUpcoming.setBackground(getResources().getDrawable(R.drawable.bg_item1_tabbar_selected));
            txtUpcoming.setTextColor(getResources().getColor(R.color.colorBlack));
            txtIntheaters.setTypeface(txtIntheaters.getTypeface(), Typeface.BOLD);
            txtUpcoming.setTypeface(null, Typeface.NORMAL);
            txtPopular.setTypeface(txtPopular.getTypeface(), Typeface.BOLD);

            txtIntheaters.setBackground(getResources().getDrawable(R.drawable.bg_item0_tabbar_nonselected));
            txtIntheaters.setTextColor(getResources().getColor(R.color.colorYellow));
            txtPopular.setBackground(getResources().getDrawable(R.drawable.bg_item2_tabbar_nonselected));
            txtPopular.setTextColor(getResources().getColor(R.color.colorYellow));
        }else if (position == 2){
            txtPopular.setBackground(getResources().getDrawable(R.drawable.bg_item2_tabbar_selected));
            txtPopular.setTextColor(getResources().getColor(R.color.colorBlack));
            txtIntheaters.setTypeface(txtIntheaters.getTypeface(), Typeface.BOLD);
            txtUpcoming.setTypeface(txtUpcoming.getTypeface(), Typeface.BOLD);
            txtPopular.setTypeface(null, Typeface.NORMAL);

            txtUpcoming.setBackground(getResources().getDrawable(R.drawable.bg_item1_tabbar_nonselected));
            txtUpcoming.setTextColor(getResources().getColor(R.color.colorYellow));
            txtIntheaters.setBackground(getResources().getDrawable(R.drawable.bg_item0_tabbar_nonselected));
            txtIntheaters.setTextColor(getResources().getColor(R.color.colorYellow));
        }
    }
}