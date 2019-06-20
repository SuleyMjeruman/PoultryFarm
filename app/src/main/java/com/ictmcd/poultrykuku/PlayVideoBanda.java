package com.ictmcd.poultrykuku;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideoBanda extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    Button buttonPlay;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video_banda);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.view3);
        try{
            youTubePlayerView.initialize("AIzaSyDUtGSne6oDOYHkr9pFmT39JBI9_C-BUEM",
                    new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                            YouTubePlayer youTubePlayer, boolean b) {
                            // do any work here to cue video, play video, etc.
                            youTubePlayer.loadVideo("f2TckywuxIE");
                        }
                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                            YouTubeInitializationResult youTubeInitializationResult) {
                        }
                    });
        }catch (Exception e){

        }

    }


public void rudiNyuma(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
}

    @Override
    public void onBackPressed() {
        finish();
    }
}
