package app.group20.gtnm.xmovie.main.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import app.group20.gtnm.xmovie.R;
import app.group20.gtnm.xmovie.main.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imgLogo = findViewById(R.id.imgLogo);
        Animation animLogo = AnimationUtils.loadAnimation(this, R.anim.anim_logo);
        imgLogo.setAnimation(animLogo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 3000);
    }
}
