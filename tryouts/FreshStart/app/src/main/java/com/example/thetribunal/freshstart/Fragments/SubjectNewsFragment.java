package com.example.thetribunal.freshstart.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;


import com.example.thetribunal.freshstart.Activities.FirstActivity;
import com.example.thetribunal.freshstart.R;
import com.example.thetribunal.freshstart.Content.WebViewDisplay;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubjectNewsFragment.OnIntroFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubjectNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubjectNewsFragment extends Fragment {

    private static final String POSITION = "param1";

    private int mPosition;

    //Button interaction with fragment.
    private OnIntroFragmentInteractionListener mButtonListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position is Parameter 1.
     * @return A new instance of fragment CircuitsIntroFragment.
     */
    public static SubjectNewsFragment newInstance(int position) {
        SubjectNewsFragment fragment = new SubjectNewsFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    public SubjectNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
        }
    }
    /*
    * Editing material inside the fragment XML require the layout to be inflated first.
    * */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scrollView =  (ScrollView)inflater.inflate(R.layout.fragment_subject_news,
                                    container, false);
        //Change the title and the button according to the lesson.
        TextView title = (TextView) scrollView.findViewById(R.id.intro_title);
        Button start = (Button) scrollView.findViewById(R.id.start_button);

        title.setText(getString(R.string.lessons_intro_title) + " " + getTitle(mPosition) + "!");
        start.setText(getString(R.string.intro_start_button) + " " + getTitle(mPosition) + " now!");
        //display information from a website.
        WebView myWebView = (WebView) scrollView.findViewById(R.id.intro_WebView);
        myWebView.loadUrl(WebViewDisplay.returnURL(mPosition));
        myWebView.setWebViewClient(new WebViewClient());//links clicked replace current webview.

        //button on click listener for going into the lessons.
        start.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onStartPressed(v);
            }
        });

        return scrollView;
    }
    //start learning button is pressed.
    // TODO: Rename method update argument and hook method into UI event
    public void onStartPressed(View view) {
        if (mButtonListener != null) {
            mButtonListener.onFragmentButton(view);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((FirstActivity) activity).onSectionAttached(
                getArguments().getInt(POSITION));
        try {
            mButtonListener = (OnIntroFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnIntroFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mButtonListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnIntroFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentButton(View view);
    }

    /*
     * Change the intro message depending on which lesson is selected from the drawer.
     */
    public String getTitle(int position){
        String course = "";
        switch (position) {
            case 1:
                course = getString(R.string.title_section1);
                break;
            case 2:
                course = getString(R.string.title_section2);
                break;
            case 3:
                course = getString(R.string.title_section3);
                break;
            case 4:
                course = getString(R.string.title_section4);
                break;
            case 5:
                course = getString(R.string.title_section5);
                break;
        }
        return course;
    }

}
