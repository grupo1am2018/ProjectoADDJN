package pt.ipca.projectoaddjn.plantel;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import pt.ipca.projectoaddjn.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlantelFragment extends Fragment {

    private View rootView;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    float dX, dY;
    View view;
    private GestureDetector gestureDetector;
    ArrayList<ImageView> jogadores = new ArrayList<ImageView>();
    ArrayList<FormacaoPlantel> formacao = new ArrayList<FormacaoPlantel>();
    RelativeLayout relativeLayout;

    private OnFragmentInteractionListener mListener;

    public PlantelFragment() {
        // Required empty public constructor
    }

    public static PlantelFragment newInstance() {
        PlantelFragment fragment = new PlantelFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    View.OnTouchListener motionEvent = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (gestureDetector.onTouchEvent(event)) {
                return true;
            } else {
                switch (event.getActionMasked()) {

                    case MotionEvent.ACTION_DOWN:

                        dX = v.getX() - event.getRawX();
                        dY = v.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:

                        v.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_plantel, container, false);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.bfllcampo);
        gestureDetector = new GestureDetector(getActivity(), new PlantelFragment.SingleTapConfirm());
        formacao.add(new FormacaoPlantel(2F,2F,1));
        loadData();
        return view;
    }
    private void loadData(){
        /*SharedPreferences sharedPreferences = getActivity().getSharedPreferences("plantel", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("plantel", null);
        Type type = new TypeToken<ArrayList<FormacaoPlantel>>() {}.getType();
        formacao = gson.fromJson(json, type);
        formacao.add(new FormacaoPlantel(150F, 150F, 1));*/
            for(int i = 1; i <= 11; i++){
                criarJogador(i, "ssd", "sds", 0,(i*125),  getActivity());
            }
    }
    private void saveData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("plantel", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(formacao);
        editor.putString("plantel", json);
        editor.apply();
    }

    void criarJogador (int index, String nome, String posicao, float x, float y, Context context){

        jogadores.add(new ImageView(context));
        jogadores.get(index).setImageResource(R.drawable.defesa);

        relativeLayout = (RelativeLayout) view.findViewById(R.id.bfllcampo);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //if you need three fix imageview in width
        int devicewidth = (int) Math.round(displaymetrics.widthPixels * 0.10);

        //if you need 4-5-6 anything fix imageview in height
        int deviceheight = (int) Math.round(displaymetrics.heightPixels * 0.10);

        relativeLayout.addView(jogadores.get(index));
        jogadores.get(index).getLayoutParams().width = devicewidth;
        jogadores.get(index).getLayoutParams().height = deviceheight;

        jogadores.get(index).setX(x);
        jogadores.get(index).setY(y);

        gestureDetector = new GestureDetector(getActivity(), new SingleTapConfirm());
        jogadores.get(index).setOnTouchListener(motionEvent);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
