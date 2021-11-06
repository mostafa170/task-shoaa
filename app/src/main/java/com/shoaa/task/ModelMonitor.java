package com.shoaa.task;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ModelMonitor implements Serializable {

	public ModelMonitor(String nameOwer, String img3, String notese, String monitorPosition, String monitoringDate, String img2, String img1, String monitorName, String address) {
		this.nameOwer = nameOwer;
		this.img3 = img3;
		this.notese = notese;
		this.monitorPosition = monitorPosition;
		this.monitoringDate = monitoringDate;
		this.img2 = img2;
		this.img1 = img1;
		this.monitorName = monitorName;
		this.address = address;
	}

	@SerializedName("name_ower")
	private String nameOwer;

	@SerializedName("img3")
	private String img3;

	@SerializedName("notese")
	private String notese;

	@SerializedName("monitor_position")
	private String monitorPosition;

	@SerializedName("monitoring_date")
	private String monitoringDate;

	@SerializedName("img2")
	private String img2;

	@SerializedName("img1")
	private String img1;

	@SerializedName("monitor_name")
	private String monitorName;

	@SerializedName("address")
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNameOwer(String nameOwer){
		this.nameOwer = nameOwer;
	}

	public String getNameOwer(){
		return nameOwer;
	}

	public void setImg3(String img3){
		this.img3 = img3;
	}

	public String getImg3(){
		return img3;
	}

	public void setNotese(String notese){
		this.notese = notese;
	}

	public String getNotese(){
		return notese;
	}

	public void setMonitorPosition(String monitorPosition){
		this.monitorPosition = monitorPosition;
	}

	public String getMonitorPosition(){
		return monitorPosition;
	}

	public void setMonitoringDate(String monitoringDate){
		this.monitoringDate = monitoringDate;
	}

	public String getMonitoringDate(){
		return monitoringDate;
	}

	public void setImg2(String img2){
		this.img2 = img2;
	}

	public String getImg2(){
		return img2;
	}

	public void setImg1(String img1){
		this.img1 = img1;
	}

	public String getImg1(){
		return img1;
	}

	public void setMonitorName(String monitorName){
		this.monitorName = monitorName;
	}

	public String getMonitorName(){
		return monitorName;
	}

	@Override
 	public String toString(){
		return 
			"ModelMonitor{" + 
			"name_ower = '" + nameOwer + '\'' + 
			",img3 = '" + img3 + '\'' + 
			",notese = '" + notese + '\'' + 
			",monitor_position = '" + monitorPosition + '\'' + 
			",monitoring_date = '" + monitoringDate + '\'' + 
			",img2 = '" + img2 + '\'' + 
			",img1 = '" + img1 + '\'' + 
			",monitor_name = '" + monitorName + '\'' + 
			"}";
		}
}