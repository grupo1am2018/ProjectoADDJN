package pt.ipca.projectoaddjn.ListarJogadores;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.ipca.projectoaddjn.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaJogadores extends Fragment {

    private View rootView;

    public ListaJogadores() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_lista_jogadores, container, false);

        //Cria a view que mostra os jogadores
        RecyclerView listaJogadores = (RecyclerView) rootView.findViewById(R.id.recyclerId);

        //Cria uma string e insere os jogadores na view
        //Aqui pode ser mudado para um array de jogadores e mandado para o construtor do adapter
        String[] nomeJogador = new String[23];

        for(int i = 0; i < nomeJogador.length; i++) {
            nomeJogador[i] = "ANDRÉ" + Integer.toString(i+1);
        }

        //Cria uma variavel da classe adaptador
        ListaJogadoresAdapter adapter = new ListaJogadoresAdapter(nomeJogador, getActivity());

        //Define o tipo de layout, neste caso grelha
        listaJogadores.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        listaJogadores.setAdapter(adapter);

        // Retornar Vista
        return rootView;
    }

}
