package com.example.quaxi.nicememe;

import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Quaxi on 15-04-06.
 */
public class MainPresenter implements View.OnClickListener {

    private MainActivity view;

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.randomButton) {
            //Toast toast = Toast.makeText(v.getContext(), "Vad händer?", Toast.LENGTH_SHORT);
            // toast.show();

            view.spin();
        }
    }

    public void setView(MainActivity view) {
        this.view = view;
    }
}
