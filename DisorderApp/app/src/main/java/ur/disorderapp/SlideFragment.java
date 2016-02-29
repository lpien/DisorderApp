package ur.disorderapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SlideFragment extends Fragment
{
    public static final String KEY = "key";
    public static final String KEY_0 = "0";
    public static final String KEY_1 = "1";
    public static final String KEY_2 = "2";
    public static final String KEY_3 = "3";

    public static int pos;

    private static final String TAG = "SlideFragment";


    public SlideFragment()
    {
        // Required empty public constructor
    }

    public static SlideFragment newInstance(String text)
    {
        //A Factory Method creating new instance
        Log.i(TAG, "newInstance() called");
        SlideFragment fragment = new SlideFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, text);
        pos = Integer.parseInt(text);
        fragment.setArguments(bundle);
        return fragment;
    }

    /*public static SlideFragment newFragment(String [] text)
    {
        Log.i(TAG, "newFragment() called");
        SlideFragment f = new SlideFragment();
        Bundle args = new Bundle();
        args.putString(KEY_0, text[0]);
        args.putString(KEY_1, text[1]);
        args.putString(KEY_2, text[2]);
        args.putString(KEY_3, text[3]);
        f.setArguments(args);
        return f;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_slide, container, false);

        Log.i(TAG, "onCreateView() called");

        TextView titleText = (TextView) rootView.findViewById(R.id.title_text_view);
        Button btn_0 = (Button) rootView.findViewById(R.id.frag_btn_0);
        Button btn_1 = (Button) rootView.findViewById(R.id.frag_btn_1);
        Button btn_2 = (Button) rootView.findViewById(R.id.frag_btn_2);

        if(pos == 0){
            titleText.setText("Which of these did you eat?");
            btn_0.setText("A sugery drink");
            btn_1.setText("A pastry");
            btn_2.setText("Other");
        }
        else if(pos == 1){
            titleText.setText("How many did you consume?");
            btn_0.setText("1");
            btn_1.setText("2");
            btn_2.setText("3");
        }
        else if(pos == 2){
            titleText.setText("When did you eat it?");
            btn_0.setText("Morning");
            btn_1.setText("Afternoon");
            btn_2.setText("Evening");
        }
        else if(pos == 3){
            titleText.setText("Where did you eat it?");
            btn_0.setText("Home");
            btn_1.setText("Work");
            btn_2.setText("On the go");
        }
        else if(pos == 4){
            titleText.setText("What did you eat it with?");
            btn_0.setText("A meal");
            btn_1.setText("Nothing");
            btn_2.setText("Other");
        }
        else if(pos == 5){
            titleText.setText("How were you feeling?");
            btn_0.setText("Hungry");
            btn_1.setText("Thirsty");
            btn_2.setText("Other");
        }

        return rootView;
    }

}
