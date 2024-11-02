package com.example.resepmakanan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.resepmakanan.adapter.DataAdapter;
import com.example.resepmakanan.model.DataModel;
import com.example.resepmakanan.R;

import java.util.ArrayList;

public class Homepage_main extends AppCompatActivity {

    private DataAdapter dataAdapter;
    private RecyclerView recyclerView;
    private ArrayList<DataModel> dataModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_main);

        // Membuat data untuk ditampilkan di RecyclerView
        inputData("Ayam Bakar Bumbu Bali", "activity_artikel1.xml");
        inputData("Sate Ayam Srepeh", "artikel_2.xml");
        inputData("Pizza Sosis Jumbo (Tanpa Ulen)", "artikel_3.xml");
        inputData("Nasgor Mawut (Mawut Sayur)", "artikel_4.xml");
        inputData("Fuyung Hai", "artikel_5.xml");
        inputData("Lobster Bumbu Padang", "artikel_6.xml");
        inputData("Sop Iga Sapi", "artikel_7.xml");
        inputData("Opor Ayam Kampung", "artikel_8.xml");
        inputData("Bebek Goreng Sambel Ijo", "artikel_9.xml");
        inputData("Soto Ayam Kampung", "artikel_10.xml");
        inputData("Bakso Ayam", "artikel_11.xml");
        inputData("Ikan Gurame Bakar", "artikel_12.xml");
        inputData("Pisang Bakar Coklat Keju", "artikel_13.xml");
        inputData("Keto Martabak Terang Bulan", "artikel_14.xml");
        inputData("Ingkung Ayam Kampung", "artikel_15.xml");

        // Menampilkan data ke dalam RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        dataAdapter = new DataAdapter(this, dataModelArrayList);
        recyclerView.setAdapter(dataAdapter);

        // Menyesuaikan status bar untuk tampilan fullscreen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    // Fungsi untuk menambahkan data ke ArrayList
    private void inputData(String judul, String konten) {
        DataModel dataModel = new DataModel();
        dataModel.setJudul(judul);
        dataModel.setKonten(konten);
        dataModel.setViewType(1);
        dataModelArrayList.add(dataModel);
    }

    // Fungsi untuk mengatur flag pada jendela status bar
    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
