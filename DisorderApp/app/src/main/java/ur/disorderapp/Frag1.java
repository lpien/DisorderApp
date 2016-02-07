package ur.disorderapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    private String title;
    private int page;

    public Frag1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.Frag1, container, false);
        //TextView mMessage = (TextView)v.findViewById(R.id.textViewTest);
        //mMessage.setText(getArguments().getString("msg"));
        return v;
    }

    public static Frag1 newInstance(int page, String text){
        Frag1 f = new Frag1();
        Bundle b = new Bundle();
        b.putInt("someInt", page);
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

}
