package com.zoo;

public class Report {
	private String animalName;
	private String zooName;
	private DIET diet;
	private SEASON season;

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getZooName() {
		return zooName;
	}

	public void setZooName(String zooName) {
		this.zooName = zooName;
	}

	public DIET getDiet() {
		return diet;
	}

	public void setDiet(DIET diet) {
		this.diet = diet;
	}

	public SEASON getSeason() {
		return season;
	}

	public void setSeason(SEASON season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "Report [animalName=" + animalName + ", zooName=" + zooName + ", diet=" + diet + ", season=" + season
				+ "]";
	}

}
