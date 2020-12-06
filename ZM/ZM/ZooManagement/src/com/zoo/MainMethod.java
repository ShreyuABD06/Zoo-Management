package com.zoo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainMethod {
	public static void main(String[] args) {
		ZooManagement c = new ZooManagement();
		Scanner sc = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("*******************Welcome To Zoo Management System****************");
				System.out.println("1:Add ZOo");
				System.out.println("2:ADD Animal");
				System.out.println("3:ADD Program");
				System.out.println("4:View Zoos");
				System.out.println("5:View Open Zoos");
				System.out.println("6:VIEW  Animals");
				System.out.println("7:View Animals By ZooIs");
				System.out.println("8:View Dangerous ANimals");
				System.out.println("9:View Special animals");
				System.out.println("10:Get All Programs");
				System.out.println("11:Get Programs By Season");
				
				System.out.println("Reports");
				System.out.println("");
				System.out.println("12:Get Animals By Program");
				System.out.println("13;Get Zoos By Program");
				System.out.println("14:Get Programs By Animal");
				
				System.out.println("Update");
				System.out.println();
				System.out.println("15:Update Zoo Status");
				System.out.println("16:Update SpeciAL Animal Flag");
				System.out.println("17:Update Seasonal Flag of the Program");
				System.out.println("18:Search Zoo By zoo id");
				System.out.println("19:Search Animal By Id");
				System.out.println("20:Search program By Id");
				System.out.println("21:Search ZOO BY Name and Location");
				System.out.println("22:Exit ");
				System.out.println("Enter your choice");
				int choice1 = sc.nextInt();
				switch (choice1) {
				case 1:
					Zoo zoo = new Zoo();
					String s2 = c.addZoo(zoo);
					if (s2 != null) {
						System.out.println(s2);
					} else {
						System.out.println("Zoo could nOt Be Added");
					}
					break;

				case 2:
					Animal b1 = new Animal();
					String s1 = c.addAnimal(b1);
					if (s1 != null) {
						System.out.println(s1);
					} else {
						System.out.println("Animal could nOt Be Added");
					}
					break;
				case 3:
					Program b2 = new Program();
					String sz = c.addProgram(b2);
					if (sz != null) {
						System.out.println(sz);
					} else {
						System.out.println("Program could nOt Be Added");
					}
					break;

				case 4:
					List<Zoo> list = c.getZoos();

					if (list != null) {
						System.out.println("....Zoos List....");
						System.out.println("*******************");
						Iterator<Zoo> itr = list.iterator();
						while (itr.hasNext()) {
							System.out.println(itr.next());
						}
					} else {
						System.out.println("No Zoos");
					}
					break;
				case 5:
					List<Zoo> list1 = c.getOpenZoos();
					if (list1 != null) {
						System.out.println("....Open Zoos List....");
						System.out.println("*******************");
						Iterator<Zoo> itr = list1.iterator();
						while (itr.hasNext()) {
							System.out.println(itr.next());
						}
					} else {
						System.out.println("No Open Zoos");
					}
					break;
				case 6:
						List<Animal> list2 = c.getAnimals();
						if (list2 != null) {
							System.out.println("....Open Zoos List....");
							System.out.println("*******************");
							Iterator<Animal> itr = list2.iterator();
							while (itr.hasNext()) {
								System.out.println(itr.next());
							}
						} else {
							System.out.println("No Animals Under You");
						}
						break;
				case 7:
					
					System.out.println("Enter Zoo Id To Find Animals in the zoo");
					int zooId=sc.nextInt();
						List<Animal> list3 = c.getAnimalsByZoo(zooId);
						if (list3 != null) {
							System.out.println("....Animals in zoo ....");
							System.out.println("*******************");
							Iterator<Animal> itr = list3.iterator();
							while (itr.hasNext()) {
								System.out.println(itr.next());
							}
						} else {
							System.out.println("No Animals in Zoo "+zooId);
						}
						break;
				case 8:
					
						List<Animal> list4 = c.getAnimalsByDanger();
						if (list4 != null) {
							System.out.println("....Dangerous ANimals List....");
							System.out.println("*******************");
							Iterator<Animal> itr = list4.iterator();
							while (itr.hasNext()) {
								System.out.println(itr.next());
							}
						} else {
							System.out.println("No Dangerous Animals");
						}
						break;
				case 9:
						List<Animal> list5 = c.getAllSpecialAnimals();
						if (list5 != null) {
							System.out.println("....Sppecial Animals List....");
							System.out.println("*******************");
							Iterator<Animal> itr = list5.iterator();
							while (itr.hasNext()) {
								System.out.println(itr.next());
							}
						} else {
							System.out.println("No Special Animals");
						}
						break;
				case 10:
					List<Program> list6 = c.getAllPrograms();
					if (list6 != null) {
						System.out.println("....All Programs....");
						System.out.println("*******************");
						Iterator<Program> itr = list6.iterator();
						while (itr.hasNext()) {
							System.out.println(itr.next());
						}
					} else {
						System.out.println("No Programs");
					}
					break;
				case 11:
					System.out.println("ENter the Season (WINTER/RAINY/SUMMER");
					SEASON season = SEASON.valueOf(sc.next());
					List<Program> list7= c.getAllProgramsBySeason(season);
					if (list7 != null) {
						System.out.println("....Programs By Seasons ....");
						System.out.println("*******************");
						Iterator<Program> itr = list7.iterator();
						while (itr.hasNext()) {
							System.out.println(itr.next());
						}
					} else {
						System.out.println("No Programs in the season");
					}
					break;
				case 12:
					System.out.println("ENter the ProgramId");
					int season1 = sc.nextInt();
					List<Report> list9 = c.getAnimalsByShow(season1);
					if (list9 != null) {
						System.out.println("....All Animals In Season....");
						System.out.println("*******************");
						Iterator<Report> itr = list9.iterator();
						while (itr.hasNext()) {
							System.out.println(itr.next());
						}
					} else {
						System.out.println("No Animals");
					}
					break;
				case 13:
					System.out.println("Enter program Id");
					int programId=sc.nextInt();
					List<Report1> list15 = c.getZooByShow(programId);
					if (list15 != null) {
						System.out.println("....All Animals In Season....");
						System.out.println("*******************");
						Iterator<Report1> itr = list15.iterator();
						while (itr.hasNext()) {
							System.out.println(itr.next());
						}
					} else {
						System.out.println("No Zoos");
					}
					break;
				case 14:
				System.out.println("Enter Animal Id");
				int animalId=sc.nextInt();
				List<Program> list8= c.getAllProgramsByAnimal(animalId);
				if (list8 != null) {
					System.out.println("....Programs By animal ....");
					System.out.println("*******************");
					Iterator<Program> itr = list8.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Programs for this animal");
				}
				break;
				case 15:
					Zoo v1 = new Zoo();
					v1 = c.updateZoo(v1);
					System.out.println("Updating Zoo's Status ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println(
							"------------------------------------****Zoo's Status after Update****-----------------------------------");
					System.out.println(v1);
					break;

				case 16:
					Animal i3 = new Animal();
					i3 = c.updateAnimal(i3);
					System.out.println("Please wait .......................... ");
					System.out.println("After Update..");
					System.out.println(i3);
					break;
				case 17:
					Program i4 = new Program();
					i4 = c.updateProgram(i4);
					System.out.println("Please wait .......................... ");
					System.out.println("After Update..");
					System.out.println(i4);
					break;
				case 18:
					Zoo stud1 = new Zoo();
					System.out.println("Enter Zoo Id to get Zoo");
					int sId = sc.nextInt();
					stud1 = c.getZooById(sId);
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if(stud1!=null){
					System.out.println(stud1);
					}else{
						System.out.println("Zoo with Id "+sId+" Not Found");
					}
					break;
				case 19:
					Animal stud2 = new Animal();
					System.out.println("Enter Animal Id to get Animal");
					int sId2 = sc.nextInt();
					stud2 = c.getAnimalById(sId2);
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if(stud2!=null){
					System.out.println(stud2);
					}else{
						System.out.println("Animal with Id "+sId2+" Not Found");
					}
					break;
				case 20:
					Program stud3 = new Program();
					System.out.println("Enter Program Id to get Program");
					int sId3 = sc.nextInt();
					stud3 = c.getProgramById(sId3);
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if(stud3!=null){
					System.out.println(stud3);
					}else{
						System.out.println("Program with Id "+sId3+" Not Found");
					}
					break;
				case 21:
					Zoo instr = new Zoo();
					System.out.println("Enter name of the Zoo to Be Searched");
					String iName = sc.next();
					System.out.println("Enter location of the Zoo to Be Searched");
					String location = sc.next();
					instr = c.findZoo(iName, location);
					if(instr!=null){
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println(instr);
					}else{
						System.out.println("Zoo Not Found");
					}
					break;
				case 22:
					System.out.println("Thank You");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
