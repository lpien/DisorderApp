package ur.disorderapp;


import android.os.Bundle;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends android.support.v4.app.Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    Button b1, b2, b3, b4;

    public MyFragment() {
        // Required empty public constructor
    }

    public static final MyFragment newInstance(String message){
        MyFragment f = new MyFragment();
        Bundle b1 = new Bundle(1);
        b1.putString(EXTRA_MESSAGE, message);
        f.setArguments(b1);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        b1 = (Button)v.findViewById(R.id.self_drink);
        b2 = (Button)v.findViewById(R.id.self_food);
        b3 = (Button)v.findViewById(R.id.self_pastry);
        b4 = (Button)v.findViewById(R.id.self_tea);
        //TextView messageTextView = (TextView)v.findViewById(R.id.textView);
        //messageTextView.setText(message);
        return v;
    }

}
