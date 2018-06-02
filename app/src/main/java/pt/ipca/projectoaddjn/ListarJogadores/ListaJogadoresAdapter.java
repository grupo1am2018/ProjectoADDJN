package pt.ipca.projectoaddjn.ListarJogadores;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import pt.ipca.projectoaddjn.Jogador.JogadorFragment;
import pt.ipca.projectoaddjn.R;

public class ListaJogadoresAdapter extends RecyclerView.Adapter<ListaJogadorHolder>  {

    String[] nomeJogador;
    Bitmap[] fotoJogador;
    Context context;
    int devicewidth;
    int deviceheight;

    public ListaJogadoresAdapter(String[] nomeJogador, Context context) {
        this.nomeJogador = nomeJogador;
        //this.fotoJogador = fotoJogador;
        this.context = context;
    }


    @Override
    public ListaJogadorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.jogador_lista, parent, false);
        ListaJogadorHolder viewHolder = new ListaJogadorHolder(v);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //if you need three fix imageview in width
        devicewidth = displaymetrics.widthPixels / 3;

        //if you need 4-5-6 anything fix imageview in height
        deviceheight = displaymetrics.heightPixels / 4;

        v.getLayoutParams().width = devicewidth;

        //if you need same height as width you can set devicewidth in holder.image_view.getLayoutParams().height
        v.getLayoutParams().height = deviceheight;
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ListaJogadorHolder holder, final int position) {

        int width = (int) Math.round(devicewidth * 0.7);
        int height = (int) (deviceheight * 0.7);
        Picasso.with(context).load("https://as01.epimg.net/img/comunes/fotos/fichas/deportistas/a/and/large/31985.png").fit().into(holder.logo);

        holder.name.setText(nomeJogador[position]);
        holder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity MenuPrincipal = (AppCompatActivity) v.getContext();
                JogadorFragment JogadorFragment = new JogadorFragment();
                MenuPrincipal.getSupportFragmentManager().beginTransaction().replace(R.id.container, JogadorFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nomeJogador.length;
    }
}