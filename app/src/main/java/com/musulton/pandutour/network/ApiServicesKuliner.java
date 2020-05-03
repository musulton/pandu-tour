package com.musulton.pandutour.network;

import com.musulton.pandutour.response.ResponseLokasi;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Muhammad Sulton on 18/08/18.
 * @musulton
 */

public interface ApiServicesKuliner {

    //@TIPEMETHOD("API_END_POINT")
    @GET("lokasi_kuliner.php")
    Call<ResponseLokasi> request_show_all_lokasi();
    // <ModelData> nama_method()

}