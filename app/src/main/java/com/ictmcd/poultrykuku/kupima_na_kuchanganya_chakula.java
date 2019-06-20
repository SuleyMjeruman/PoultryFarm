package com.ictmcd.poultrykuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class kupima_na_kuchanganya_chakula extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kupima_na_kuchanganya_chakula);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.viewVideo);
        try {
            youTubePlayerView.initialize("AIzaSyDUtGSne6oDOYHkr9pFmT39JBI9_C-BUEM",
                    new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                            YouTubePlayer youTubePlayer, boolean b) {

                            youTubePlayer.loadVideo("AYwMHdLAKmI");
                        }

                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                            YouTubeInitializationResult youTubeInitializationResult) {
                        }
                    });
        } catch (Exception e) {

        }
    }
}
