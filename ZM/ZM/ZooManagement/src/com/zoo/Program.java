package com.zoo;

import java.sql.Date;
import java.sql.Time;

public class Program {
	private int programId;
	private String programName;
	private int animalId;
	private int zooId;
	private Date date;
	private Time showTime;
	private int seatsAvailable;
	private SEASON season;

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public int getZooId() {
		return zooId;
	}

	public void setZooId(int zooId) {
		this.zooId = zooId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvalable) {
		this.seatsAvailable = seatsAvalable;
	}

	public SEASON getSeason() {
		return season;
	}

	public void setSeason(SEASON season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", animalId=" + animalId
				+ ", zooId=" + zooId + ", date=" + date + ", showTime=" + showTime + ", seatsAvailable=" + seatsAvailable
				+ ", season=" + season + "]";
	}
}
