package ur.disorderapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauren on 2/2/16.
 */
public class SelfAssessAdapter extends FragmentPagerAdapter {

    private List<Frag1> fragments;

    public SelfAssessAdapter(FragmentManager fm){
        super(fm);
        this.fragments = new ArrayList<>();
        fragments.add(new Frag1());
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount(){
        return fragments.size();
    }
}
