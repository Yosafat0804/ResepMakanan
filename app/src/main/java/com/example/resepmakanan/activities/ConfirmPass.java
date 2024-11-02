package com.example.resepmakanan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resepmakanan.R;

public class ConfirmPass extends AppCompatActivity {

    EditText editText7, editText8, editText9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pass);

        editText7 = findViewById(R.id.edit_text_7);
        editText8 = findViewById(R.id.edit_text_8);
        editText9 = findViewById(R.id.edit_text_9);

        editText7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText7.setBackground(getResources().getDrawable(R.drawable.bg_edit_text_blue_border));
            }
        });

        editText8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText8.setBackground(getResources().getDrawable(R.drawable.bg_edit_text_blue_border));
            }
        });

        editText9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText9.setBackground(getResources().getDrawable(R.drawable.bg_edit_text_blue_border));
            }
        });
    }

    public void clickLeft(View view) {
        Intent intent = new Intent(ConfirmPass.this, LoginPages.class); // Replace 'LoginPages' with your target Activity class
        startActivity(intent);
    }

    public void clickConfirm(View view) {
        Intent intent = new Intent(ConfirmPass.this, LoginPages.class);
        startActivity(intent);
    }
}