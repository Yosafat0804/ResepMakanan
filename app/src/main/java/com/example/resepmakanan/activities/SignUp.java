package com.example.resepmakanan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.resepmakanan.R;

public class SignUp extends AppCompatActivity {

    private TextView textViewLogin, textViewCreateAccount;
    private EditText editTextName, editTextEmail, editTextPassword, editTextConfirmPassword, editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initializing views
        textViewLogin = findViewById(R.id.text_view);
        textViewCreateAccount = findViewById(R.id.text_view_3);
        editTextName = findViewById(R.id.edit_text_1);
        editTextEmail = findViewById(R.id.edit_text_2);
        editTextPassword = findViewById(R.id.edit_text_3);
        editTextConfirmPassword = findViewById(R.id.edit_text_4);
        editTextPhone = findViewById(R.id.edit_text_5);

        // Setting up click listener for Login TextView
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, LoginPages.class));
            }
        });

        // Setting click listeners to change background of EditText fields
        setEditTextFocusListener(editTextName);
        setEditTextFocusListener(editTextEmail);
        setEditTextFocusListener(editTextPassword);
        setEditTextFocusListener(editTextConfirmPassword);
        setEditTextFocusListener(editTextPhone);
    }

    private void setEditTextFocusListener(final EditText editText) {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setBackground(getResources().getDrawable(R.drawable.bg_edit_text_blue_border));
            }
        });
    }

    public void clickLeft(View view) {
        Intent intent = new Intent(SignUp.this, LoginPages.class);
        startActivity(intent);
    }

    public void clickCreateAcc(View view) {
        Intent intent = new Intent(SignUp.this, Homepage_main.class);
        startActivity(intent);
    }
}
