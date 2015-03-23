package com.example.thetribunal.freshstart.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.thetribunal.freshstart.Fragments.SubjectLearnFragment;
import com.example.thetribunal.freshstart.MobileDev.MotionSensors;
import com.example.thetribunal.freshstart.R;

/*
    ActionBarActivity is a subclass of FragmentActivity thus
    allows the use of the Action Bar and Fragment activities.
*/
public class LessonsActivity extends ActionBarActivity
            implements SubjectLearnFragment.LessonMenuCallbacks{

    // Gets the Current position of the drawer selected and saves it here.
    public String CURRENT_POS = "LessonsActivity.EXTRA_MESSAGE";
    public final static String EXTRA_MESSAGE = "LessonsActivity.MESSAGE";

    public int mPosition = 0;
    // The fragment where lesson menu items are displayed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
            Receive the current position of the drawer from first activity and set it
            as a global variable.
        */
        Intent intent =  getIntent();
        CURRENT_POS = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE);
        mPosition = Integer.parseInt(CURRENT_POS);
        /*
            Keep the positions saved in the lessons fragment updated.
        */
        SubjectLearnFragment.setmPosition(mPosition);
        setContentView(R.layout.activity_lesson);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lessons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onMenuItemSelected(String id, String title){
    /*
    * The user selected from the list of items in the Circuits fragment.
    * Deal with what happens next here.
    * */
        if(id == "3.2"){
            Intent lesson = new Intent(this, MotionSensors.class);
            lesson.putExtra(EXTRA_MESSAGE, title);
            startActivity(lesson);
        }else {
            Intent lesson = new Intent(this, LessonSelectedActivity.class);
            lesson.putExtra(EXTRA_MESSAGE, title);
            startActivity(lesson);
        }
     }
}
