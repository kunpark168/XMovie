package app.group20.gtnm.xmovie.main.upComing;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import app.group20.gtnm.xmovie.R;
import app.group20.gtnm.xmovie.main.detailMovie.DetailUpcomingActivity;

public class UpcomingFragment extends android.app.Fragment implements View.OnClickListener{

    private ImageView imgPosteru1, imgPosteru2, imgPosteru3, imgPosteru4, imgPosteru5, imgPosteru6, imgPosteru7, imgPosteru8, imgPosteru9;
    public UpcomingFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        imgPosteru1 = (ImageView) view.findViewById(R.id.posteru1);
        imgPosteru2 = (ImageView) view.findViewById(R.id.posteru2);
        imgPosteru3 = (ImageView) view.findViewById(R.id.posteru3);
        imgPosteru4 = (ImageView) view.findViewById(R.id.posteru4);
        imgPosteru5 = (ImageView) view.findViewById(R.id.posteru5);
        imgPosteru6 = (ImageView) view.findViewById(R.id.posteru6);
        imgPosteru7 = (ImageView) view.findViewById(R.id.posteru7);
        imgPosteru8 = (ImageView) view.findViewById(R.id.posteru8);
        imgPosteru9 = (ImageView) view.findViewById(R.id.posteru9);
        imgPosteru1.setOnClickListener(this);
        imgPosteru2.setOnClickListener(this);
        imgPosteru3.setOnClickListener(this);
        imgPosteru4.setOnClickListener(this);
        imgPosteru5.setOnClickListener(this);
        imgPosteru6.setOnClickListener(this);
        imgPosteru7.setOnClickListener(this);
        imgPosteru8.setOnClickListener(this);
        imgPosteru9.setOnClickListener(this);
        return view;
    }

    private void addEvents() {
        Intent intent = new Intent(getActivity(), DetailUpcomingActivity.class);
        intent.putExtra("Type", 1);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.posteru1 || id == R.id.posteru2 || id == R.id.posteru9 ||
                id == R.id.posteru3 || id == R.id.posteru4 ||
                id == R.id.posteru5 || id == R.id.posteru6 ||
                id == R.id.posteru7 || id == R.id.posteru8){
            addEvents();
        }
    }
}
