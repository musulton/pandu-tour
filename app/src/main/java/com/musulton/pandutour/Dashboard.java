package com.musulton.pandutour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    private CardView pantaiCard, wisataCard, penginapanCard, kulinerCard, aboutCard;
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        pantaiCard = (CardView) findViewById(R.id.pantai_card);
        wisataCard = (CardView) findViewById(R.id.wisata_card);
        penginapanCard = (CardView) findViewById(R.id.penginapan_card);
        kulinerCard = (CardView) findViewById(R.id.kuliner_card);
        aboutCard = (CardView) findViewById(R.id.about_card);

        pantaiCard.setOnClickListener(this);
        wisataCard.setOnClickListener(this);
        penginapanCard.setOnClickListener(this);
        kulinerCard.setOnClickListener(this);
        aboutCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.pantai_card :
                i = new Intent(Dashboard.this, MainActivityPantai.class);
                i.putExtra("title", "Destinasi Pantai");
                startActivity(i);
                break;
            case R.id.wisata_card :
                i = new Intent(Dashboard.this, MainActivityWisata.class);
                i.putExtra("title", "Destinasi Wisata");
                startActivity(i);
                break;
            case R.id.penginapan_card :
                i = new Intent (Dashboard.this, MainActivityPenginapan.class);
                i.putExtra("title", "Destinasi Penginapan");
                startActivity(i);
                break;
            case R.id.kuliner_card :
                i = new Intent(Dashboard.this, MainActivityKuliner.class);
                i.putExtra("title", "Destinasi Kuliner");
                startActivity(i);
                break;
            case R.id.about_card :
                i = new Intent(Dashboard.this, MainActivityAbout.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed()
    {
        if(mBackPressed + TIME_INTERVAL > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(getBaseContext(), "Tekan sekali lagi untuk keluar aplikasi", Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();

    }
}
