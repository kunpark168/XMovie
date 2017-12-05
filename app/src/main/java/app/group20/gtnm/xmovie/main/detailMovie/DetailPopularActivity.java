package app.group20.gtnm.xmovie.main.detailMovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

import app.group20.gtnm.xmovie.R;

public class DetailPopularActivity extends AppCompatActivity {

    private RecyclerView recyclerActor;
    private ArrayList<Actor> arrActor;
    private DrawerLayout drawer;
    private ActorAdapter adapter;
    private ImageView imgShare, imgSlideMenu_Popular;
    private TextView imgPlaytrailer;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_popular);
        addControls ();
        addEvents ();
    }

    private void addEvents() {
        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                // Add data to the intent, the receiving app will decide
                // what to do with it.
                share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                share.putExtra(Intent.EXTRA_TEXT, "http://www.phimmoi.net/phim/chien-binh-long-den-xanh-5463/");

                startActivity(Intent.createChooser(share, "Share This Movie"));
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
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_popular);
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