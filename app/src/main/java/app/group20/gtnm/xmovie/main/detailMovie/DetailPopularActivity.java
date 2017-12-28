package app.group20.gtnm.xmovie.main.detailMovie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

import app.group20.gtnm.xmovie.R;
import app.group20.gtnm.xmovie.main.aboutUs.AboutUsActivity;
import app.group20.gtnm.xmovie.main.favorite_movie.FavoriteMovieActivity;
import app.group20.gtnm.xmovie.main.main.MainActivity;
import app.group20.gtnm.xmovie.main.notification.NotificationActivity;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;

public class DetailPopularActivity extends AppCompatActivity {

    private RecyclerView recyclerActor;
    private ArrayList<Actor> arrActor;
    private DuoDrawerLayout drawer;
    private ActorAdapter adapter;
    private ImageView imgShare, imgSlideMenu_Popular, imgBackMenu;
    private TextView imgPlaytrailer, txtCountHeart, txtBackMenu;
    private LinearLayout layoutFavoriteMovie, layoutNotification, layoutShare, layoutHome, layoutAboutUs;
    private RippleView  rippleFavorite, rippleNotification, rippleShare, rippleHome, rippleAboutUs;
    private RecyclerView.LayoutManager layoutManager;
    private boolean flagFavorite = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_popular);
        addControls ();
        addEvents ();
    }

    private void addEvents() {

        //About Us
        layoutAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DetailPopularActivity.this, AboutUsActivity.class));
                    }
                }, 500);
            }
        });
        rippleAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Home
        layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DetailPopularActivity.this, MainActivity.class));
                    }
                }, 500);
            }
        });
        rippleHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Share
        layoutShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL");
                        i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=apps.movie");
                        startActivity(Intent.createChooser(i, "Share URL"));
                    }
                }, 500);

            }
        });
        //Favorite
        layoutFavoriteMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DetailPopularActivity.this, FavoriteMovieActivity.class));
                    }
                }, 500);
            }
        });
        rippleFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Notification
        layoutNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DetailPopularActivity.this, NotificationActivity.class));
                    }
                }, 500);
            }
        });
        rippleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        txtBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        imgBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flagFavorite){
                    flagFavorite = true;
                    imgShare.setImageResource(R.drawable.ic_heart);
                    txtCountHeart.setText("125");
                    Toast.makeText(DetailPopularActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                }else {
                    flagFavorite = false;
                    imgShare.setImageResource(R.drawable.ic_nonheart);
                    txtCountHeart.setText("124");
                    Toast.makeText(DetailPopularActivity.this, "Unliked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imgPlaytrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPopularActivity.this, PlaytrailerActivity.class);
                intent.putExtra("INDEX", 2);
                startActivity(intent);
            }
        });
        imgSlideMenu_Popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }else {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
    }

    private void addControls() {
        txtBackMenu = findViewById(R.id.txtBackSlideMenuPopular);
        imgBackMenu = findViewById(R.id.imgBackSlideMenuPopular);
        //Favorite
        layoutFavoriteMovie = (LinearLayout) findViewById(R.id.layoutFavoritePopular);
        rippleFavorite = findViewById(R.id.ripplelayoutFavoritePopular);
        //Nottification
        layoutNotification = findViewById(R.id.layoutNotificationPopular);
        rippleNotification = findViewById(R.id.ripplelayoutNotificationPopular);
        //Share
        layoutShare = findViewById(R.id.layoutSharePopular);
        rippleShare = findViewById(R.id.ripplelayoutSharePopular);
        //About Us
        layoutAboutUs = findViewById(R.id.layoutAboutUsPopular);
        rippleAboutUs = findViewById(R.id.ripplelayoutAboutUsPopular);
        //Home
        layoutHome = findViewById(R.id.layoutHomePopular);
        rippleHome = findViewById(R.id.ripplelayoutHomePopular);


        txtCountHeart = (TextView) findViewById(R.id.txtCountHeartIntheater);
        txtCountHeart = (TextView) findViewById(R.id.txtCountHeart);
        drawer = (DuoDrawerLayout) findViewById(R.id.drawer_layout_popular);
        imgSlideMenu_Popular = (ImageView) findViewById(R.id.imgSlideMenu_Popular);
        imgShare = (ImageView) findViewById(R.id.imgSharePopular);
        imgPlaytrailer = (TextView) findViewById(R.id.imgPlaytrailerPopular);
        arrActor = new ArrayList<>();
        arrActor.add(new Actor("Jame Cameroons", R.drawable.actor1));
        arrActor.add(new Actor("Wallet Bruce", R.drawable.actor2));
        arrActor.add(new Actor("Frand Crơdy", R.drawable.actor3));
        arrActor.add(new Actor("Shep Loyip", R.drawable.actor4));
        recyclerActor = (RecyclerView) findViewById(R.id.recyclerActorPopular);
        adapter = new ActorAdapter(arrActor, this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerActor.setLayoutManager(layoutManager);
        recyclerActor.setAdapter(adapter);
        getInfo ();
    }

    private void getInfo() {
        final at.blogc.android.views.ExpandableTextView expandableTextView = (at.blogc.android.views.ExpandableTextView) this.findViewById(R.id.expandableTextViewPopular);
        final TextView txtReadmore = (TextView) this.findViewById(R.id.txtReadmorePopular);

// set animation duration via code, but preferable in your layout files by using the animation_duration attribute
        expandableTextView.setAnimationDuration(750L);

        // set interpolators for both expanding and collapsing animations
        expandableTextView.setInterpolator(new OvershootInterpolator());

// or set them separately
        expandableTextView.setExpandInterpolator(new OvershootInterpolator());
        expandableTextView.setCollapseInterpolator(new OvershootInterpolator());

// toggle the ExpandableTextView
        txtReadmore.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                expandableTextView.toggle();
            }
        });
    }
}
