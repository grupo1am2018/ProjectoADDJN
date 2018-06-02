package pt.ipca.projectoaddjn.Plantel;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import pt.ipca.projectoaddjn.R;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlantelFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlantelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlantelFragment extends Fragment {
    float dX, dY;
    View view;
    private GestureDetector gestureDetector;
    ArrayList<ImageView> jogadores = new ArrayList<ImageView>();
    ArrayList<FormacaoPlantel> formacao = new ArrayList<FormacaoPlantel>();
    RelativeLayout relativeLayout;
    FloatingActionButton fabPlantel;

    // TODO: Rename and change types of parameters«

    private OnFragmentInteractionListener mListener;

    public PlantelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment bf1.
     */
    // TODO: Rename and change types and number of parameters
    public static PlantelFragment newInstance() {
        PlantelFragment fragment = new PlantelFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_plantel, container, false);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.bfllcampo);
        fabPlantel = view.findViewById(R.id.fabPlantel);
        fabPlantel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*DatabaseHelper dbh = new DatabaseHelper(getActivity());
                SQLiteDatabase db = dbh.getWritableDatabase();
                dbh.erase(getActivity());
                for(int i = 0; i < 11; i++){
                    FormacaoPlantel.insertJogadorPlantel(450.0F, 450.0F, i, getActivity());
                }*/
                for(int i = 0; i < 11; i++){
                    FormacaoPlantel.UpdatePosicaoJogador(formacao.get(i).getjogadorX(), formacao.get(i).getjogadorY(),formacao.get(i).getCodJogador(),  getActivity());
                }

            }
        });
        gestureDetector = new GestureDetector(getActivity(), new PlantelFragment.SingleTapConfirm());
        loadData(getActivity());
        return view;
    }
    private void loadData(Context context){
       /*formacao = FormacaoPlantel.getFormacaoPlantel(context);
         DatabaseHelper dbh = new DatabaseHelper(context);
        SQLiteDatabase db = dbh.getWritableDatabase();
        dbh.erase(context);
        for(int i = 0; i < 11; i++){
            FormacaoPlantel.insertJogadorPlantel(450.0F, 450.0F, i, context);
        }*/
        formacao = FormacaoPlantel.getFormacaoPlantel(context);
        for(int i = 0; i < 11; i++){
            criaCamisola(formacao.get(i).getjogadorX(),formacao.get(i).getjogadorY(), formacao.get(i).getCodJogador(),i, context);
        }
    }

    private void saveData(){
        /*SharedPreferences sharedPreferences = getActivity().getSharedPreferences("plantel", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(formacao);
        editor.putString("plantel", json);
        editor.apply();*/

    }

    void criaCamisola (float x, float y, final int codJogador, final int index, final Context context) {
        final RelativeLayout rl = new RelativeLayout(context);
        ImageView camisola = new ImageView(context);
        TextView numero = new TextView(context);

        relativeLayout = (RelativeLayout) view.findViewById(R.id.bfllcampo);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);

        numero.setLayoutParams(lp);
        camisola.setLayoutParams(lp);
        rl.setLayoutParams(lp);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //if you need three fix imageview in width
        int devicewidth = (int) Math.round(displaymetrics.widthPixels * 0.10);

        //if you need 4-5-6 anything fix imageview in height
        int deviceheight = (int) Math.round(displaymetrics.heightPixels * 0.07);



        rl.getLayoutParams().width = devicewidth;
        rl.getLayoutParams().height = deviceheight;
        rl.setBackground(ContextCompat.getDrawable(context, R.drawable.defesa));
        rl.setX(x);
        rl.setY(y);

        camisola.getLayoutParams().width = devicewidth;
        camisola.getLayoutParams().height = deviceheight;
        camisola.setX(x);
        camisola.setY(y);


        numero.getLayoutParams().width = devicewidth;
        numero.getLayoutParams().height = deviceheight;
        numero.setX(x);
        numero.setY(y);
        numero.setTextColor(Color.WHITE);

        numero.setText("" + codJogador);
        camisola.setImageResource(R.drawable.defesa);
        gestureDetector = new GestureDetector(getActivity(), new SingleTapConfirm());
        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v,  MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    Toast.makeText(context, Integer.toString(codJogador), Toast.LENGTH_SHORT).show();
                    Log.d("teste", "jogador" + codJogador);
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
                            Log.i("movimento", "x : " + (Math.round(event.getRawX() + dX) + " y : " + Math.round(event.getRawY() + dY)));
                            formacao.get(index).setjogadorX(event.getRawX() + dX);
                            formacao.get(index).setjogadorY(event.getRawY() + dY);
                            break;
                        default:
                            return false;
                    }

                    return true;
                }
            }
        });

        rl.addView(camisola);
        rl.addView(numero);
        relativeLayout.addView(rl);
    }
    /*/
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
    }*/

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
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