package com.google.android.devbytes.viewanimations;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Created by aleks on 17.06.13.
 */
public class ScaleFragment extends AnimationFragment {

    @Override
    protected int getViewId() {
        return R.id.scaleButton;
    }

    @Override
    protected int getAnimId() {
        return R.anim.scale_anim;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_scale_anim;
    }

    @Override
    protected final Animation createAnimation() {
        // Scale the button in X and Y
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2);
        scaleAnimation.setDuration(1000);
        return scaleAnimation;
    }
}
