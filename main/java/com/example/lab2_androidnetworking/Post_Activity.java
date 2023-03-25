package com.example.lab2_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class Post_Activity extends AppCompatActivity {

    public static EditText username,email,pass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        username = findViewById(R.id.edt_username);
        email = findViewById(R.id.edt_email);
        pass = findViewById(R.id.edt_password);

        btn = findViewById(R.id.btn_post);
        String trang_web = "https://0e29p7-8080.csb.app/users";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().trim().isEmpty() || email.getText().toString().trim().isEmpty() || pass.getText().toString().trim().isEmpty()){
                    Toast.makeText(Post_Activity.this, "nhap vao", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    new Post_Http(username.getText().toString().trim(),pass.getText().toString().trim(),email.getText().toString().trim(),Post_Activity.this).execute(trang_web);
                }

            }
        });

    }
}