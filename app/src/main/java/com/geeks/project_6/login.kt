package com.geeks.project_6;

import static com.geeks.project_6.R.color.darkRed;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    EditText emailEt;
    EditText passwordEt;
    Button loginBtn;

    String email = "admin";
    String password = "admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
        });

        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login);

        emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    loginBtn.setBackgroundTintList(ContextCompat.getColorStateList(login.this, darkRed));
                } else {
                    loginBtn.setBackgroundTintList(ContextCompat.getColorStateList(login.this, R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    loginBtn.setBackgroundTintList(ContextCompat.getColorStateList(login.this, R.color.darkRed));
                } else {
                    loginBtn.setBackgroundTintList(ContextCompat.getColorStateList(login.this, R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.equals(emailEt.getText().toString()) && password.equals(passwordEt.getText().toString())) {
                    Toast.makeText(login.this, "You have successfully registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, Menu.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(login.this, "Incorrect login or password", Toast.LENGTH_SHORT).show();
                }
                emailEt.setText("");
                passwordEt.setText("");
            }
        });
    }
}