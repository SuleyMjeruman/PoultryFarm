package com.ictmcd.poultrykuku;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.ictmcd.poultrykuku.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    YouTubePlayer.OnInitializedListener onInitializedListener;
    YouTubePlayerSupportFragment youTubePlayer;
    TabLayout tabLayout;
    AppBarLayout appBarLayout;
    ViewPager viewPager1;
    TextView textView,textView2;
    CardView card;
    RelativeLayout relativeLayout;
    Button button, btnPlay,back;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.main_toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Miundombinu");


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    public void OpenPlayBandaActivity(View v){

        try {

            Intent intent = new Intent(MainActivity.this,PlayVideoBanda.class);

            startActivity(intent);

        }catch (Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }

    public void onExpColp(View view){



        try{
            button = findViewById(R.id.btnZaidi);
            textView =  findViewById(R.id.txtDesc);
            card = findViewById(R.id.card);
            textView2 = findViewById(R.id.txtDesc2);

            relativeLayout = findViewById(R.id.sifa);

            if(textView.getVisibility()==View.GONE && textView2.getVisibility()==View.GONE && relativeLayout.getVisibility() == View.GONE)
            {
                findViewById(R.id.sifa).setVisibility(View.VISIBLE);
                findViewById(R.id.txtDesc).setVisibility(View.VISIBLE);
                findViewById(R.id.txtDesc2).setVisibility(View.VISIBLE);

                button.setText("Funga");


            }else
            {
                findViewById(R.id.sifa).setVisibility(View.GONE);
                findViewById(R.id.txtDesc).setVisibility(View.GONE);
                findViewById(R.id.txtDesc2).setVisibility(View.GONE);

                button.setText("Soma zaidi...");
            }



        }catch (Exception e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

}