package app.group20.gtnm.xmovie.main.detailMovie;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import app.group20.gtnm.xmovie.R;

public class PlaytrailerActivity extends AppCompatActivity {

    private MediaController mediaController;
    private VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playtrailer);
        playVideo ();
    }

    private void playVideo() {
        int index = 0;
        Intent intent = getIntent();
        index = intent.getIntExtra("INDEX", 0);
        if (index == 0){
            mediaController = new MediaController(this);
            videoview = (VideoView) findViewById(R.id.videoView);
            videoview.setMediaController(mediaController);
            mediaController.setAnchorView(videoview);
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.power);
            videoview.setVideoURI(uri);
            videoview.start();
        }else if (index == 1){
            mediaController = new MediaController(this);
            videoview = (VideoView) findViewById(R.id.videoView);
            videoview.setMediaController(mediaController);
            mediaController.setAnchorView(videoview);
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.startrek);
            videoview.setVideoURI(uri);
            videoview.start();
        }else if (index == 2){
            mediaController = new MediaController(this);
            videoview = (VideoView) findViewById(R.id.videoView);
            videoview.setMediaController(mediaController);
            mediaController.setAnchorView(videoview);
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lanter);
            videoview.setVideoURI(uri);
            videoview.start();
        }
    }
}
