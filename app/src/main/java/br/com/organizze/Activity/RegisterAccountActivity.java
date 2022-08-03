package br.com.organizze.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.ExecutionException;

import br.com.organizze.R;
import br.com.organizze.configFirebase.ConfiguracaoFirebase;
import br.com.organizze.model.Users;

public class RegisterAccountActivity extends AppCompatActivity {

    private static final String TAG = "RegisterAccount";
    private EditText textName,textEmail,textPassword;
    private Button buttonRegister;
    private FirebaseAuth autenticacao;

    private Users usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

        startComponentes();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = textName.getText().toString();
                String email = textEmail.getText().toString();
                String password = textPassword.getText().toString();

                if(!name.isEmpty()){
                    if(!email.isEmpty()){
                        if(!password.isEmpty()){

                            usuario = new Users();
                            usuario.setName(name);
                            usuario.setEmail(email);
                            usuario.setPassword(password);
                            RegisterUsers();

                        }else{
                            Toast.makeText(RegisterAccountActivity.this, "Preencha o campo senha", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterAccountActivity.this, "Preencha o campo email", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(RegisterAccountActivity.this, "Preencha o campo nome", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void RegisterUsers(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getPassword()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(RegisterAccountActivity.this, "Usuario cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegisterAccountActivity.this, "Error ao criar usuario", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onComplete: ESTOU NO ELSE, MAS POR QUE? " + task.getException());
                }
            }
        });
    }

    private void startComponentes() {
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
    }
}