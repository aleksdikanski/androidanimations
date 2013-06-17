package com.google.android.devbytes.viewanimations;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;

/**
 * This example shows how to use pre-3.0 view Animation classes to create various animated UI
 * effects. See also the demo PropertyAnimations, which shows how this is done using the new
 * ObjectAnimator API introduced in Android 3.0.
 * <p/>
 * Watch the associated video for this demo on the DevBytes channel of developer.android.com
 * or on YouTube at https://www.youtube.com/watch?v=_UWXqFBF86U.
 */
public class ViewAnimationsActivity extends Activity {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Notice the setContentView() is not used, because we use the root
        // android.R.id.content as the container for each fragment
        //setContentView(R.layout.activity_view_animations);

        // setup action bar for tabs
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab tab = actionBar.newTab().setText(R.string.alpha).setTabListener(new TabListener<AlphaFragment>(this, "alpha", AlphaFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText(R.string.translate).setTabListener(new TabListener<TranslateFragment>(this, "translate", TranslateFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText(R.string.rotate).setTabListener(new TabListener<RotateFragment>(this, "rotate", RotateFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText(R.string.scale).setTabListener(new TabListener<ScaleFragment>(this, "scale", ScaleFragment.class));
        actionBar.addTab(tab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_animations, menu);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static class TabListener<T extends Fragment> implements ActionBar.TabListener {

        private Fragment mFragment;
        private final Activity mActivity;
        private final String mTag;
        private final Class<T> mClass;

        public TabListener(Activity activity, String tag, Class<T> aClass) {
            mActivity = activity;
            mTag = tag;
            mClass = aClass;
        }


        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            // Check if the fragment is already initialized
            if (mFragment == null) {
                // if not, instantiate and add it to the activity
                mFragment = Fragment.instantiate(mActivity, mClass.getName());
                fragmentTransaction.add(android.R.id.content, mFragment, mTag);
            } else {
                // if it exists, simply attach it in order to show it
                fragmentTransaction.attach(mFragment);
            }
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            if (mFragment != null) {
                // Detach the fragment, because another one is being attached
                fragmentTransaction.detach(mFragment);
            }
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            // User selected the already selected tab. Usually do nothing
        }
    }
}
