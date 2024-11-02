package com.example.resepmakanan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resepmakanan.R;

public class LoginPages extends AppCompatActivity {

    private TextView textView;
    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pages);

        textView = findViewById(R.id.text_view);
        editTextEmail = findViewById(R.id.edit_text_1);
        editTextPassword = findViewById(R.id.edit_text_2);

        editTextEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEmail.setBackground(getResources().getDrawable(R.drawable.bg_edit_text_blue_border));
            }
        });

        editTextPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextPassword.setBackground(getResources().getDrawable(R.drawable.bg_edit_text_blue_border));
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPages.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    public void clickLogin(View view) {
        // Validasi input email dan password
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Email dan Password Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
        } else if (!isValidEmail(email)) {
            Toast.makeText(this, "Email Tidak Valid", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(LoginPages.this, Homepage_main.class);
            startActivity(intent);
        }
    }

    public void clickForgot(View view) {
        Intent intent = new Intent(LoginPages.this, Forgotpass.class);
        startActivity(intent);
    }

    public static boolean isValidEmail(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}