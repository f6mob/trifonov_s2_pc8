package com.example.session1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextView l_up;

    View login_b;

    TextInputEditText login;
    TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.Theme_Session1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        l_up = findViewById(R.id.s_up);
        login_b = findViewById(R.id.log_button);
        login = findViewById(R.id.login_input);
        password = findViewById(R.id.pass_input);

        l_up.setOnClickListener(view -> {
            Intent intent = new Intent(this,SignUpActivity.class);
            startActivity(intent);
        });

        login_b.setOnClickListener(view -> {
            String l = login.getText().toString();
            String p = password.getText().toString();
            if (l.equals("serk") && p.equals("123")) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(view.getContext(),"Неверный логин или пароль",Toast.LENGTH_LONG).show();
            }
        });


    }
}