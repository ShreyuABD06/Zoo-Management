package com.zoo;

import java.sql.Time;

public class Report1 {
	private String zooName;
	private String location;
	private String phoneNo;
	private double entryFee;
	private Time openTime;
	private Time closeTime;
	private STATUS status;
	public String getZooName() {
		return zooName;
	}
	public void setZooName(String zooName) {
		this.zooName = zooName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public double getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(double entryFee) {
		this.entryFee = entryFee;
	}
	public Time getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}
	public Time getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Report1 [zooName=" + zooName + ", location=" + location + ", phoneNo=" + phoneNo + ", entryFee="
				+ entryFee + ", openTime=" + openTime + ", closeTime=" + closeTime + ", status=" + status + "]";
	}
	
}
