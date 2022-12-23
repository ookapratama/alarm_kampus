package com.example.alarm_kampus.model.login;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("stb")
	private String stb;



	@SerializedName("nmmhs")
	private String nmmhs;



	public  DataItem(String stb, String nmmhs) {
		this.stb = stb;
		this.nmmhs = nmmhs;
	}

	public String getStb(){
		return stb;
	}

	public String getNmmhs(){
		return nmmhs;
	}

}