package com.musulton.pandutour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.musulton.pandutour.response.LokasiItem;
import com.squareup.picasso.Picasso;
import java.util.List;
/**
 * Created by Muhammad Sulton on 18/08/18.
 * @musulton
 */
class AdapterLokasi extends RecyclerView.Adapter<AdapterLokasi.MyViewHolder> {
    // Buat Global variable untuk manampung context
    Context context;
    List<LokasiItem> lokasi;
    public AdapterLokasi(Context context, List<LokasiItem> data_lokasi) {
        // Inisialisasi
        this.context = context;
        this.lokasi = data_lokasi;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.lokasi_item, parent, false);
        // Hubungkan dengan MyViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // Set widget
        holder.Nama.setText(lokasi.get(position).getNama());
        holder.Alamat.setText(lokasi.get(position).getAlamat());

        // Dapatkan url gambar
        final String urlGambar = "http://192.168.43.157/sig/uploads/images/" + lokasi.get(position).getGambar();
        // Set image ke widget dengna menggunakan Library Piccasso
        // karena imagenya dari internet
        Picasso.with(context).load(urlGambar).into(holder.Gambar);
        // Event klik ketika item list nya di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mulai activity Detail
                Intent varIntent = new Intent(context, DetailActivity.class);
                // sisipkan data ke intent
                varIntent.putExtra("NAMA_LOKASI", lokasi.get(position).getNama());
                varIntent.putExtra("TELP_LOKASI", lokasi.get(position).getTelp());
                varIntent.putExtra("DETAIL_LOKASI", lokasi.get(position).getDetail());
                varIntent.putExtra("GAMBAR_LOKASI", urlGambar);
                varIntent.putExtra("PROFIL_LOKASI", lokasi.get(position).getProfil());
                varIntent.putExtra("ALAMAT_LOKASI", lokasi.get(position).getAlamat());
                varIntent.putExtra("LONG_LOKASI", lokasi.get(position).getLongitude());
                varIntent.putExtra("LATI_LOKASI", lokasi.get(position).getLatittude());
                // method startActivity cma bisa di pake di activity/fragment
                // jadi harus masuk ke context dulu
                context.startActivity(varIntent);
            }
        });
    }
    // Menentukan Jumlah item yang tampil
    @Override
    public int getItemCount() {
        return lokasi.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Deklarasi widget
        ImageView Gambar;
        TextView Nama, Telp, Alamat;
        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi widget
            Gambar = (ImageView) itemView.findViewById(R.id.Gambar);
            Nama = (TextView) itemView.findViewById(R.id.Nama);

            Alamat = (TextView) itemView.findViewById(R.id.Alamat);
        }
    }
}
