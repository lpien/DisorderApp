package ur.disorderapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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
import ur.disorderapp.model.DataPiece;


public class SlideFragment extends Fragment
{
    //For sending data out
    public interface OnDataPass {
        public void onDataPass(DataPiece data);
    }

    OnDataPass dataPasser;

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        try {
            dataPasser = (OnDataPass) a;
        } catch (ClassCastException e) {
            throw new ClassCastException(a.toString() +
                    " must implement OnArticleSelectedListener");
        }
    }

    public static final String KEY = "key";
<<<<<<< HEAD

    public static final String TAG = "SlideFragment";

    Button btn_0, btn_1, btn_2;
=======
>>>>>>> database

    public SlideFragment()
    {
        // Required empty public constructor
    }

    public static SlideFragment newInstance(int position)
    {
        //A Factory Method creating new instance
        Log.i(TAG, "newInstance() called");
        SlideFragment fragment = new SlideFragment();
        Bundle bundle = new Bundle();
<<<<<<< HEAD
        int pos = Integer.parseInt(text);
        bundle.putInt(KEY, pos);
=======
        bundle.putInt(KEY, position);
>>>>>>> database
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
<<<<<<< HEAD
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
=======

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_rootview, container, false);

        Bundle args = getArguments();
        final int position = args.getInt(KEY);

        final Button btn_0 = (Button) rootView.findViewById(R.id.frag_btn_0);
        final Button btn_1 = (Button) rootView.findViewById(R.id.frag_btn_1);
        final Button btn_2 = (Button) rootView.findViewById(R.id.frag_btn_2);
        final Button btn_3 = (Button) rootView.findViewById(R.id.frag_btn_3);

        String text_0 = null, text_1 = null, text_2 = null, text_3 = null;

        //Set the content of fragments
        if (position==0){
            //Food Name
            text_0 = "Sugary Drinks";
            text_1 = "Donuts";
            text_2 = "Soda";
            text_3 = "Other";
        } else if (position==1) {
            //How many
            text_0 = "1";
            text_1 = "2";
            text_2 = "3";
            text_3 = "4";
        } else if (position==2) {
            //When?
            text_0 = "MORNING";
            text_1 = "NOON";
            text_2 = "NIGHT";
            text_3 = "OTHER";
        } else if (position==3) {
            //WHERE?
            text_0 = "HOME";
            text_1 = "WORK";
            text_2 = "ON_THE_GO";
            text_3 = "OTHER";
        } else if (position==4) {
            //Feeling?
            text_0 = "HUNGARY";
            text_1 = "THIRSTY";
            text_2 = "EXHAUSTED";
            text_3 = "OTHER";
        } else if (position==5) {
            //Situation?
            text_0 = "MEAL";
            text_1 = "FAMILY_MEAL";
            text_2 = "WORK_MEAL";
            text_3 = "OTHER";
        }
//        else if (position==6) {
//            LayoutInflater vi = (LayoutInflater) getContext()
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View v = vi.inflate(R.layout.fragment_submit, null);
//
//            rootView.addView(v, 0,
//                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
//                            ViewGroup.LayoutParams.FILL_PARENT));
//
//            Button btn = (Button) v.findViewById(R.id.submit_ok);
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//
//            return rootView;
//
//        }

        btn_0.setText(text_0);
        btn_1.setText(text_1);
        btn_2.setText(text_2);
        btn_3.setText(text_3);

        //onClick Listeners
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(btn_0);
                deselect(btn_1);
                deselect(btn_2);
                deselect(btn_3);
                String data = (String)btn_0.getText();
                DataPiece dataPiece = new DataPiece(position,data);
                dataPasser.onDataPass(dataPiece);
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deselect(btn_0);
                select(btn_1);
                deselect(btn_2);
                deselect(btn_3);
                String data = (String)btn_1.getText();
                DataPiece dataPiece = new DataPiece(position,data);
                dataPasser.onDataPass(dataPiece);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deselect(btn_0);
                deselect(btn_1);
                select(btn_2);
                deselect(btn_3);
                String data = (String)btn_2.getText();
                DataPiece dataPiece = new DataPiece(position,data);
                dataPasser.onDataPass(dataPiece);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deselect(btn_0);
                deselect(btn_1);
                deselect(btn_2);
                select(btn_3);
                String data = (String)btn_3.getText();
                DataPiece dataPiece = new DataPiece(position,data);
                dataPasser.onDataPass(dataPiece);
            }
        });


        return rootView;
    }

    private void select(Button b)
    {
        b.setBackgroundColor(Color.RED);
    }

    private void deselect(Button b)
    {
        b.setBackgroundResource(android.R.drawable.btn_default);
    }

}
