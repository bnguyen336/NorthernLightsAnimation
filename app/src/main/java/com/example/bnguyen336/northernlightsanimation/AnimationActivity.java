package com.example.bnguyen336.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView lightsImageView;
    private Button frameAnimButton;
    private Button rotateAnimButton;
    private Button shakeAnimButton;
    private Button flipAnimButton;
    private AnimationDrawable frameAnim; //frame anim class
    private Animation rotateAnim; //tween anim class
    private Animation shakeAnim;
    private Animation customAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
        frameAnimButton = (Button) findViewById(R.id.frameAnimButton);
        rotateAnimButton = (Button) findViewById(R.id.rotateAnimButton);
        shakeAnimButton = (Button) findViewById(R.id.shakeAnimButton);
        flipAnimButton = (Button) findViewById(R.id.flipAnimButton);
    }

    public void toggleFrameAnim(View view) {
        //Set background of image view
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);
        //Associate frameAnim with animation in XML
        frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        if (frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();
    }

    public void toggleRotateAnim(View view) {
        if (rotateAnim != null && rotateAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }
        else {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
            lightsImageView.startAnimation(rotateAnim);
        }
    }

    public void toggleShakeAnim(View view) {
        if (shakeAnim != null && shakeAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            shakeAnim = null;
        }
        else {
            shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
            lightsImageView.startAnimation(shakeAnim);
        }
    }
}
