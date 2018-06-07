package pt.ipca.projectoaddjn.ListarJogadores;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pt.ipca.projectoaddjn.R;

public class ListaJogadorHolder extends RecyclerView.ViewHolder{

    public ImageView foto;
    public TextView name;
    public TextView numero;

    public ListaJogadorHolder(View itemView) {
        super(itemView);
        foto = itemView.findViewById(R.id.lista_foto);
        name = itemView.findViewById(R.id.lista_nome);
        numero = itemView.findViewById(R.id.lista_numero);
    }
}