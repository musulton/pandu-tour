package com.musulton.pandutour.response;

import com.google.gson.annotations.SerializedName;

public class LokasiItem{

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("telp")
	private String telp;

	@SerializedName("nama")
	private String nama;

	@SerializedName("profil")
	private String profil;

	@SerializedName("detail")
	private String detail;

	@SerializedName("latittude")
	private String latittude;

	@SerializedName("kategori")
	private String kategori;

	@SerializedName("id")
	private String id;

	@SerializedName("gambar")
	private String gambar;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("longitude")
	private String longitude;

	public void setDetail(String Detail){
		this.detail = detail;
	}

	public String getDetail(){
		return detail;
	}

	public void setTelp(String telp){
		this.telp = telp;
	}

	public String getTelp(){
		return telp;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setProfil(String profil){
		this.profil = profil;
	}

	public String getProfil(){
		return profil;
	}

	public String getLatittude(){
		return latittude;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setGambar(String gambar){
		this.gambar = gambar;
	}

	public String getGambar(){
		return gambar;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"LokasiItem{" + 
			"detail = '" + detail + '\'' +
			",telp = '" + telp + '\'' + 
			",nama = '" + nama + '\'' + 
			",profil = '" + profil + '\'' + 
			",latittude = '" + latittude + '\'' + 
			",kategori = '" + kategori + '\'' + 
			",id = '" + id + '\'' + 
			",gambar = '" + gambar + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}