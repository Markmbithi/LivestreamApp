package com.example.livestreamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    String liveurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent linkintent = getIntent();

        liveurl = linkintent.getStringExtra("liveurl");
        setContentView(R.layout.activity_video_player);
        VideoView videoView = (VideoView) findViewById(R.id.live_stream);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);

        Uri video = Uri.parse(liveurl);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(video);
        videoView.start();

        if (liveurl.startsWith("rttsp://") || liveurl.startsWith("https://") || liveurl.startsWith("http://")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(liveurl));
            startActivity(intent);
        }
    }
}
