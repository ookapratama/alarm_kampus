package com.example.alarm_kampus.model.login;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("stb")
	private String stb;

	@SerializedName("alm")
	private String alm;

	@SerializedName("nmmhs")
	private String nmmhs;

	@SerializedName("nohp")
	private String nohp;

	@SerializedName("email")
	private String email;

	public  DataItem(String stb, String alm, String nmmhs, String nohp, String email) {
		this.stb = stb;
		this.alm = alm;
		this.nmmhs = nmmhs;
		this.nohp = nohp;
		this.email = email;
	}

	public String getStb(){
		return stb;
	}

	public String getAlm(){
		return alm;
	}

	public String getNmmhs(){
		return nmmhs;
	}

	public String getNohp(){
		return nohp;
	}

	public String getEmail(){
		return email;
	}
}