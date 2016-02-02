package ur.disorderapp;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SelfAssessmentActivity extends FragmentActivity {

    SelfAssessAdapter mPageAdapter;
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assessment);

        //List<Fragment>fragments = getFragments();
        //mPageAdapter = new SelfAssessAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager)findViewById(R.id.view_pager);
        adapterViewPager = new SelfAssessAdapter(getSupportFragmentManager());
        pager.setAdapter(adapterViewPager);
        //pager.setAdapter(new SelfAssessAdapter(getSupportFragmentManager()));
    }

    // Adapter
    /*private class SelfAssessAdapter extends FragmentPagerAdapter{
        public SelfAssessAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int pos){
            switch(pos){
                case 0:
                    return Frag1.newInstance(0, "Instance1");
                case 1:
                    return Frag1.newInstance(1, "Instance2");
                case 2:
                    return Frag1.newInstance(2, "Instance3");
                default:
                    return null;
            }
        }

        @Override
        public int getCount(){
            return 3;
        }
    }*/
}
