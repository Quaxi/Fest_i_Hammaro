package com.example.quaxi.nicememe;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {
    RotateAnimation rA;
    // Mediaspelare
    MediaPlayer mediaPlayer;
    private Button randomButton;
    private MainPresenter presenter;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.setView(this);


        randomButton = (Button) findViewById(R.id.randomButton);
        randomButton.setOnClickListener(presenter);

        img =  (ImageView) findViewById(R.id.image2);
        rA = new RotateAnimation(0, 11520, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rA.setDuration(20000);


        //Music Player
        mediaPlayer = MediaPlayer.create(this.getBaseContext(), R.raw.bennyhill);
         // no need to call prepare(); create() does that for you



    }

    public void spin(){

        img.startAnimation(rA);
        mediaPlayer.start();
        ChangeBackground();
       // timer.start();


    }

    public void ChangeBackground() {

        //Blinka blinka
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout1);
        final AnimationDrawable drawable = new AnimationDrawable();
        final Handler handler = new Handler();

        drawable.addFrame(new ColorDrawable(Color.RED), 428);
        drawable.addFrame(new ColorDrawable(Color.GREEN), 428);
        drawable.setOneShot(false);

        layout.setBackgroundDrawable(drawable);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawable.start();
            }
        }, 100);

    }

    /*
    CountDownTimer timer = new CountDownTimer(5000, 5000) {

        @Override
        public void onTick(long millisUntilFinished) {
            // Nothing to do
        }

        @Override
        public void onFinish() {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    };*/





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
