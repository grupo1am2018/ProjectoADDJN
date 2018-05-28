package pt.ipca.projectoaddjn.listarJogos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pt.ipca.projectoaddjn.R;

public class listarJogosAdpter extends ArrayAdapter {

    public Context mContext;
    public List<Jogo> mJogos;
    public List<Equipa> mEquipas;
    public List<Competicao> mCompeticoes;
    public List<EstatisticasJogo> mEstatisticasJogo;
    public String nEq1;
    public String nEq2;
    public String nComp;
    public int golos1;
    public int golos2;
    public int logo1;
    public int logo2;
    public int i;


    public listarJogosAdpter(Context context, List<Jogo> jogo, List<Equipa> equipa, List<Competicao> competicao, List<EstatisticasJogo> estatisticaJogo) {
        super(context, R.layout.layout_row_jogos, jogo);
        this.mContext = context;
        this.mJogos = jogo;
        this.mEquipas = equipa;
        this.mCompeticoes = competicao;
        this.mEstatisticasJogo = estatisticaJogo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_row_jogos, parent, false);
        }

        Jogo jogo = mJogos.get(position);

        TextView equipa1 = convertView.findViewById(R.id.equipa1View);
        TextView equipa2 = convertView.findViewById(R.id.equipa2View);
        TextView competicao = convertView.findViewById(R.id.competicaoView);
        TextView data = convertView.findViewById(R.id.dataView);
        TextView resultado = convertView.findViewById(R.id.resultadoView);
        ImageView logoEqu1 = convertView.findViewById(R.id.logoEquipa1);
        ImageView logoEqu2 = convertView.findViewById(R.id.logoEquipa2);

        //Encontrar o nome da equipa 1 do jogo
        for (i = 0; i < mEquipas.size(); i++) {
            if (jogo.idEquipa1 == mEquipas.get(i).getId()) {
                nEq1 = mEquipas.get(i).getName();
            }
        }

        //Encontrar o logo da equipa 1 do jogo
        for (i = 0; i < mEquipas.size(); i++) {
            if (jogo.idEquipa1 == mEquipas.get(i).getId()) {
                logo1 = mEquipas.get(i).getLogo();
            }
        }

        //Encontrar o nome da equipa 2 do jogo
        for (i = 0; i < mEquipas.size(); i++) {
            if (jogo.idEquipa2 == mEquipas.get(i).getId()) {
                nEq2 = mEquipas.get(i).getName();
            }
        }

        //Encontrar o logo da equipa 2 do jogo
        for (i = 0; i < mEquipas.size(); i++) {
            if (jogo.idEquipa2 == mEquipas.get(i).getId()) {
                logo2 = mEquipas.get(i).getLogo();
            }
        }

        //Encontrar o nome da competição do jogo
        for (i = 0; i < mCompeticoes.size(); i++) {
            if (jogo.idCompeticao == mCompeticoes.get(i).getId()) {
                nComp = mCompeticoes.get(i).getName();
            }
        }

        //Encontrar os golos da equipa 1 no jogo
        for (i = 0; i < mEstatisticasJogo.size(); i++) {
            if (mEstatisticasJogo.get(i).getIdJogo() == jogo.idJogo && mEstatisticasJogo.get(i).getIdEquipa() == jogo.idEquipa1) {
                golos1 = mEstatisticasJogo.get(i).getGoals();
            }
        }

        //Encontrar os golos da equipa 2 no jogo
        for (i = 0; i < mEstatisticasJogo.size(); i++) {
            if (mEstatisticasJogo.get(i).getIdJogo() == jogo.idJogo && mEstatisticasJogo.get(i).getIdEquipa() == jogo.idEquipa2) {
                golos2 = mEstatisticasJogo.get(i).getGoals();
            }
        }

        equipa1.setText(nEq1);
        equipa2.setText(nEq2);
        competicao.setText(nComp);
        data.setText(jogo.data);
        if (golos1 == -1 || golos2 == -1) {
            resultado.setText(" - ");
        } else {
            resultado.setText(golos1 + " - " + golos2);
        }
        logoEqu1.setImageResource(logo1);
        logoEqu2.setImageResource(logo2);
        return convertView;
    }
}