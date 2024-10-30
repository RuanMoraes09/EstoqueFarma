package com.example.estoquefarma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputEmail, inputPass, inputName;

    private Button btnLogin, btnBack;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        inputEmail = findViewById(R.id.createEmail);
        inputPass = findViewById(R.id.createPass);
        inputName = findViewById(R.id.user);
        btnLogin = findViewById(R.id.createLogin);
        btnBack = findViewById(R.id.backCreate);

        //Voltar para tela inicial
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    }
