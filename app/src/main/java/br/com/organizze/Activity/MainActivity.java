package br.com.organizze.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

import br.com.organizze.Activity.LoginActivity;
import br.com.organizze.Activity.RegisterAccountActivity;
import br.com.organizze.R;

public class MainActivity extends IntroActivity {

    TextView textViewAccount;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.welcome)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.information)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.alert)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.organizze_intro)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(R.layout.account_registration)
                .canGoForward(false)
                .build()
        );

    }


    public void buttonAccount(View view){
       startActivity(new Intent(this, LoginActivity.class));
    }

    public void buttonRegister(View view){
        startActivity(new Intent(this, RegisterAccountActivity.class));
    }
}