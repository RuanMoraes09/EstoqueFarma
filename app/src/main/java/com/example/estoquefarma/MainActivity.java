package com.example.estoquefarma;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout da tela de login

        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.pass);
        Button loginButton = findViewById(R.id.login);
        TextView registerText = findViewById(R.id.criar);

        db = new DatabaseHelper(this);

        // Ação para o botão de login
        loginButton.setOnClickListener(v -> loginUser());

        // Ação para o texto "Criar Conta" - redireciona para a tela de cadastro
        registerText.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,RegisterActivity.class));
        });
    }

    private void loginUser() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, insira o email e a senha", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificação de usuário e senha
        if (db.checkUser(email, password)) {
            Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
            // Redireciona para a tela principal após o login
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish(); // Finaliza a tela de login para que o usuário não retorne a ela
        } else {
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
    }
}