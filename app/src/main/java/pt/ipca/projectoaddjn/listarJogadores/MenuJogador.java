package pt.ipca.projectoaddjn.listarJogadores;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pt.ipca.projectoaddjn.R;
import pt.ipca.projectoaddjn.listarJogadores.ListaJogadores;
import pt.ipca.projectoaddjn.plantel.PlantelFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuJogador extends Fragment {

    private View rootView;
    private Button btnListarJogadores;
    private Button btnPlantel;

    public MenuJogador() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         rootView = inflater.inflate(R.layout.fragment_menu_jogador, container, false);

        btnListarJogadores = (Button) rootView.findViewById(R.id.btnListarJogadores);
        btnPlantel = (Button) rootView.findViewById(R.id.btnPlantel);


         btnListarJogadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, new ListaJogadores()).commit();
            }
         });

        btnPlantel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container, new PlantelFragment()).commit();
            }
        });

        // Retornar Vista
        return rootView;
    }


}
