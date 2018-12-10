package com.example.mydragger2.di;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.mydragger2.R;
import com.example.mydragger2.di.scope.Type;

import javax.inject.Inject;

public class Main3Activity extends AppCompatActivity {


    @Inject
    @Type("shuigou")
    public Knife knife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        DaggerMain3Component.builder().main3Module(new Main3Module()).build().inject(this);

        Log.e("MainActivity",knife+"");

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
