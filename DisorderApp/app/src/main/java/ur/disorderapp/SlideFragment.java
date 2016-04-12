package ur.disorderapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class SlideFragment extends Fragment
{
    public static final String KEY = "key";

    public static final String TAG = "SlideFragment";

    public static final String TAG = "SlideFragment";

    Button btn_0, btn_1, btn_2;

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
        int pos = Integer.parseInt(text);
        bundle.putInt(KEY, pos);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_slide, container, false);

        Log.i(TAG, "onCreateView() called");

        Bundle args = getArguments();
        int position = args.getInt(KEY);

        TextView titleText = (TextView) rootView.findViewById(R.id.title_text_view);
        ImageButton btn_0 = (ImageButton) rootView.findViewById(R.id.frag_btn_0);
        ImageButton btn_1 = (ImageButton) rootView.findViewById(R.id.frag_btn_1);
        ImageButton btn_2 = (ImageButton) rootView.findViewById(R.id.frag_btn_2);
        Log.i(TAG, "onCreateView() [DEBUG]");

        if(position == 0){
            Log.i(TAG, "position 0");
            titleText.setText("Which of these did you eat?");
            btn_0.setImageResource(R.mipmap.coke);
            btn_1.setImageResource(R.mipmap.donut);
            btn_2.setImageResource(R.mipmap.qmark);
            /*btn_0.setText("A sugary drink");
            btn_1.setText("A pastry");
            btn_2.setText("Other");*/
        }
        if(position == 1){
            Log.i(TAG, "position 1 [DEBUG]");
            titleText.setText("How many did you consume?");
            Log.i(TAG, "position 1 [DEBUG 1]");
            btn_0.setImageResource(R.mipmap.oneimg);
            Log.i(TAG, "position 1 [DEBUG 2]");
            btn_1.setImageResource(R.mipmap.twoimg);
            Log.i(TAG, "position 1 [DEBUG 3]");
            btn_2.setImageResource(R.mipmap.threeimg);
            Log.i(TAG, "position 1 [DEBUG 4]");
        }
        if(position == 2){
            Log.i(TAG, "position 2 [DEBUG]");
            titleText.setText("When did you consume it?");
            btn_0.setImageResource(R.mipmap.morning);
            btn_1.setImageResource(R.mipmap.afternoon);
            btn_2.setImageResource(R.mipmap.night);
            /*btn_0.setImageResource("A sugery drink");
            btn_1.setText("A pastry");
            btn_2.setText("Other");*/
        }
        if(position == 3){
            Log.i(TAG, "position 3 [DEBUG]");
            titleText.setText("Where did you eat it?");
            btn_0.setImageResource(R.mipmap.home);
            btn_1.setImageResource(R.mipmap.work);
            btn_2.setImageResource(R.mipmap.truck);
           /* btn_0.setText("Home");
            btn_1.setText("Work");
            btn_2.setText("On the go");*/
        }
        if(position == 4){
            Log.i(TAG, "position 4 [DEBUG]");
            titleText.setText("What did you eat it with?");
            btn_0.setImageResource(R.mipmap.meal);
            btn_1.setImageResource(R.mipmap.other);
            btn_2.setImageResource(R.mipmap.other);
            /*btn_0.setText("A meal");
            btn_1.setText("Nothing");
            btn_2.setText("Other");*/
        }
        if(position == 5){
            Log.i(TAG, "position 5 [DEBUG]");
            titleText.setText("How were you feeling?");
            btn_0.setImageResource(R.mipmap.hungry);
            btn_1.setImageResource(R.mipmap.thirsty);
            btn_2.setImageResource(R.mipmap.other);
            /*btn_0.setText("Hungry");
            btn_1.setText("Thirsty");
            btn_2.setText("Other");*/
        }

        return rootView;
    }

}
