package pt.ipca.projectoaddjn.ListarJogadores;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pt.ipca.projectoaddjn.BaseDados.DatabaseHelper;
import pt.ipca.projectoaddjn.Jogador.Jogador;
import pt.ipca.projectoaddjn.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaJogadores extends Fragment {

    private View rootView;
    DatabaseHelper dbh;

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
        dbh = new DatabaseHelper(getActivity());
        SQLiteDatabase db = dbh.getWritableDatabase();


        //Cria uma variavel da classe adaptador
        ListaJogadoresAdapter adapter = new ListaJogadoresAdapter(Jogadores(), getActivity());

        //Define o tipo de layout, neste caso grelha
        listaJogadores.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        listaJogadores.setAdapter(adapter);

        // Retornar Vista
        return rootView;
    }

    ArrayList<Jogador> Jogadores(){
        // Procedimentos para inserir jogadores
        ArrayList<Jogador> jogadores = new ArrayList<>();


        jogadores.add(Jogador.inserirJogador(1, "Stojković", "Vladimir", "28/07/1983",
                "GR", 94, 1.96F, "Direito", "Partizan", R.drawable.partizan_logo,
                R.drawable.vladimir_stojkovic, 1, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Rajković", "Predrag", "31/01/1995",
                "GR", 79, 1.90F, "Direito", "Maccabi Tel Aviv", R.drawable.maccabi_tel_aviv_logo,
                R.drawable.rajkovic_predrag, 12, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Dmitrović", "Marko", "24/01/1992",
                "GR", 80, 1.90F, "Esquerdo", "Maccabi Tel Aviv", R.drawable.sdeibar_logo,
                R.drawable.dmitrovic_marko, 23, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Tošić", "Duško", "19/01/1985",
                "DC", 85, 1.85F, "Esquerdo", "Besiktas", R.drawable.besiktes_logo,
                R.drawable.dusko_tosic, 3, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Maksimović", "Nikola", "25/11/1991",
                "DC", 80, 1.93F, "Direito", "Spartak Moscow", R.drawable.spartak_moscow_logo,
                R.drawable.maksimovic_nikola, 3, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Obradović", "Ivan", "25/07/1988",
                "LE", 75, 1.81F, "Esquerdo", "Anderlecht", R.drawable.anderlecht_logo,
                R.drawable.obradovic_ivan, 18, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Rodić", "Milan", "02/04/1991",
                "LE", 77, 1.85F, "Esquerdo", "Crvena zvezda", R.drawable.crevena_logo,
                R.drawable.rodic_milan, 14, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Milenković", "Nikola", "12/10/1997",
                "DC", 77, 1.95F, "Direito", "Fiorentina", R.drawable.fiorentina_logo,
                R.drawable.milenkovic_nikola, 15, getActivity()));

        // mudar a foto deste jogador
        jogadores.add(Jogador.inserirJogador(1, "Savić", "Vujadin", "01/07/1990",
                "DC", 85, 1.94F, "Direito", "Crvena zvezda", R.drawable.crevena_logo,
                R.drawable.milenkovic_nikola, 15, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Ivanović", "Branislav", "22/02/1984",
                "DC", 84, 1.88F, "Direito", "Zenit", R.drawable.zenit_logo,
                R.drawable.bane_ivanovic, 15, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Kolarov", "Aleksandar", "10/11/1985",
                "DE", 80, 1.87F, "Esquerdo", "Roma", R.drawable.roma_logo,
                R.drawable.aleksandar_kolarov, 11, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Rukavina", "Antonio", "26/01/1984",
                "DR", 72, 1.77F, "Direito", "Villareal", R.drawable.villarreal_logo,
                R.drawable.antonio_rukavina, 2, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Nastasić", "Matijia", "28/03/1993",
                "DC", 80, 1.87F, "Esquerdo", "FC Schalke 04", R.drawable.schalke_logo,
                R.drawable.matija_nastasic, 5, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Spajić", "Uros", "13/02/1993",
                "DC", 75, 1.85F, "Direito", "Anderlecht", R.drawable.anderlecht_logo,
                R.drawable.spajic_uros, 77, getActivity()));

        // mudar foto
        jogadores.add(Jogador.inserirJogador(1, "Veljković", "Milos", "26/09/1995",
                "DC", 77, 1.87F, "Direito", "SV Werder Bremen", R.drawable.werder_logo,
                R.drawable.spajic_uros, 13, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Basta", "Dusan", "18/08/1984",
                "LD", 78, 1.83F, "Direito", "Lazio", R.drawable.lazio_logo,
                R.drawable.dusan_basta, 16, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Grujić", "Marko", "13/04/1996",
                "MC", 75, 1.91F, "Direito", "Cardiff", R.drawable.cardiff_logo,
                R.drawable.grujic_marko, 24, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Radonjić", "Nemanja", "15/02/1996",
                "EE", 76, 1.85F, "Esquerdo", "Crvena zvezda", R.drawable.crevena_logo,
                R.drawable.radonjic_nemanja, 54, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Ljajić", "Adem", "29/09/1991",
                "MO", 72, 1.82F, "Direito", "Torino", R.drawable.torino_logo,
                R.drawable.ljajic_adem, 22, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Milivojević", "Luka", "07/04/1991",
                "MD", 78, 1.82F, "Direito", "Crystal Palace FC", R.drawable.crysal_logo,
                R.drawable.luka_milivojevic, 4, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Tadić", "Dusan", "20/11/1988",
                "M0", 74, 1.81F, "Esquerdo", "Southampton", R.drawable.southampnon_logo,
                R.drawable.dusan_basta, 10, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Kostić", "Filip", "01/11/1992",
                "EE", 70, 1.78F, "Esquerdo", "Hamburger SV", R.drawable.hamburgo_logo,
                R.drawable.kostic_filip, 17, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Maksimović", "Nemanja", "26/01/1995",
                "MC", 75, 1.85F, "Direito", "Valencia CF", R.drawable.valencia_logo,
                R.drawable.maksimovic_nemanja, 23, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Milinković-Savić", "Sergej", "27/02/1995",
                "MC", 76, 1.86F, "Direito", "Lazio", R.drawable.lazio_logo,
                R.drawable.milinkovic_savic_sergej, 20, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Gaćinović", "Mijat", "08/02/1995",
                "MO", 68, 1.75F, "Direito", "Eintracht Fr", R.drawable.eintracht_logo,
                R.drawable.gacinovic_mijat, 14, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Živković", "Andrija", "11/07/1996",
                "MO", 60, 1.65F, "Esquerdo", "Benfica", R.drawable.benfica_logo,
                R.drawable.andrija_zivkovic, 7, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Matić", "Nemanja", "01/08/1988",
                "MCD", 82, 1.94F, "Esquerdo", "Benfica", R.drawable.logo_united,
                R.drawable.nemanja_matic, 21, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Prijović", "Аleksandar", "21/04/1990",
                "PL", 85, 1.91F, "Direito", "PAOK FC", R.drawable.paok_logo,
                R.drawable.prijovic_aleksandar, 8, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Mitrović", "Аleksandar", "16/09/1994",
                "PL", 80, 1.89F, "Direito", "Fulham", R.drawable.fulham_logo,
                R.drawable.aleksandar_mitrovic, 9, getActivity()));

        jogadores.add(Jogador.inserirJogador(1, "Jović", "Luka", "23/12/1997",
                "PL", 62, 1.75F, "Direito", "Benfica", R.drawable.benfica_logo,
                R.drawable.jovic_luka, 17, getActivity()));

        return jogadores;
    }

}
