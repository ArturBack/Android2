package com.example.artur.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void wyswietlMape(View widok)
    {
        final Intent intencja2 = new Intent(this,GoogleActivity.class);
        
        startActivity(intencja2);
    }
}
