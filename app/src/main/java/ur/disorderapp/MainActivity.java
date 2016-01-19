package ur.disorderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerList = (ListView)findViewById(R.id.left_drawer);
        addDrawerItems();
    }

    //Helper method to create itemized list
    private void addDrawerItems(){
        String[] a = {"Module 1", "Module 2", "Module 3", "Module 4"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, a);
        mDrawerList.setAdapter(mAdapter);
    }
}
