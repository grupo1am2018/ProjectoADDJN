package pt.ipca.projectoaddjn;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import pt.ipca.projectoaddjn.Chat.chat;
import pt.ipca.projectoaddjn.ListarJogadores.MenuJogador;
import pt.ipca.projectoaddjn.ListarJogos.listarJogos;
import pt.ipca.projectoaddjn.Taticas.Taticas;


public class MenuPrincipal extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_jogadores:
                    transaction.replace(R.id.container, new MenuJogador()).commit();
                    return true;
                case R.id.navigation_jogos:
                    transaction.replace(R.id.container, new listarJogos()).commit();
                    return true;
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_calendario:
                    transaction.replace(R.id.container, new Taticas()).commit();
                    return true;
                case R.id.navigation_chat:
                    transaction.replace(R.id.container, new chat()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
