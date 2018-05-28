package pt.ipca.projectoaddjn.listarJogos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pt.ipca.projectoaddjn.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class listarJogos extends Fragment {

    private View rootView;

    public listarJogos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_listar_jogos, container, false);

        ListView listView = rootView.findViewById(R.id.main_listview);

        //Todas as listas criadas a seguir são apenas para testes
        //Criar lista de competições
        List<Competicao> competicoes = new ArrayList<Competicao>();

        //Adicionar competiçoes à lista
        competicoes.add(new Competicao(1, "Europeu 2012", "08-06-2012", "01-07-2012","Polônia e Ucrânia"));
        competicoes.add(new Competicao(2, "Mundial 2014", "12-06-2014", "13/07/2014", "Brasil"));
        competicoes.add(new Competicao(3, "Europeu 2016", "10-06-2016", "10-07-2016", "França"));
        competicoes.add(new Competicao(4, "Mundial 2018", "14-06-2018", "15-07-2018", "Rússia"));

        //Criar lista de equipas
        List<Equipa> equipas = new ArrayList<Equipa>();

        //Adicionar equipas à lista
        equipas.add(new Equipa(1, "Sérvia", R.drawable.serbia));
        equipas.add(new Equipa(2, "Alemanha", R.drawable.germany));
        equipas.add(new Equipa(3, "Inglaterra", R.drawable.england));
        equipas.add(new Equipa(4, "França", R.drawable.france));

        //Criar lista de jogos
        List<Jogo> jogos = new ArrayList<Jogo>();

        //Adicionar jogos à lista
        jogos.add(new Jogo(1, 1, 2, 1, "01-02-2017"));
        jogos.add(new Jogo(2, 3, 1, 1, "10-02-2017"));
        jogos.add(new Jogo(3, 1, 4, 1, "17-02-2017"));

        //Criar lista de estatísticas de jogo
        List<EstatisticasJogo> estatisticasJogo = new ArrayList<EstatisticasJogo>();

        //Adicionar estatísticas à lista
        estatisticasJogo.add(new EstatisticasJogo(1, 1, 1, 0));
        estatisticasJogo.add(new EstatisticasJogo(2, 1, 2, 2));
        estatisticasJogo.add(new EstatisticasJogo(3, 2, 3, 1));
        estatisticasJogo.add(new EstatisticasJogo(4, 2, 1, 2));
        estatisticasJogo.add(new EstatisticasJogo(5, 3, 1, 2));
        estatisticasJogo.add(new EstatisticasJogo(6, 3, 4, 2));

        //Classe para listar os jogos
        listarJogosAdpter adapter = new listarJogosAdpter(getActivity(), jogos, equipas, competicoes, estatisticasJogo);
        listView.setAdapter(adapter);

        return rootView;
    }

}
