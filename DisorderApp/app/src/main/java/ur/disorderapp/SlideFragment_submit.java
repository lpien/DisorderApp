package ur.disorderapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ur.disorderapp.model.DataPiece;


/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFragment_submit extends Fragment
{

    public interface OnDataPass_submit {
        public void onDataPass(boolean submit);
    }

    OnDataPass_submit dataPasser;

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        try {
            dataPasser = (OnDataPass_submit) a;
        } catch (ClassCastException e) {
            throw new ClassCastException(a.toString() +
                    " must implement OnArticleSelectedListener");
        }
    }

    public SlideFragment_submit()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_submit, container, false);

        Button b = (Button) view.findViewById(R.id.submit_ok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataPasser.onDataPass(true);
            }
        });



        return view;
    }

}
