package com.example.administrator.myapplication.activity.activity.LongRead;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by 沙云杰 on 2016/5/15.
 */
public class MusicService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        play();
        return new musiccontroller();
    }
    class musiccontroller extends Binder implements MusicIterface{
        @Override
        public void play() {
            MusicService.this.play();
        }
    }
    void play() {
        try {
            MediaPlayer m = new MediaPlayer();
            m.reset();
  //          m.setDataSource("/data/media/0/Music/english.mp3");
            m.setDataSource("data/data/com.example.administrator.myapplication/files/english.mp3");
            m.prepare();
            m.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
