package com.example.resepmakanan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.resepmakanan.R;

public class Forgotpass extends AppCompatActivity {

    private EditText edit_text_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        edit_text_6 = findViewById(R.id.edit_text_6);

        edit_text_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                edit_text_6.setBackground(getResources().getDrawable(R.drawable.bg_edit_text_blue_border));
            }
        });
    }

    public void clickLeft(View view) {
        Intent i = new Intent(Forgotpass.this, LoginPages.class);
        startActivity(i);
    }

    public void clickReset(View view) {
        Intent i = new Intent(Forgotpass.this, LoginPages.class);
        startActivity(i);
    }
}