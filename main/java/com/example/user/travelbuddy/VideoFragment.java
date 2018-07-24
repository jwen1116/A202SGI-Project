package com.example.user.travelbuddy;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoFragment extends Fragment {
    Button play_button;
    VideoView video_penang;
    MediaController mediaC;
    ImageView races;



    public VideoFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);
        play_button=(Button) view.findViewById(R.id.play_button);
        play_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            playVideo(v);
        }
        });
        video_penang=(VideoView) view.findViewById(R.id.video_penang);
        mediaC=new MediaController(getContext());
        races=(ImageView)view.findViewById(R.id.races);


        return view;
    }

    public void playVideo(View v){
        String videopath="android.resource://com.example.user.travelbuddy/"+R.raw.penang;
        Uri uri= Uri.parse(videopath);
        video_penang.setVideoURI(uri);
        video_penang.setMediaController(mediaC);
        mediaC.setAnchorView(video_penang);
        video_penang.start();
    }


}


