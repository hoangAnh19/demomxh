package com.example.demomxh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.xml.sax.DTDHandler;

public class MainActivity extends AppCompatActivity {
    Button btnDangky, btnDangnhap;
    EditText editE, editP;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // hàm khởi tạo
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        mAuth = FirebaseAuth.getInstance();

        btnDangky.setOnClickListener(new View.OnClickListener() { // hàm nhận nút bấm btn Đăng ký
            @Override
            public void onClick(View view) { //hàm click
                Dangky();
            }
        });

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dangnhap();
            }
        });
    }


    private void Anhxa() {
        btnDangky = (Button) findViewById(R.id.btnDangky);
        btnDangnhap = (Button) findViewById(R.id.btnDangnhap);
        editE = (EditText) findViewById(R.id.editEmail);
        editP = (EditText) findViewById(R.id.editPass);
    }

    private void Dangky() {
        String email = editE.getText().toString();
        String password = editP.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "dang ky thanh cong", Toast.LENGTH_SHORT).show();

                    Intent intent= new Intent(MainActivity.this,trangchu.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "dang ky that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void Dangnhap() {
        String email = editE.getText().toString();
        String password = editP.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, trangchu.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "dang nhap that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

