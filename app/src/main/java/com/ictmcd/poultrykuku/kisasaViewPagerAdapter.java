package com.ictmcd.poultrykuku;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class kisasaViewPagerAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public int[] images={
            R.drawable.kizungu3,
            R.drawable.kizungu4,
            R.drawable.kizungu1
    };
    public kisasaViewPagerAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(ConstraintLayout) o;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view=layoutInflater.inflate(R.layout.kienyejislider,container,false);
        ImageView kienyejiImage=view.findViewById(R.id.kienyejiImage);
        kienyejiImage.setImageResource(images[position]);

        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}

