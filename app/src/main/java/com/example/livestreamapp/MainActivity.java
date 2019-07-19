package com.example.livestreamapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchVideoPlayer(View view) {
        String liveurl="rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov";
        /*String liveurl="rtsp://82.94.213.26/live-low.sdp";*/

        Intent videointent = new Intent(this, VideoPlayer.class);
        videointent.putExtra("liveurl", liveurl);
        startActivity(videointent);
    }
}
