package app.group20.gtnm.xmovie.main.main;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import net.alexandroid.utils.indicators.IndicatorsView;

import app.group20.gtnm.xmovie.R;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Kunka on 11/4/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int arrPosterLandscape [];
    private CircleIndicator indicator;
    private ViewPager viewPager;

    public ViewPagerAdapter(Context mContext, int[] arrPosterLandscape, ViewPager viewPager) {
        this.mContext = mContext;
        this.arrPosterLandscape = arrPosterLandscape;
        this.viewPager = viewPager;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_viewpager, container, false);
        indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        ImageView imgBaner = (ImageView) rootView.findViewById(R.id.imgBaner);
        setUpIndicator ();
        imgBaner.setImageResource(arrPosterLandscape[position]);
        container.addView(rootView);
        return rootView;
    }

    private void setUpIndicator() {
        indicator.setViewPager(viewPager);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return arrPosterLandscape.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
