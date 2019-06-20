package com.ictmcd.poultrykuku;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class welcomeViewPagerAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public String[] titles={
            "UTANGULIZI",
            "MAUDHUI"
    };
    public welcomeViewPagerAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return titles.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(ConstraintLayout) o;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view=layoutInflater.inflate(R.layout.wizardslider,container,false);
        TextView page1=view.findViewById(R.id.page1);

        page1.setText(titles[position]);
        container.addView(view);
        return  view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
