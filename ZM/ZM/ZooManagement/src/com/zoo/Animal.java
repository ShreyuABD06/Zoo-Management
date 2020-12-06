package com.zoo;

public class Animal {
	private int AnimalId;
	private String animalName;
	private DIET diet;
	private DANGER danger;
	private SPECIAL special;
	private int zooId;

	public int getAnimalId() {
		return AnimalId;
	}

	public void setAnimalId(int animalId) {
		AnimalId = animalId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public DIET getDiet() {
		return diet;
	}

	public void setDiet(DIET diet) {
		this.diet = diet;
	}

	public DANGER getDanger() {
		return danger;
	}

	public void setDanger(DANGER danger) {
		this.danger = danger;
	}
	

	public SPECIAL getSpecial() {
		return special;
	}

	public void setSpecial(SPECIAL special) {
		this.special = special;
	}

	public int getZooId() {
		return zooId;
	}

	public void setZooId(int zooId) {
		this.zooId = zooId;
	}

	@Override
	public String toString() {
		return "Animal [AnimalId=" + AnimalId + ", animalName=" + animalName + ", diet=" + diet + ", danger=" + danger
				+ ", special=" + special + ", zooId=" + zooId + "]";
	}
}
