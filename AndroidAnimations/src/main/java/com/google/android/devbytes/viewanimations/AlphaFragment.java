package com.google.android.devbytes.viewanimations;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by aleks on 17.06.13.
 */
public class AlphaFragment extends AnimationFragment {

    @Override
    protected int getViewId() {
        return R.id.alphaButton;
    }

    @Override
    protected int getAnimId() {
        return R.anim.alpha_anim;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_alpha_anim;
    }

    @Override
    protected final Animation createAnimation() {
        // Fade the button out and back in
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(1000);
        return alphaAnimation;
    }
}