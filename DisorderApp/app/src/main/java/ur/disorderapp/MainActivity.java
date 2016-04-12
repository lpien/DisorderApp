package ur.disorderapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import ur.disorderapp.EnumValues.GoalStatus;
import ur.disorderapp.model.Collection;

/*
* The Main / Home page should be like a dashboard-like page that shows the user
* progress and able to navigate to various programs, either to start a new one
* or continue an old one
* */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    private final String TAG = "MainActivity.class";
    private Collection sCollection;
    SoundPool mySound;
    int soundId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate() called");

        final MediaPlayer sound = MediaPlayer.create(MainActivity.this, R.raw.sample);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize the database collection
        sCollection = Collection.get(this.getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
<<<<<<< HEAD
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sound.start();
                Log.i(TAG, "FAB button clicked");

            }
        });
=======
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
>>>>>>> database

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        //Setting up progress bar
        int progress = sCollection.checkProgress("sugar");
        View headerView = null;
        if (navigationView != null) {
            headerView = navigationView.getHeaderView(0);
        }
        CircularProgressBar sugarProgress = null;
        if (headerView != null) {
            sugarProgress = (CircularProgressBar) headerView.findViewById(R.id.sugar_progress);
        }
        // 2500ms = 2.5s
        int animationDuration = 5000;
        // Default duration = 1500ms
        if (sugarProgress != null) {
            sugarProgress.setProgressWithAnimation(progress, animationDuration);
        }


        //Sugar Program
        Button sugarModule = (Button) findViewById(R.id.main_btn_sugar);
        assert sugarModule != null;
        sugarModule.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                /*querying from database first to check the program status,
                 if it is the first time the user start the program,
                 navigate to self-monitoring first to finish the survey
                 (check goal status)*/

                GoalStatus s = sCollection.checkStatus("sugar");
                Intent i;
                //Start a new one
                if(s==GoalStatus.UNACTIVATED || s==GoalStatus.SELFMONITORING)
                {
                    i = new Intent(getApplicationContext(), PreSelfMonitorActivity.class);
                }
                //Or Continue
                else {
                    i = new Intent(getApplicationContext(), SugarProgramActivity.class);
                }
                startActivity(i);
            }
        });

        //If there is no service running right now, start the service
        if (!isMyServiceRunning(DataSendingService.class)){
            Intent i = new Intent(this,DataSendingService.class);
            startService(i);
        }
    }

    //check running service
    private boolean isMyServiceRunning(Class<?> serviceClass)
    {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public void playSound(View view){
        mySound.play(soundId, 1, 1, 1, 0, 1);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START))
            {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sugar_program, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    protected void onUserLeaveHint ()
    {
        super.onUserLeaveHint();
        this.finishAffinity();
    }
}
