package app.group20.gtnm.xmovie.main.detailMovie;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
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

public class DetailUpcomingActivity extends AppCompatActivity {

    private ImageView imgShare, imgSlideMenu_Upcoming, imgBackMenu;
    private TextView imgPlaytrailer;
    private RecyclerView recyclerActor;
    private DuoDrawerLayout drawer;
    private ArrayList<Actor> arrActor;
    private ActorAdapter adapter;
    private boolean flagFavorite = false;
    private TextView txtCountHeart, txtBackMenu;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayout layoutFavoriteMovie, layoutNotification, layoutShare, layoutHome, layoutAboutUs;
    private RippleView rippleFavorite, rippleNotification, rippleShare, rippleHome, rippleAboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_upcoming);
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
                        startActivity(new Intent(DetailUpcomingActivity.this, AboutUsActivity.class));
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
                        startActivity(new Intent(DetailUpcomingActivity.this, MainActivity.class));
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
                        startActivity(new Intent(DetailUpcomingActivity.this, FavoriteMovieActivity.class));
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
                        startActivity(new Intent(DetailUpcomingActivity.this, NotificationActivity.class));
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
                    Toast.makeText(DetailUpcomingActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                }else {
                    flagFavorite = false;
                    imgShare.setImageResource(R.drawable.ic_nonheart);
                    txtCountHeart.setText("124");
                    Toast.makeText(DetailUpcomingActivity.this, "UnLiked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imgPlaytrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailUpcomingActivity.this, PlaytrailerActivity.class);
                intent.putExtra("INDEX", 1);
                startActivity(intent);
            }
        });
        imgSlideMenu_Upcoming.setOnClickListener(new View.OnClickListener() {
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
        txtBackMenu = findViewById(R.id.txtBackSlideMenuUpcoming);
        imgBackMenu = findViewById(R.id.imgBackSlideMenuUpcoming);
        //Favorite
        layoutFavoriteMovie = (LinearLayout) findViewById(R.id.layoutFavoriteUpcoming);
        rippleFavorite = findViewById(R.id.ripplelayoutFavoriteUpcoming);
        //Nottification
        layoutNotification = findViewById(R.id.layoutNotificationUpcoming);
        rippleNotification = findViewById(R.id.ripplelayoutNotificationUpcoming);
        //Share
        layoutShare = findViewById(R.id.layoutShareUpcoming);
        rippleShare = findViewById(R.id.ripplelayoutShareUpcoming);
        //About Us
        layoutAboutUs = findViewById(R.id.layoutAboutUsUpcoming);
        rippleAboutUs = findViewById(R.id.ripplelayoutAboutUsUpcoming);
        //Home
        layoutHome = findViewById(R.id.layoutHomeUpcoming);
        rippleHome = findViewById(R.id.ripplelayoutHomeUpcoming);


        txtCountHeart = (TextView) findViewById(R.id.txtCountHeartUpcoming);
        drawer = (DuoDrawerLayout) findViewById(R.id.drawer_layout_upcoming);
        imgSlideMenu_Upcoming = (ImageView) findViewById(R.id.imgSlideMenu_Upcoming);
        imgShare = (ImageView) findViewById(R.id.imgShareUpcoming);
        imgPlaytrailer = (TextView) findViewById(R.id.imgPlaytrailerUpcoming);
        arrActor = new ArrayList<>();
        arrActor.add(new Actor("Jame Cameroons", R.drawable.actor1));
        arrActor.add(new Actor("Wallet Bruce", R.drawable.actor2));
        arrActor.add(new Actor("Frand Crơdy", R.drawable.actor3));
        arrActor.add(new Actor("Shep Loyip", R.drawable.actor4));
        recyclerActor = (RecyclerView) findViewById(R.id.recyclerActor);
        adapter = new ActorAdapter(arrActor, this);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerActor.setLayoutManager(layoutManager);
        recyclerActor.setAdapter(adapter);
        getInfo ();
    }

    private void getInfo() {
        final at.blogc.android.views.ExpandableTextView expandableTextView = (at.blogc.android.views.ExpandableTextView) this.findViewById(R.id.expandableTextView);
        final TextView txtReadmore = (TextView) this.findViewById(R.id.txtReadmore);

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
