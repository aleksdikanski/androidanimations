package com.google.android.devbytes.viewanimations;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * Created by aleks on 17.06.13.
 */
public class RotateFragment extends AnimationFragment {

    @Override
    protected int getViewId() {
        return R.id.rotateButton;
    }

    @Override
    protected int getAnimId() {
        return R.anim.rotate_anim;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_rotate_anim;
    }

    @Override
    protected final Animation createAnimation() {
        // Spin the button around in a full circle
        final RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, .5F,
                Animation.RELATIVE_TO_SELF, .5F);
        rotateAnimation.setDuration(1000);
        return rotateAnimation;
    }
}
