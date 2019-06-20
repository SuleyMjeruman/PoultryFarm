package com.ictmcd.poultrykuku;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class kisasa extends Fragment {
    private kisasaViewPagerAdapter kisasaViewPagerAdapter;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[] kisasaDots;
    private int mCurrentPage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_kisasa, container, false);
        Toolbar toolbar =view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        viewPager=view.findViewById(R.id.kisasaViewPager);
        kisasaViewPagerAdapter=new kisasaViewPagerAdapter(getContext());
        viewPager.setAdapter(kisasaViewPagerAdapter);

        linearLayout=view.findViewById(R.id.kisasaDots);
        addDots(0);
        viewPager.addOnPageChangeListener(viewListener);
        return view;
    }
    public void addDots(int position){
        kisasaDots=new TextView[3];
        linearLayout.removeAllViews();
        for(int i=0;i<kisasaDots.length;i++){
            kisasaDots[i]=new TextView(getContext());
            kisasaDots[i].setText(Html.fromHtml("&#8226;"));
            kisasaDots[i].setTextSize(35);
            kisasaDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            linearLayout.addView(kisasaDots[i]);
        }
        if(kisasaDots.length>0){
            kisasaDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDots(i);
            mCurrentPage=i;
        }
        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
