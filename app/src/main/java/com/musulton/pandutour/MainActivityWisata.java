package com.musulton.pandutour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.musulton.pandutour.network.ApiServicesWisata;
import com.musulton.pandutour.network.InitRetrofitWisata;
import com.musulton.pandutour.response.LokasiItem;
import com.musulton.pandutour.response.ResponseLokasi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityWisata extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inisialisasi Widget
        recyclerView = (RecyclerView) findViewById(R.id.List);
        // RecyclerView harus pakai Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Eksekusi method

        tampilLokasi();


    }
    private void tampilLokasi() {

        ApiServicesWisata api = InitRetrofitWisata.getInstance();
        // Siapkan request
        Call<ResponseLokasi> lokasiCall = api.request_show_all_lokasi();

        // Kirim request
        lokasiCall.enqueue(new Callback<ResponseLokasi>() {
            @Override
            public void onResponse(Call<ResponseLokasi> call, Response<ResponseLokasi> response) {
                // Pastikan response Sukses
                if (response.isSuccessful()) {
                    Log.d("response api", response.body().toString());
                    // tampung data response body ke variable
                    List<LokasiItem> data_lokasi = response.body().getLokasi();
                    boolean status = response.body().isStatus();
                    // Kalau response status nya = true
                    if (status) {
                        // Buat Adapter untuk recycler view
                        AdapterLokasi adapter = new AdapterLokasi(MainActivityWisata.this, data_lokasi);
                        recyclerView.setAdapter(adapter);
                    } else {
                        // kalau tidak true
                        Toast.makeText(MainActivityWisata.this, "Data masih kosong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLokasi> call, Throwable t) {
                // print ke log jika Error
                t.printStackTrace();
            }
        });
    }

}