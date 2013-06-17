package com.google.android.devbytes.viewanimations;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

/**
 * Created by aleks on 17.06.13.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public abstract class AnimationFragment extends Fragment {


    protected abstract int getViewId();

    protected abstract int getAnimId();

    protected abstract Animation createAnimation();

    protected abstract int getLayout();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = (Button) view.findViewById(getViewId());
        if (button == null) {
            getActivity().findViewById(getViewId());
        }
        bindAnimation(button, view.getContext(), createAnimation(), getAnimId());

    }

    private void bindAnimation(View view, final Context cxt, final Animation animation, final int animationID) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the Checkbox is checked, load the animation from the given resource id
                // instead of using the passed-in animation parameter. See the XML files
                // for the details on those animation declarations.
                view.startAnimation(
                        //mCheckBox.isChecked() ? AnimationUtils.loadAnimation(cxt, animationID) :
                        animation);
            }
        });
    }
}
