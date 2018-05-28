package pt.ipca.projectoaddjn.registarUser;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pt.ipca.projectoaddjn.R;

public class registarUser extends AppCompatActivity {

    private EditText edtNomedeUtilizador, edtEmail, edtPassword;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    private DatabaseReference userIdRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_user);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Utilizadores");
        mAuth = FirebaseAuth.getInstance();
        edtNomedeUtilizador = (EditText) findViewById(R.id.edtNomedeUtilizador);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

    }

    public void btnRegistar(View v) {
        // Popup enquanto android trabalha com a rede
        final ProgressDialog progressDialog = ProgressDialog.show(registarUser.this, "A Registar...", "A Registar agurade...", true);

        mAuth.createUserWithEmailAndPassword(edtEmail.getText().toString(), edtPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isComplete()) {
                    Toast.makeText(getApplicationContext(),"Utilizador Registado com Sucesso", Toast.LENGTH_SHORT).show();
                    userIdRef = databaseReference.child(mAuth.getCurrentUser().getUid());
                    userIdRef.child("Nome").setValue(edtNomedeUtilizador.getText().toString());
                    finish();
                }

            }
        });
    }
}