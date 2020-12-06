package com.zoo;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class ZooManagement {
	DBInteractions db = new DBInteractions();
	Scanner sc = new Scanner(System.in);

	public String addZoo(Zoo i) {
		System.out.println("Enter Zoo Name");
		String bbName = sc.next();
		i.setZooName(bbName);
		System.out.println("Enter Zoo Location");
		String location = sc.next();
		i.setLocation(location);
		System.out.println("Enter PhoneNo");
		String phoneNo = sc.next();
		i.setPhoneNo(phoneNo);
		System.out.println("Enter Entry Fee ");
		Double entryFee = sc.nextDouble();
		i.setEntryFee(entryFee);
		System.out.println("Enter Zoo Open Time((hh:mm:dd)");
		Time openTime = java.sql.Time.valueOf(sc.next());
		i.setOpenTime(openTime);
		System.out.println("Enter Zoo Close Time((hh:mm:dd)");
		Time closeTime = java.sql.Time.valueOf(sc.next());
		i.setCloseTime(closeTime);
		System.out.println("Enter Status of Zoo(OPEN/CLOSED)");
		STATUS status = STATUS.valueOf(sc.next());
		i.setStatus(status);
		String s = db.addZoo(i);
		if (s != null) {
			return s;
		} else {
			return null;
		}
	}

	public String addAnimal(Animal i) {
		System.out.println("Enter Animal Name");
		String bbName = sc.next();
		i.setAnimalName(bbName);
		System.out.println("Enter DIET TYPE(HERBIVORE/OMNIVORE/CARNIVORE)");
		DIET diet = DIET.valueOf(sc.next());
		i.setDiet(diet);
		System.out.println("IS Animal DAngerous(Y/N)");
		DANGER danger = DANGER.valueOf(sc.next());
		i.setDanger(danger);
		System.out.println("Is It Under Special case(Y/N) ");
		SPECIAL special = SPECIAL.valueOf(sc.next());
		i.setSpecial(special);
		;
		System.out.println("Ener The zoo Id to which The animal Belongs");
		int zooId = sc.nextInt();
		i.setZooId(zooId);
		String s = db.addAnimal(i);
		if (s != null) {
			return s;
		} else {
			return null;
		}
	}

	public String addProgram(Program i) {
		System.out.println("Enter Program Name");
		String bbName = sc.next();
		i.setProgramName(bbName);
		System.out.println("Enter AnimalId");
		int animalId = sc.nextInt();
		i.setAnimalId(animalId);
		System.out.println("Enter zooId");
		int zooId = sc.nextInt();
		i.setZooId(zooId);
		System.out.println("Enter Date(yyyy-mm-dd) ");
		Date date = java.sql.Date.valueOf(sc.next());
		i.setDate(date);
		System.out.println("Enter Program Show Time((hh:mm:dd)");
		Time showTime = java.sql.Time.valueOf(sc.next());
		i.setShowTime(showTime);
		System.out.println("Enter Seats Available");
		int seatsAvailable = sc.nextInt();
		i.setSeatsAvailable(seatsAvailable);
		System.out.println("Enter SEASON of Program(WINTER/SUMMER?RAINY)");
		SEASON season = SEASON.valueOf(sc.next());
		i.setSeason(season);
		String s = db.addProgram(i);
		if (s != null) {
			return s;
		} else {
			return null;
		}
	}

	public Zoo updateZoo(Zoo updatedValue) {
		System.out.println("Enter Zoo Id to Be Updated");
		int id = sc.nextInt();
		updatedValue = getZooById(id);
		System.out.println("Enter the Status Of Zoo To Be Updated(OPEN/CLOSED)");
		STATUS status = STATUS.valueOf(sc.next());
		updatedValue.setStatus(status);
		return updatedValue = db.updateZoo(updatedValue);
	}

	public Animal updateAnimal(Animal updatedValue) {
		System.out.println("Enter Animal Id to Be Updated");
		int id = sc.nextInt();
		updatedValue = getAnimalById(id);
		System.out.println("Is it a special Animal(Y/N)");
		SPECIAL special = SPECIAL.valueOf(sc.next());
		updatedValue.setSpecial(special);
		return updatedValue = db.updateAnimal(updatedValue);
	}

	public Program updateProgram(Program updatedValue) {
		System.out.println("Enter program Id to Be Updated");
		int id = sc.nextInt();
		updatedValue = getProgramById(id);
		System.out.println("Enter the Seasonal Flag To Be Updated(WINTER/SUMMER/RAINY)");
		SEASON season = SEASON.valueOf(sc.next());
		updatedValue.setSeason(season);
		return updatedValue = db.updateProgram(updatedValue);
	}

	public Program getProgramById(int id) {
		Program prog = db.getProgramById(id);
		if (prog != null) {
			return prog;
		} else {
			return null;
		}
	}

	public Animal getAnimalById(int id) {
		Animal prog = db.getAnimalById(id);
		if (prog != null) {
			return prog;
		} else {
			return null;
		}
	}

	public Zoo getZooById(int id) {
		Zoo prog = db.getZooById(id);
		if (prog != null) {
			return prog;
		} else {
			return null;
		}
	}

	public List<Zoo> getZoos() {
		List<Zoo> instList = db.getZoos();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public List<Zoo> getOpenZoos() {
		List<Zoo> instList = db.getOpenZoos();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public List<Animal> getAnimals() {
		List<Animal> instList = db.getAnimals();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public List<Animal> getAnimalsByDanger() {
		List<Animal> instList = db.getAnimalsByDanger();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}
	public List<Animal> getAllSpecialAnimals() {
		List<Animal> instList = db.getAllSpecialAnimals();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}
	public List<Animal> getAnimalsByZoo(int zooId) {
		List<Animal> instList = db.getAnimalsByZoo(zooId);
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public List<Program> getAllPrograms() {
		List<Program> instList = db.getAllPrograms();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}
	
	public List<Program> getAllProgramsByAnimal(int animalId) {
		List<Program> instList = db.getAllProgramsByAnimal(animalId);
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}
	public List<Program> getAllProgramsBySeason(SEASON season) {
		List<Program> instList = db.getAllProgramsBySeason(season);
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public List<Report> getAnimalsByShow(int showId) {
		List<Report> instList = db.getAnimalsByShow(showId);
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}
	
	public List<Report1> getZooByShow(int showId) {
		List<Report1> instList = db.getZooByShow(showId);
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public Zoo findZoo(String iName, String location) {
		Zoo r = new Zoo();
		r = db.findZoo(iName, location);
		if (r != null) {
			return r;
		} else {
			return null;
		}
	}

}
