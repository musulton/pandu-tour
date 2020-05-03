package com.musulton.pandutour.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseLokasi{

	@SerializedName("lokasi")
	private List<LokasiItem> lokasi;

	@SerializedName("status")
	private boolean status;

	public void setLokasi(List<LokasiItem> lokasi){
		this.lokasi = lokasi;
	}

	public List<LokasiItem> getLokasi(){
		return lokasi;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseLokasi{" + 
			"lokasi = '" + lokasi + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}