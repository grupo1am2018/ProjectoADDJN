package pt.ipca.projectoaddjn.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import pt.ipca.projectoaddjn.MenuPrincipal;
import pt.ipca.projectoaddjn.R;
import pt.ipca.projectoaddjn.RegistarUser.registarUser;

public class Login extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private FirebaseAuth firebaseAuth;

    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        prefs = getSharedPreferences("pt.ipca.projectoaddjn", MODE_PRIVATE);
    }


    public void btn_login(View v) {
        // Popup enquanto android trabalha com a rede
        final ProgressDialog progressDialog = ProgressDialog.show(Login.this, "Aguarde...", "A Processar...", true);

        (firebaseAuth.signInWithEmailAndPassword(edtEmail.getText().toString(), edtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {

                            Toast.makeText(Login.this, "Login Efectuado com Sucesso!", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Login.this, MenuPrincipal.class);
                            startActivity(i);
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void btn_Registar(View v) {
        Intent i = new Intent(Login.this, registarUser.class);
        startActivity(i);
    }
}