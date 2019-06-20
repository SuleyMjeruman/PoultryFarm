package com.ictmcd.poultrykuku;


import android.content.Intent;
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

public class kienyeji extends Fragment {
    private kienyejiViewPagerAdapter kienyejiViewPagerAdapter;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[] kienyejiDots;
    private int mCurrentPage;
    TextView video;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_kienyeji, container, false);
        Toolbar toolbar =view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        viewPager=view.findViewById(R.id.kienyejiViewPager);
        kienyejiViewPagerAdapter=new kienyejiViewPagerAdapter(getContext());
        viewPager.setAdapter(kienyejiViewPagerAdapter);

        linearLayout=view.findViewById(R.id.kienyejiDots);
        addDots(0);
        viewPager.addOnPageChangeListener(viewListener);


        video=view.findViewById(R.id.videoAinaKuku);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ainaKuku_video.class));
            }
        });
        return view;
    }
    public void addDots(int position){
        kienyejiDots=new TextView[3];
        linearLayout.removeAllViews();
        for(int i=0;i<kienyejiDots.length;i++){
            kienyejiDots[i]=new TextView(getContext());
            kienyejiDots[i].setText(Html.fromHtml("&#8226;"));
            kienyejiDots[i].setTextSize(35);
            kienyejiDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            linearLayout.addView(kienyejiDots[i]);
        }
        if(kienyejiDots.length>0){
            kienyejiDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
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
