package pt.ipca.projectoaddjn.chat;


import android.os.Bundle;
import android.os.*;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import pt.ipca.projectoaddjn.R;
import pt.ipca.projectoaddjn.login.Login;


/**
 * A simple {@link Fragment} subclass.
 */
public class chat extends Fragment {

    private View rootView;
    private Button btnEnviar;
    private EditText edtMensagem;
    private FirebaseListAdapter<ChatMessage> adapter;


    public chat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        edtMensagem = (EditText) rootView.findViewById(R.id.edtMensagem);
        btnEnviar = (Button) rootView.findViewById(R.id.btnEnviar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("CHAT").push().setValue(new ChatMessage(edtMensagem.getText().toString(),
                        FirebaseAuth.getInstance().getCurrentUser().getEmail()));
                edtMensagem.setText("");
                edtMensagem.requestFocus();
            }
        });

        //Load content
        displayChatMessage();

        return rootView;
    }

    private void displayChatMessage() {

        final ListView listaChat = (ListView) rootView.findViewById(R.id.listaChat);
        adapter = new FirebaseListAdapter<ChatMessage>(getActivity(), ChatMessage.class, R.layout.lista_chat,FirebaseDatabase.getInstance().getReference("CHAT"))
        {
            @Override
            protected void populateView(final View v, ChatMessage model, int position) {

                TextView messageText, messageUser, messageTime;
                messageText = (TextView) v.findViewById(R.id.message_text);
                messageUser = (TextView) v.findViewById(R.id.message_user);
                messageTime = (TextView) v.findViewById(R.id.message_time);
                final RelativeLayout chatrl = v.findViewById(R.id.chatrl);

                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getMessageTime()));

                chatrl.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {

                        registerForContextMenu(chatrl);


                        return false;
                    }
                });
            }
        };
        listaChat.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menuchat, menu);
    }
}
