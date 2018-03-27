package com.tienthinh.youtubeapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {
    YouTubePlayerView youTubePlayerView;
    int Request_Video = 123;

    String API_Key = "AIzaSyCGI9sdFMJjoQpsgiP0xggeVUpB6hF8Xog";
    String ID_PlayList ="PL9fAyTCUtgbl0Ex7uzjv39leWvYD4JwDZ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        youTubePlayerView.initialize(API_Key,this);
    }

    private void initView() {
        youTubePlayerView =(YouTubePlayerView) findViewById(R.id.myYouTube);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer, boolean b) {
    youTubePlayer.cueVideo("lw4Qp37Dwgk");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()){

            youTubeInitializationResult.getErrorDialog(MainActivity.this,Request_Video);
        }else{
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==Request_Video){

            youTubePlayerView.initialize(API_Key,MainActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
