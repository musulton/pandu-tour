package com.musulton.pandutour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class KeteranganActivity extends AppCompatActivity {

    WebView Konten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan);

        Konten = (WebView) findViewById(R.id.Konten);

        Intent konten = getIntent();
        String nama = konten.getStringExtra("name");
        String detail = konten.getStringExtra("ditel");

        getSupportActionBar().setTitle(nama);

        Konten.getSettings().setJavaScriptEnabled(true);
        Konten.loadData(detail, "text/html; charset=utf-8", "UTF-8");
    }
}
