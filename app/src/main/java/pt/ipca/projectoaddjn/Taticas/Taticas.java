package pt.ipca.projectoaddjn.Taticas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.ipca.projectoaddjn.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Taticas extends Fragment {

    private View rootView;
    private CanvasView canvasView;

    public Taticas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        canvasView = (CanvasView) rootView.findViewById(R.id.canvas);

        return rootView;



    }

    public void clearCanvas(View v) {
        canvasView.clearCanvas();
    }
}
