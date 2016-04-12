package ur.disorderapp;

import android.media.MediaPlayer;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.telephony.TelephonyManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;
import com.firebase.client.Firebase;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.util.HashMap;

import ur.disorderapp.EnumValues.Feeling;
import ur.disorderapp.EnumValues.Location;
import ur.disorderapp.EnumValues.Situation;
import ur.disorderapp.EnumValues.TimePeriod;
import ur.disorderapp.model.Collection;
import ur.disorderapp.model.DataPiece;
import ur.disorderapp.model.FirebaseData;
import ur.disorderapp.model.SelfAssessmentData;


public class SelfAssessmentActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SlideFragment.OnDataPass, SlideFragment_submit.OnDataPass_submit {
    private final String TAG = "SelfAssessmentActivity";
    private ViewPager mPager;
    public static Collection sCollection;

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 7;

    private HashMap<Integer,String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);

        Log.d(TAG, "onCreate() called");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPager = (ViewPager) findViewById(R.id.view_pager);
        final MediaPlayer sound = MediaPlayer.create(SelfAssessmentActivity.this, R.raw.sample);

        //Initialize the Hashmap
        hashMap = new HashMap<>();

        /*
      The pager adapter, which provides the pages to the view pager widget.
     */
        PagerAdapter pagerAdapter = new viewpagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sound.start();
                Log.i(TAG, "FAB button clicked");
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Setting up progress bar
        sCollection = Collection.get(getApplicationContext());
        int progress = sCollection.checkProgress("sugar");
        View headerView = navigationView.getHeaderView(0);
        CircularProgressBar sugarProgress =
                (CircularProgressBar) headerView.findViewById(R.id.sugar_progress);
        // 2500ms = 2.5s
        int animationDuration = 5000;
        // Default duration = 1500ms
        sugarProgress.setProgressWithAnimation(progress, animationDuration);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (mPager.getCurrentItem() == 0)
            {
                // If the user is currently looking at the first page, allow the system to handle the
                // Back button. This calls finish() on this activity and pops the back stack.
                super.onBackPressed();
            } else {
                // Otherwise, select the previous step.
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.self_assessment, menu);
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
        if (id == R.id.action_settings)
        {
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

        }  else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public int pos;
    @Override
    public void onDataPass(DataPiece data)
    {
        //receive data from fragments
        int key = data.getKey();
        String value = data.getData_value();

        hashMap.put(key,value);
    }

    //submit data
    @Override
    public void onDataPass(boolean submit)
    {
        if (submit) {

            SelfAssessmentData data = new SelfAssessmentData(hashMap.get(0),
                    Integer.parseInt(hashMap.get(1)),
                    TimePeriod.valueOf(hashMap.get(2)),
                    Location.valueOf(hashMap.get(3)),
                    Situation.valueOf(hashMap.get(5)),
                    Feeling.valueOf(hashMap.get(4)),
                    0);

            //Save data to database
            sCollection.addSelfAssessmentData(data);

            stopService(new Intent(this, Timer_Notification_Service.class));
            startService(new Intent(this, Timer_Notification_Service.class));

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private class viewpagerAdapter extends FragmentStatePagerAdapter
    {
        public viewpagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            Log.i(TAG, "getItem() called, position = "+position);
            pos = position;
            return SlideFragment.newInstance(Integer.toString(position));

            if(position==6)
            {
                //return the new fragment
                SlideFragment_submit f = new SlideFragment_submit();
                return f;
            }

            //otherwise
            SlideFragment fragment = SlideFragment.newInstance(position);

            return fragment;
        }

        @Override
        public int getCount()
        {
            return NUM_PAGES;
        }
    }

    private class ZoomOutPageTransformer implements ViewPager.PageTransformer
    {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position)
        {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    @Override
    protected void onUserLeaveHint ()
    {
        super.onUserLeaveHint();
        this.finishAffinity();
    }
}
