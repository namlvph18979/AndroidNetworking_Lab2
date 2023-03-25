package com.example.lab2_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView tv_get;
    Button btnnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_get = findViewById(R.id.tv_get);
        btnnext = findViewById(R.id.btn_next);

        String trang_web = "https://0e29p7-8080.csb.app/users";
        new Get_Http(tv_get,MainActivity.this).execute(trang_web);


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Post_Activity.class);
                startActivity(intent);
            }
        });
    }
}