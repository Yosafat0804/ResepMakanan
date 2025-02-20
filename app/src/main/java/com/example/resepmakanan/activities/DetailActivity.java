package com.example.resepmakanan.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.resepmakanan.model.DataModel;
import com.example.resepmakanan.R;

public class DetailActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Toolbar setup
        setupToolbar();

        mProgressBar = findViewById(R.id.progress_bar);
        mProgressBar.setMax(100);
        mProgressBar.setProgress(0);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        DataModel dataModel = (DataModel) bundle.getSerializable("dataModel");

        // Set title of toolbar to the item title
        setTitle(dataModel.getJudul());

        // Load content into WebView
        webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/" + dataModel.getKonten());
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String newUrl) {
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String urlStart, Bitmap favicon) {
                mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String urlPage) {
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbDetail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}