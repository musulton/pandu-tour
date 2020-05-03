package com.musulton.pandutour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    // Deklarasi
    String googleMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    ImageView Gambar;
    TextView Telp, Nama, Profil, Alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FloatingActionButton navButton = (FloatingActionButton) findViewById(R.id.navButton);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String longitude = getIntent().getStringExtra("LONG_LOKASI");
                String latittude = getIntent().getStringExtra("LATI_LOKASI");
                String lokasi = latittude + "," + longitude ;
                gmmIntentUri = Uri.parse("google.navigation:q=" + lokasi);

                // Buat Uri dari intent gmmIntentUri. Set action => ACTION_VIEW
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Set package Google Maps untuk tujuan aplikasi yang di Intent yaitu google maps
                mapIntent.setPackage(googleMap);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(DetailActivity.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
        FloatingActionButton dialButton = (FloatingActionButton) findViewById(R.id.dialButton);
        dialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telp = getIntent().getStringExtra("TELP_LOKASI");
                Intent iDialNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telp));
                startActivity(iDialNumber);
            }
        });
        FloatingActionButton detailButton = (FloatingActionButton) findViewById(R.id.detailButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = getIntent().getStringExtra("NAMA_LOKASI");
                String detail = getIntent().getStringExtra("DETAIL_LOKASI");
                Intent konten = new Intent(DetailActivity.this, KeteranganActivity.class);
                konten.putExtra("name", nama);
                konten.putExtra("ditel", detail);
                startActivity(konten);
            }
        });
        // Inisialisasi
        Gambar = (ImageView) findViewById(R.id.Gambar);
        Nama = (TextView) findViewById(R.id.Nama);
        Telp = (TextView) findViewById(R.id.Telp);
        Alamat = (TextView) findViewById(R.id.Alamat);
        Profil = (TextView) findViewById(R.id.Profil);
        // Jalankan method tampil detail berita
        showDetailLokasi();
    }
    private void showDetailLokasi() {

        // Tangkap data dari intent
        String nama = getIntent().getStringExtra("NAMA_LOKASI");
        String telp = getIntent().getStringExtra("TELP_LOKASI");
        String profil = getIntent().getStringExtra("PROFIL_LOKASI");

        String gambar = getIntent().getStringExtra("GAMBAR_LOKASI");
        String alamat = getIntent().getStringExtra("ALAMAT_LOKASI");

        // Set judul actionbar / toolbar
        getSupportActionBar().setTitle(nama);
        // Set ke widget
        Telp.setText(telp);
        Nama.setText(nama);
        Profil.setText(profil);
        Alamat.setText(alamat);
        // Untuk gambar berita
        Picasso.with(this).load(gambar).into(Gambar);
        // Set isi berita sebagai html ke WebView

    }
}