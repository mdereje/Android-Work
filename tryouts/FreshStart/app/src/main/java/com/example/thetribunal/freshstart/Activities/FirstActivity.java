package com.example.thetribunal.freshstart.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.example.thetribunal.freshstart.Fragments.SubjectFragment;
import com.example.thetribunal.freshstart.Fragments.SubjectLearnFragment;
import com.example.thetribunal.freshstart.Fragments.SubjectNewsFragment;
import com.example.thetribunal.freshstart.Fragments.NavigationDrawerFragment;
import com.example.thetribunal.freshstart.MobileDev.MotionSensors;
import com.example.thetribunal.freshstart.R;


public class FirstActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        SubjectNewsFragment.OnIntroFragmentInteractionListener,
        SubjectLearnFragment.LessonMenuCallbacks{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     * EXTRA_MESSAGE is used to pass information of current drawer to other activites.
     */
    public final static String EXTRA_MESSAGE = "FirstActivity.EXTRA_MESSAGE";
    public final static String TITLE_MESSAGE = "FirstActivity.TITLE_MESSAGE";

    private NavigationDrawerFragment mNavigationDrawerFragment;
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    //mdereje
   @Override
   public void onNavigationDrawerItemSelected(int position) {
       // Start activity based on selected item on drawer
       FragmentManager fragmentManager = getSupportFragmentManager();
       currentPosition = position + 1;
       //TODO: Get the SubjectNewsFragment into the ViewPager adapter.
       /*Below uses newInstance method to pass in the current position of the drawer selected*/
       fragmentManager.beginTransaction()
               .replace(R.id.container, SubjectFragment.newInstance(currentPosition))
               .commit();
   }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.first, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    /*
        Handle action bar item clicks here. The action bar will
        automatically handle clicks on the Home/Up button, so long
        as you specify a parent activity in AndroidManifest.xml.
    */
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
* Checks which instance of course intro fragment the user pressed the start learning button.
* */
    public void onFragmentButton(View view){

        Intent lesson = new Intent(this, LessonsActivity.class);
        String cPos = ""+ currentPosition;
        lesson.putExtra(EXTRA_MESSAGE, cPos);
        startActivity(lesson);

    }
/*
* Items selected under the "Learn" tab are implemented here.
* */
    public void onMenuItemSelected(String id, String title){
    /*
    * The user selected from the list of items SubjectLearnFragment.
    * Deal with what happens next here.
    * */
        if(id == "3.2"){
            Intent lesson = new Intent(this, MotionSensors.class);
            lesson.putExtra(TITLE_MESSAGE, title.substring(3,title.length()));
            startActivity(lesson);
        }else {
            Intent lesson = new Intent(this, LessonSelectedActivity.class);
            lesson.putExtra(TITLE_MESSAGE, title.substring(3,title.length()));
            startActivity(lesson);
        }
    }
}
