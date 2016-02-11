package ur.disorderapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by Lauren on 2/11/16.
 */
public class PageAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;

    public PageAdapter(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position){
        return this.fragments.get(position);
    }

    @Override
    public int getCount(){
        return this.fragments.size();
    }
}
