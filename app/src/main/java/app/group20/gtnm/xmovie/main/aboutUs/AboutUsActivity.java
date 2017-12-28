package app.group20.gtnm.xmovie.main.aboutUs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import app.group20.gtnm.xmovie.R;

public class AboutUsActivity extends AppCompatActivity {

    private ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        imgBack = findViewById(R.id.imgBackAboutUs);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
