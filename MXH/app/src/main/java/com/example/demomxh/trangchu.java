package com.example.demomxh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class trangchu extends AppCompatActivity {
Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        btnBack= (Button) findViewById(R.id.btnBack);
    btnBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Back();
        }
    });
    }

    public void Back(){
        Intent intent = new Intent(trangchu.this,MainActivity.class);
        startActivity(intent);
    }
}