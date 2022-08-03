package br.com.organizze.configFirebase;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguracaoFirebase {

    private static final String TAG = "ConfiguraçãoFIrebase";
    private static FirebaseAuth autenticacao;

    //retorna a instancia do firebase
    public static FirebaseAuth getFirebaseAutenticacao(){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }
}
