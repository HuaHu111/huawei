package com.example.acer.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.myapplication.R;
import com.example.acer.myapplication.model.User;
import com.example.acer.myapplication.ppresenter.impl.MainPresenterImpl;
import com.example.acer.myapplication.view.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenterImpl mainPresenter;
    private EditText et_username;
    private EditText et_pwd;
    private Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter=new MainPresenterImpl();
        mainPresenter.attachView(this);

        et_username=findViewById(R.id.et_username);
        et_pwd=findViewById(R.id.et_pwd);
        btn_login=findViewById(R.id.kaishi);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et_username.getText().toString().trim();
                String pwd=et_pwd.getText().toString().trim();
                User user = new User();
                user.username=name;
                user.pwd=pwd;
                mainPresenter.login(user);
            }
        });

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginsuccess() {
        showToast("登录成功");
    }

    @Override
    public void loginFail() {
        showToast("登录失败");
    }
}
