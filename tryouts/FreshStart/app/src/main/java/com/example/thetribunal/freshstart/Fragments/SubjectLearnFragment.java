package com.example.thetribunal.freshstart.Fragments;

import android.app.Activity;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;


import com.example.thetribunal.freshstart.R;
import com.example.thetribunal.freshstart.Content.LessonsContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link LessonMenuCallbacks}
 * interface.
 */
public class SubjectLearnFragment extends Fragment
        implements AbsListView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CUR_POSITION = "position";

    // TODO: Rename and change types of parameters
    public static int mPosition;

    private LessonMenuCallbacks mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;

    // TODO: Rename and change types of parameters
    public static SubjectLearnFragment newInstance(int position) {
        SubjectLearnFragment fragment = new SubjectLearnFragment();
        Bundle args = new Bundle();
        args.putInt(CUR_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SubjectLearnFragment() {
    }
    //Need to select the proper menu based on the position
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(CUR_POSITION);
        }
        // TODO: Change Adapter to display your content
        if(mPosition == 1) {
            mAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, LessonsContent.ITEMS_1);
        }
        if(mPosition == 2) {
            mAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, LessonsContent.ITEMS_2);
        }
        if(mPosition == 3) {
            mAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, LessonsContent.ITEMS_3);
        }
        if(mPosition == 4) {
            mAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, LessonsContent.ITEMS_4);
        }
        if(mPosition == 5) {
            mAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, LessonsContent.ITEMS_5);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn_list, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }
    /**
     * Sets the listener that should be notified of lesson list selection events.
     * @param listener the listener to notify.
     */
   /* public void setLessonMenuCallbacks(LessonMenuCallbacks listener) {
        mListener = listener;
    }*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (LessonMenuCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement LessonMenuCallbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            if(mPosition == 1) {
                mListener.onMenuItemSelected(LessonsContent.ITEMS_1.get(position).id,
                        LessonsContent.ITEMS_1.get(position).content);
            }
            if(mPosition == 2) {
                mListener.onMenuItemSelected(LessonsContent.ITEMS_2.get(position).id,
                        LessonsContent.ITEMS_2.get(position).content);
            }
            if(mPosition == 3) {
                mListener.onMenuItemSelected(LessonsContent.ITEMS_3.get(position).id,
                        LessonsContent.ITEMS_3.get(position).content);
            }
            if(mPosition == 4) {
                mListener.onMenuItemSelected(LessonsContent.ITEMS_4.get(position).id,
                        LessonsContent.ITEMS_4.get(position).content);
            }
            if(mPosition == 5) {
                mListener.onMenuItemSelected(LessonsContent.ITEMS_5.get(position).id,
                        LessonsContent.ITEMS_5.get(position).content);
            }
        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
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

    public static void setmPosition(int position){
        mPosition = position;
    }

    public interface LessonMenuCallbacks {
        // TODO: Update argument type and name
        public void onMenuItemSelected(String id, String title);
    }

}
