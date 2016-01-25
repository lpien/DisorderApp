package ur.disorderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private Button mSugarModule;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerList = (ListView)findViewById(R.id.left_drawer);
        addDrawerItems();

        mSugarModule = (Button)findViewById(R.id.main_btn_sugar);
        mSugarModule.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), SugarProgramActivity.class);
                startActivity(i);
            }
        });
    }

    //TODO: MAKE DRAWER ITEMS CLICKABLE BUTTONS
    //Helper method to create itemized list
    private void addDrawerItems()
    {
        String[] a = {"Module 1", "Module 2", "Module 3", "Module 4"};
        mAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, a);
        mDrawerList.setAdapter(mAdapter);
    }
}
