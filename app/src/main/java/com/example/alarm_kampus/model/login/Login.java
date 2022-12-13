package com.example.alarm_kampus.model.login;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("data")
	private DataItem loginData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setLoginData(DataItem loginData){
		this.loginData = loginData;
	}

	public DataItem getLoginData(){
		return loginData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}