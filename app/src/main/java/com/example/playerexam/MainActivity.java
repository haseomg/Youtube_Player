package com.example.playerexam;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.IOException;



public class MainActivity extends YouTubeBaseActivity {

    public String VIDEO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    MediaPlayer mediaPlayer = new MediaPlayer();
    String TAG = "[메인 액티비티]";
    Button playBtn;
    VideoView videoView;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.videoView);
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("01763YEx4Fw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize("AIzaSyDQ1yrCF9mOEwAgyLGjmc-SDyagS1lR2KU", listener);
            }
        });

//        videoView = findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
//        videoView.setMediaController(mc);

        //재생 준비가 되었을 때
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                Toast.makeText(MainActivity.this, "동영상 준비됨", Toast.LENGTH_SHORT).show();
//            }
//        });

        //재생이 끝났을때
//        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                Toast.makeText(MainActivity.this, "동영상 재생 완료", Toast.LENGTH_SHORT).show();
//            }
//        });

        //버튼 기능 추가 : 누르면 URL을 URI로 바꾸고 재생생
//        playBtn = findViewById(R.id.playBtn);
//        playBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                videoView.setVideoURI(Uri.parse(VIDEO_URL));
//                videoView.requestFocus();
//                videoView.start();
//            }
//        });

//        playBtn = findViewById(R.id.playBtn);
//        playBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "재생 버튼 클릭");
//
//                preper();
//
//
//                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//
//                    @Override
//                    public void onPrepared(MediaPlayer mp) {
//                        Log.i(TAG, "음악이 준비되었습니다.");
//                        mediaPlayer.start();
//                        Log.i(TAG, "음악이 시작되었습니다.");
//                    }
//                });
//
//            }
//        });
//
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                Log.i(TAG, "음악이 끝났습니다.");
//                preper();
//            }
//        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "동영상 준비중입니다.", Toast.LENGTH_SHORT).show();
    }

    private void preper() {
        Log.i(TAG, "preper 메서드 작동");
        try {
            // reset = 초기화 되지 않은 처음 상태로 객체를 되돌리며 이후 재초기화 하여 다시 사용한다.
            mediaPlayer.reset();
//            mediaPlayer.setDataSource(this, Uri.parse(/var/tmp/music/123.mp3));
//            mediaPlayer.setDataSource("http://54.180.123.224/var/tmp/music/123.mp3");
            mediaPlayer.setDataSource("https://www.youtube.com/watch?v=01763YEx4Fw");

            // 비동기적으로 준비를 하며, 준비 완료를 통보 받는다.
            // *데이터 로딩 시간이 오래 걸린다면 비동기적으로 데이터 로딩하는 아래 메서드를 사용해야 한다.
            mediaPlayer.prepareAsync();
        } catch (IllegalArgumentException | IOException e) {
            Log.i(TAG, "에러 발생 : " + e);
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
            Log.i(TAG, "에러 발생 : " + e);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            Log.i(TAG, "에러 발생 : " + e);
        }
    }
}