package com.google.android.devbytes.viewanimations;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by aleks on 17.06.13.
 */
public class TranslateFragment extends AnimationFragment {

    @Override
    protected int getViewId() {
        return R.id.translateButton;
    }

    @Override
    protected int getAnimId() {
        return R.anim.translate_anim;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_translate_anim;
    }

    @Override
    protected final Animation createAnimation() {
        // Move the button over and then back
        final TranslateAnimation translateAnimation =
                new TranslateAnimation(Animation.ABSOLUTE, 0,
                        Animation.RELATIVE_TO_PARENT, 1,
                        Animation.ABSOLUTE, 0,
                        Animation.ABSOLUTE, 100);
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }

}
