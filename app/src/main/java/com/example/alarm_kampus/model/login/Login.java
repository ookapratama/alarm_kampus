package com.example.alarm_kampus.model.login;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("data")
	private List<DataItem> data;

	public List<DataItem> getData(){
		return data;
	}
}