package com.example.mydragger2.di;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.mydragger2.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    public Apple apple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((AndroidApplication)getApplication()).getAppleCOmpent().inject(this);

        Log.e("MainActivity",apple+"");

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }
}
