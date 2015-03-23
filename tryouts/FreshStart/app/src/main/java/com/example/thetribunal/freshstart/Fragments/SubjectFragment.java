package com.example.thetribunal.freshstart.Fragments;

import com.example.thetribunal.freshstart.Activities.FirstActivity;
import com.example.thetribunal.freshstart.R;
import com.example.thetribunal.freshstart.View.SlidingTabLayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic sample which shows how to use {@link com.example.thetribunal.freshstart.View.SlidingTabLayout}
 * to display a custom {@link ViewPager} title strip which gives continuous feedback to the user
 * when scrolling.
 */
public class SubjectFragment extends Fragment {

    /**
     * This class represents a tab to be displayed by {@link ViewPager} and it's associated
     * {@link SlidingTabLayout}.
     */
    static class SamplePagerItem {
        private final int mPosition;
        private final CharSequence mTitle;
        private final int mIndicatorColor;
        private final int mDividerColor;

        SamplePagerItem(int position, CharSequence title, int indicatorColor, int dividerColor) {
            mPosition = position;
            mTitle = title;
            mIndicatorColor = indicatorColor;
            mDividerColor = dividerColor;
        }

        /**
         * @return A new {@link Fragment} to be displayed by a {@link ViewPager}
         * This is only for initial creation. This is saved after while that activity is completed.
         * Takes drawer position and tab number as input and returns a new fragment.
         */
        Fragment createFragment(int position, int tabNum) {
            if(tabNum == 0){ // News/Info/Description
                return SubjectNewsFragment.newInstance(position);
            }
            if(tabNum == 1){ // Learn tab
                return SubjectLearnFragment.newInstance(position);
            }
            return ContentFragment.newInstance(mPosition, mTitle, mIndicatorColor, mDividerColor);
        }

        /**
         * @return the title which represents this tab. In this sample this is used directly by
         * {@link android.support.v4.view.PagerAdapter#getPageTitle(int)}
         */
        CharSequence getTitle() {
            return mTitle;
        }

        /**
         * @return the color to be used for indicator on the {@link SlidingTabLayout}
         */
        int getIndicatorColor() {
            return mIndicatorColor;
        }

        /**
         * @return the color to be used for right divider on the {@link SlidingTabLayout}
         */
        int getDividerColor() {
            return mDividerColor;
        }

        int getmPostion(){
            return mPosition;
        }
    }

    static final String LOG_TAG = "SlidingTabsColorsFragment";
    private static final String POSITION = "param1";
    /**
     * A custom {@link ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link ViewPager} which will be used in conjunction with the {@link SlidingTabLayout} above.
     */
    private ViewPager mViewPager;
    // Keep the currently selected drawer item position for future use.
    private int mPosition;
    /**
     * List of {@link SamplePagerItem} which represent this sample's tabs.
     */
    private List<SamplePagerItem> mTabs = new ArrayList<SamplePagerItem>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position is Parameter 1.
     * @return A new instance of fragment CircuitsIntroFragment.
     */
    public static SubjectFragment newInstance(int position) {
        SubjectFragment fragment = new SubjectFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }
    public SubjectFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
        }
        // BEGIN_INCLUDE (populate_tabs)
        /**
         * Populate our tab list with tabs. Each item contains a title, indicator color and divider
         * color, which are used by {@link SlidingTabLayout}.
         */
        mTabs.add(new SamplePagerItem(
                mPosition, //Drawer item position
                getString(R.string.Item_1), // Title
                Color.BLUE, // Indicator color
                Color.GRAY // Divider color
        ));

        mTabs.add(new SamplePagerItem(
                mPosition,//Drawer item position
                getString(R.string.Item_2), // Title
                Color.RED, // Indicator color
                Color.GRAY // Divider color
        ));

        mTabs.add(new SamplePagerItem(
                mPosition,//Drawer item position
                getString(R.string.Item_3), // Title
                Color.YELLOW, // Indicator color
                Color.GRAY // Divider color
        ));

        mTabs.add(new SamplePagerItem(
                mPosition,//Drawer item position
                getString(R.string.Item_4), // Title
                Color.GREEN, // Indicator color
                Color.GRAY // Divider color
        ));
        // END_INCLUDE (populate_tabs)
    }

    /**
     * Inflates the {@link View} which will be displayed by this {@link Fragment}, from the app's
     * resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subject, container, false);
    }

    // BEGIN_INCLUDE (fragment_onviewcreated)
    /**
     * This is called after the {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} has finished.
     * Here we can pick out the {@link View}s we need to configure from the content view.
     *
     * We set the {@link ViewPager}'s adapter to be an instance of
     * {@link SampleFragmentPagerAdapter}. The {@link SlidingTabLayout} is then given the
     * {@link ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SampleFragmentPagerAdapter(getChildFragmentManager()));
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

        // BEGIN_INCLUDE (tab_colorizer)
        // Set a TabColorizer to customize the indicator and divider colors. Here we just retrieve
        // the tab at the position, and return it's set color
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return mTabs.get(position).getIndicatorColor();
            }

            @Override
            public int getDividerColor(int position) {
                return mTabs.get(position).getDividerColor();
            }

        });
        // END_INCLUDE (tab_colorizer)
        // END_INCLUDE (setup_slidingtablayout)
    }
    // END_INCLUDE (fragment_onviewcreated)

/*
* This is needed to attach the activity to the selected drawer item.
* Directly copied from SubjectNewsFragment.java.
* */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((FirstActivity) activity).onSectionAttached(
                getArguments().getInt(POSITION));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * The {@link FragmentPagerAdapter} used to display pages in this sample. The individual pages
     * are instances of {@link ContentFragment} which just display three lines of text. Each page is
     * created by the relevant {@link SamplePagerItem} for the requested position.
     * <p>
     * The important section of this class is the {@link #getPageTitle(int)} method which controls
     * what is displayed in the {@link SlidingTabLayout}.
     */
    class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

        SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return the {@link android.support.v4.app.Fragment} to be displayed at {@code position}.
         * <p>
         * Here we return the value returned from {@link SamplePagerItem#createFragment(int position,
         * int tabNum)}.
         */
        @Override
        public Fragment getItem(int i) {
            return mTabs.get(i).createFragment(mPosition, i);
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)
        /**
         * Return the title of the item at {@code position}. This is important as what this method
         * returns is what is displayed in the {@link SlidingTabLayout}.
         * <p>
         * Here we return the value returned from {@link SamplePagerItem#getTitle()}.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabs.get(position).getTitle();
        }
        // END_INCLUDE (pageradapter_getpagetitle)

    }

}