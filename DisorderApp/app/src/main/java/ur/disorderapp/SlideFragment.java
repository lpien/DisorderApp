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

    public static final String TAG = "SlideFragment";

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
        //int position = Integer.parseInt(text);
        int pos = Integer.parseInt(text);
        bundle.putInt(KEY, pos);
        //bundle.putString(KEY, text);

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
        Button btn_0 = (Button) rootView.findViewById(R.id.frag_btn_0);
        Button btn_1 = (Button) rootView.findViewById(R.id.frag_btn_1);
        Button btn_2 = (Button) rootView.findViewById(R.id.frag_btn_2);

        //Button btn_3 = (Button) rootView.findViewById(R.id.frag_btn_3);



        //TextView textView = (TextView) rootView.findViewById(R.id.fragment_text);
        //textView.setText(text);


        if(position == 0){
            titleText.setText("Which of these did you eat?");
<<<<<<< HEAD
            btn_0.setImageResource(R.drawable.cocacola);
            btn_1.setImageResource(R.drawable.other);
            btn_2.setImageResource(R.drawable.other);
            /*btn_0.setText("A sugery drink");
            btn_0.setBackgroundResource(R.drawable.cocacola);
            btn_1.setText("A pastry");
            btn_2.setText("Other");*/
        }
        else if(position == 1){
            titleText.setText("Test");
            btn_0.setImageResource(R.drawable.two);
            btn_1.setImageResource(R.drawable.two);
            btn_2.setImageResource(R.drawable.three);
        }
        /*else if(position == 1){
            titleText.setText("How many did you consume?");
            //btn_0.setImageResource(R.drawable.oneiconimg);
            btn_0.setImageResource(R.drawable.two);
            btn_1.setImageResource(R.drawable.two);
            btn_2.setImageResource(R.drawable.three);
        }*/
        else if(position == 2){
            btn_0.setImageResource(R.mipmap.coke);
            btn_1.setImageResource(R.mipmap.donut);
            btn_2.setImageResource(R.mipmap.coke);
            /*btn_0.setImageResource("A sugery drink");
=======
            btn_0.setText("A sugery drink");
>>>>>>> parent of f5e3784... inserted images
            btn_1.setText("A pastry");
            btn_2.setText("Other");
        }
        else if(position == 1){
            titleText.setText("How many did you consume?");
            btn_0.setText("1");
            btn_1.setText("2");
            btn_2.setText("3");
        }
        else if(position == 2){
            titleText.setText("When did you eat it?");
            btn_0.setText("Morning");
            btn_1.setText("Afternoon");
            btn_2.setText("Evening");
        }
        else if(position == 3){
            titleText.setText("Where did you eat it?");
<<<<<<< HEAD
            btn_0.setImageResource(R.drawable.home);
            btn_1.setImageResource(R.drawable.work);
            btn_2.setImageResource(R.drawable.go);
           /* btn_0.setText("Home");
=======
            btn_0.setText("Home");
>>>>>>> parent of f5e3784... inserted images
            btn_1.setText("Work");
            btn_2.setText("On the go");
        }
        else if(position == 4){
            titleText.setText("What did you eat it with?");
<<<<<<< HEAD
            btn_0.setImageResource(R.drawable.meal);
            btn_1.setImageResource(R.drawable.other);
            btn_2.setImageResource(R.drawable.other);
            /*btn_0.setText("A meal");
=======
            btn_0.setText("A meal");
>>>>>>> parent of f5e3784... inserted images
            btn_1.setText("Nothing");
            btn_2.setText("Other");
        }
        else if(position == 5){
            titleText.setText("How were you feeling?");
<<<<<<< HEAD
            btn_0.setImageResource(R.drawable.hungry);
            btn_1.setImageResource(R.drawable.thirsty);
            btn_2.setImageResource(R.drawable.notsure);
            /*btn_0.setText("Hungry");
=======
            btn_0.setText("Hungry");
>>>>>>> parent of f5e3784... inserted images
            btn_1.setText("Thirsty");
            btn_2.setText("Other");
        }

        return rootView;
    }

}
