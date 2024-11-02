package com.example.resepmakanan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.resepmakanan.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure for an immersive layout experience
        setEdgeToEdgeLayout();

        // Apply padding to accommodate system UI elements
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom);
            return insets;
        });

        // Automatically navigate to LoginPages after a brief delay
        initiateLoginTransition();
    }

    // Helper method to configure an immersive layout experience
    private void setEdgeToEdgeLayout() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) { // Check for API 30 or higher
            getWindow().setDecorFitsSystemWindows(false);
        }
    }

    // Helper method to handle transition with a delay
    private void initiateLoginTransition() {
        new Handler().postDelayed(() -> {
            Intent loginIntent = new Intent(MainActivity.this, LoginPages.class);
            startActivity(loginIntent);
            finish();
        }, 3000); // Delay of 3 seconds
    }
}