package pt.ipca.projectoaddjn.ListarJogadores;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pt.ipca.projectoaddjn.R;

public class ListaJogadorHolder extends RecyclerView.ViewHolder{

    public ImageView logo;
    public TextView name;

    public ListaJogadorHolder(View itemView) {
        super(itemView);
        logo = itemView.findViewById(R.id.fotoJogador);
        name = itemView.findViewById(R.id.nomeJogador);
    }
}

