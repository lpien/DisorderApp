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

    public static final String TAG = "SlideFragment";

    Button btn_0, btn_1, btn_2;

    public SlideFragment()
    {
        // Required empty public constructor
    }

    public static SlideFragment newInstance(String text)
    {
        Log.i(TAG, "newInstance() called");
        //A Factory Method creating new instance
        SlideFragment fragment = new SlideFragment();
        Bundle bundle = new Bundle();
        //bundle.putString(KEY, text);
        bundle.putString(KEY, "texty");
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

        btn_0 = (Button) rootView.findViewById(R.id.frag_btn_0);
        btn_1 = (Button) rootView.findViewById(R.id.frag_btn_1);
        btn_2 = (Button) rootView.findViewById(R.id.frag_btn_2);

        String strArgs = getArguments().getString(KEY);

        setFragText(strArgs);

        /*String btn_text_0 = getArguments().getString(KEY_0);
        String btn_text_1 = getArguments().getString(KEY_1);
        String btn_text_2 = getArguments().getString(KEY_2);
        String btn_text_3 = getArguments().getString(KEY_3);

        Button btn_0 = (Button) rootView.findViewById(R.id.frag_btn_0);
        Button btn_1 = (Button) rootView.findViewById(R.id.frag_btn_1);
        Button btn_2 = (Button) rootView.findViewById(R.id.frag_btn_2);
        //Button btn_3 = (Button) rootView.findViewById(R.id.frag_btn_3);

        btn_0.setText(R.string.hello_blank_fragment);
        btn_1.setText(btn_text_1);
        btn_2.setText(btn_text_2);
        */

        //btn_3.setText(btn_text_3);

        //TextView textView = (TextView) rootView.findViewById(R.id.fragment_text);
        //textView.setText(text);





        return rootView;
    }

    public void setFragText(String position){
        Log.d(TAG, "setFragText() called");
        switch (position){
            case "0": position = "1";
                btn_0.setText("button1.a");
                btn_1.setText("button2.a");
                btn_2.setText("button3.a");
                break;
            case "1": position = "2";
                btn_0.setText("button1.b");
                btn_1.setText("button2.b");
                btn_2.setText("button3.b");
                break;
            default: position = "1";
        }
    }

}
