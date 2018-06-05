package pt.ipca.projectoaddjn.ListarJogadores;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import pt.ipca.projectoaddjn.BaseDados.DatabaseHelper;
import pt.ipca.projectoaddjn.Jogador.Jogador;
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
        DatabaseHelper dbh = new DatabaseHelper(getActivity());
        dbh.erase(getActivity());
        SQLiteDatabase db = dbh.getWritableDatabase();

        // Procedimentos para inserir jogadores
        Jogador inserirMatic = Jogador.inserirJogador(1, "Matic", "Nemanja", "01/08/1988",
                "MC/MD", 78, 1.94F, "Esquerdo", "Manchester United", R.drawable.logo_united,
        R.drawable.matic_jogador, 21, getActivity());

        Jogador inseriJovanocic = Jogador.inserirJogador(1, "Aleksandar", "Jovanivic", "06/12/1992",
                "GR", 85, 1.92F, "Direito", "Aarhus", R.drawable.logo_united,
                R.drawable.matic_jogador, 21, getActivity());



        //Cria uma variavel da classe adaptador
        ListaJogadoresAdapter adapter = new ListaJogadoresAdapter(jogadores, getActivity());

        //Define o tipo de layout, neste caso grelha
        listaJogadores.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        listaJogadores.setAdapter(adapter);

        // Retornar Vista
        return rootView;
    }

}
