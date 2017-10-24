package edu.orangecoastcollege.cs273.balbert.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * AnimationActivity is the main and only Controller for NorthernLightsAnimation.
 *
 * This app has 4 unique animations to apply to the ImageView.
 *
 * When a button is tapped, its respective toggleAnim method is called.
 */
public class AnimationActivity extends AppCompatActivity {

    private AnimationDrawable frameAnim; // used for frame animations
    private Animation rotateAnim; // used for tween(ed) animations
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;

    /**
     * onCreate() sets the content view and wires this controller to the lone ImageView
     * in the activity_animation.xml View.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    /**
     * toggleFrameAnim(View view) is called when the Frame Animation button is tapped.
     *
     * The first time the button is tapped, the frameAnim AnimationDrawable is null.
     * The ImageView is then wired to this frameAnim AnimationDrawable.
     *
     * If the animation is running and the button is tapped again, it is stopped.
     * Otherwise, if the frameAnim has been initialized and it is not running, start it.
     * @param view
     */
    public void toggleFrameAnim(View view)
    {
        // hasn't been initialized yet
        if (frameAnim == null)
        {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        // if frameAnim is running, stop it
        if(frameAnim.isRunning()) frameAnim.stop();
        // else start it
        else frameAnim.start();
    }

    /**
     * toggleRotateAnim(View view) is called when the Rotate Animation button is tapped.
     *
     * If the rotateAnim Animation object is null, load the appropriate animation code from
     * rotate_anim.xml in the anim directory.
     *
     * If the animation has not started or it has ended, start the animation when the the
     * Rotate Animation button is tapped.
     *
     * Otherwise, since the button has been tapped again, and the animation is in progress,
     * stop it.
     * @param view
     */
    public void toggleRotateAnim(View view)
    {
        // hasn't been initialized yet
        if (rotateAnim == null) rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        // Connect it to the ImageView
        if (!rotateAnim.hasStarted() || rotateAnim.hasEnded())
            lightsImageView.startAnimation(rotateAnim);
        else
            lightsImageView.clearAnimation();
    }

    /**
     * toggleShakeAnim(View view) is called when the Shake Animation button is tapped.
     *
     * The appropriate xml file is loaded, shake_anim.xml and the animation is started.
     *
     * @param view
     */
    public void toggleShakeAnim(View view)
    {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);
    }

    /**
     * toggleCustomAnim(View view) is called when the Custom Animation button is tapped.
     *
     * The appropriate xml file is loaded, custom_anim.xml and the animation is started.
     *
     * @param view
     */
    public void toggleCustomAnim(View view)
    {
        customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        lightsImageView.startAnimation(customAnim);
    }
}
