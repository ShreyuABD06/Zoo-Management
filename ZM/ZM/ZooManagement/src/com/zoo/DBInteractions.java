package com.zoo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInteractions {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Statement stmt = null;

	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/zoo";
		try {
			con = DriverManager.getConnection(url, "root", "mysql123");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return con;
	}

	public void close() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (pst != null)
			try {
				pst.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}

	}

	public String addZoo(Zoo i) {
		try {
			con = getConnection();
			String query = "insert into Zoo(zooName,location,phoneNo,entryFee,openTime,closeTime,status) values(?,?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, i.getZooName());
			pst.setString(2, i.getLocation());
			pst.setString(3, i.getPhoneNo());
			pst.setDouble(4, i.getEntryFee());
			pst.setTime(5, i.getOpenTime());
			pst.setTime(6, i.getCloseTime());
			pst.setString(7, i.getStatus().name());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return "Zoo Added Successfully";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public Zoo updateZoo(Zoo value) {
		try {
			con = getConnection();
			String query = "update Zoo set status=? where zooId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, value.getStatus().name());
			pst.setInt(2, value.getZooId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return value;
	}

	public List<Zoo> getZoos() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Zoo inst = null;
		List<Zoo> instList = new ArrayList<Zoo>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Zoo";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Zoo();
				inst.setZooId(rs.getInt(1));
				inst.setZooName(rs.getString(2));
				inst.setLocation(rs.getString(3));
				inst.setPhoneNo(rs.getString(4));
				inst.setEntryFee(rs.getDouble(5));
				inst.setOpenTime(rs.getTime(6));
				inst.setCloseTime(rs.getTime(7));
				inst.setStatus(STATUS.valueOf(rs.getString(8)));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}

	public List<Zoo> getOpenZoos() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Zoo inst = null;
		List<Zoo> instList = new ArrayList<Zoo>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Zoo where status='OPEN'";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Zoo();
				inst.setZooId(rs.getInt(1));
				inst.setZooName(rs.getString(2));
				inst.setLocation(rs.getString(3));
				inst.setPhoneNo(rs.getString(4));
				inst.setEntryFee(rs.getDouble(5));
				inst.setOpenTime(rs.getTime(6));
				inst.setCloseTime(rs.getTime(7));
				inst.setStatus(STATUS.valueOf(rs.getString(8)));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}
	
	public String addAnimal(Animal i) {
		try {
			con = getConnection();
			String query = "insert into Animal(animalName,diet,danger,special,zooId) values(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, i.getAnimalName());
			pst.setString(2, i.getDiet().name());
			pst.setString(3, i.getDanger().name());
			pst.setString(4, i.getSpecial().name());
			pst.setInt(5, i.getZooId());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return "Animal Added Successfully";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public Animal updateAnimal(Animal value) {
		try {
			con = getConnection();
			String query = "update Animal set special=? where animalId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, value.getSpecial().name());
			pst.setInt(2, value.getAnimalId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return value;
	}

	public List<Animal> getAnimals() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Animal inst = null;
		List<Animal> instList = new ArrayList<Animal>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Animal";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Animal();
				inst.setAnimalId(rs.getInt(1));
				inst.setAnimalName(rs.getString(2));
				inst.setDiet(DIET.valueOf(rs.getString(3)));
				inst.setDanger(DANGER.valueOf(rs.getString(4)));
				inst.setSpecial(SPECIAL.valueOf(rs.getString(5)));
				inst.setZooId(rs.getInt(6));				
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}

	public List<Animal> getAnimalsByDanger() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Animal inst = null;
		List<Animal> instList = new ArrayList<Animal>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Animal where danger='Y'";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Animal();
				inst.setAnimalId(rs.getInt(1));
				inst.setAnimalName(rs.getString(2));
				inst.setDiet(DIET.valueOf(rs.getString(3)));
				inst.setDanger(DANGER.valueOf(rs.getString(4)));
				inst.setSpecial(SPECIAL.valueOf(rs.getString(5)));
				inst.setZooId(rs.getInt(6));				
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}
	public List<Animal> getAllSpecialAnimals() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Animal inst = null;
		List<Animal> instList = new ArrayList<Animal>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Animal where special='Y'";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Animal();
				inst.setAnimalId(rs.getInt(1));
				inst.setAnimalName(rs.getString(2));
				inst.setDiet(DIET.valueOf(rs.getString(3)));
				inst.setDanger(DANGER.valueOf(rs.getString(4)));
				inst.setSpecial(SPECIAL.valueOf(rs.getString(5)));
				inst.setZooId(rs.getInt(6));				
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}
	public String addProgram(Program show) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String query = "insert into Program(programName,animalId,zooId,date,showTime,seatsAvailable,season) values(?,?,?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, show.getProgramName());
			pst.setInt(2, show.getAnimalId());
			pst.setInt(3, show.getZooId());
			pst.setDate(4, show.getDate());
			pst.setTime(5, show.getShowTime());
			pst.setInt(6, show.getSeatsAvailable());
			pst.setString(7,show.getSeason().name());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return "Program Added Successfully";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	
	public Program updateProgram(Program show) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String query = "Update program set season=? where programId=?";
			pst = con.prepareStatement(query);
			pst.setString(1, show.getSeason().name());
			pst.setInt(2, show.getProgramId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
			
		}
		return show;
	}

	
	public List<Program> getAllPrograms() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Program show = null;
		List<Program> showList = new ArrayList<Program>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Program";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				show = new Program();
				show.setProgramId(rs.getInt(1));
				show.setProgramName(rs.getString(2));
				show.setAnimalId(rs.getInt(3));
				show.setZooId(rs.getInt(4));
				show.setDate(rs.getDate(5));
				show.setShowTime(rs.getTime(6));
				show.setSeatsAvailable(rs.getInt(7));
				show.setSeason(SEASON.valueOf(rs.getString(8)));
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return showList;
	}
	public List<Program> getAllProgramsByAnimal(int animalId) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Program show = null;
		List<Program> showList = new ArrayList<Program>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Program where animalId="+animalId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				show = new Program();
				show.setProgramId(rs.getInt(1));
				show.setProgramName(rs.getString(2));
				show.setAnimalId(rs.getInt(3));
				show.setZooId(rs.getInt(4));
				show.setDate(rs.getDate(5));
				show.setShowTime(rs.getTime(6));
				show.setSeatsAvailable(rs.getInt(7));
				show.setSeason(SEASON.valueOf(rs.getString(8)));
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return showList;
	}
	
	public List<Program> getAllProgramsBySeason(SEASON season) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Program show = null;
		List<Program> showList = new ArrayList<Program>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Program where season=season";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				show = new Program();
				show.setProgramId(rs.getInt(1));
				show.setProgramName(rs.getString(2));
				show.setAnimalId(rs.getInt(3));
				show.setZooId(rs.getInt(4));
				show.setDate(rs.getDate(5));
				show.setShowTime(rs.getTime(6));
				show.setSeatsAvailable(rs.getInt(7));
				show.setSeason(SEASON.valueOf(rs.getString(8)));
				showList.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return showList;
	}
	public List<Animal> getAnimalsByZoo(int zooId) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Animal inst = null;
		List<Animal> instList = new ArrayList<Animal>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from Animal where zooId="+zooId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Animal();
				inst.setAnimalId(rs.getInt(1));
				inst.setAnimalName(rs.getString(2));
				inst.setDiet(DIET.valueOf(rs.getString(3)));
				inst.setDanger(DANGER.valueOf(rs.getString(4)));
				inst.setSpecial(SPECIAL.valueOf(rs.getString(5)));
				inst.setZooId(rs.getInt(6));				
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}
	public List<Report> getAnimalsByShow(int season) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Report inst = null;
		List<Report> instList = new ArrayList<Report>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select a.animalName,z.zooName,a.diet,p.season from Program p inner join Animal a on p.animalId=a.animalId inner join Zoo z on a.zooId=z.zooId where programId="+season;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Report();			
				inst.setAnimalName(rs.getString(2));
				inst.setZooName(rs.getString(2));
				inst.setDiet(DIET.valueOf(rs.getString(3)));
				inst.setSeason(SEASON.valueOf(rs.getString(4)));	
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}

	public List<Report1> getZooByShow(int showId) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Report1 inst = null;
		List<Report1> instList = new ArrayList<Report1>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select z.zooName,z.location,z.phoneNo,z.entryFee,z.openTime,z.closeTime,z.status from Program p inner join zoo z on p.zooId=z.zooId where programId="+showId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Report1();			
				inst.setZooName(rs.getString(1));
				inst.setLocation(rs.getString(2));
				inst.setPhoneNo(rs.getString(3));
				inst.setEntryFee(rs.getDouble(4));
				inst.setOpenTime(rs.getTime(5));
				inst.setCloseTime(rs.getTime(6));
				inst.setStatus(STATUS.valueOf(rs.getString(7)));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return instList;
	}
	
	public Zoo getZooById(int bbNo) {
		Zoo inst = null;
		try {
			con = getConnection();
			String sql = "select * from Zoo where zooId=" + bbNo;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				inst = new Zoo();
				inst.setZooId(rs.getInt(1));
				inst.setZooName(rs.getString(2));
				inst.setLocation(rs.getString(3));
				inst.setPhoneNo(rs.getString(4));
				inst.setEntryFee(rs.getDouble(5));
				inst.setOpenTime(rs.getTime(6));
				inst.setCloseTime(rs.getTime(7));
				inst.setStatus(STATUS.valueOf(rs.getString(8)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return inst;
	}
	public Animal getAnimalById(int bbNo) {
		Animal inst = null;
		try {
			con = getConnection();
			String sql = "select * from Animal where animalId=" + bbNo;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				inst = new Animal();
				inst.setAnimalId(rs.getInt(1));
				inst.setAnimalName(rs.getString(2));
				inst.setDiet(DIET.valueOf(rs.getString(3)));
				inst.setDanger(DANGER.valueOf(rs.getString(4)));
				inst.setSpecial(SPECIAL.valueOf(rs.getString(5)));
				inst.setZooId(rs.getInt(6));	
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return inst;
	}
	
	public Program getProgramById(int bbNo) {
		Program inst = null;
		try {
			con = getConnection();
			String sql = "select * from Program where programId=" + bbNo;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				inst = new Program();
				inst.setProgramId(rs.getInt(1));
				inst.setProgramName(rs.getString(2));
				inst.setAnimalId(rs.getInt(3));
				inst.setZooId(rs.getInt(4));
				inst.setDate(rs.getDate(5));
				inst.setShowTime(rs.getTime(6));
				inst.setSeatsAvailable(rs.getInt(7));
				inst.setSeason(SEASON.valueOf(rs.getString(8)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return inst;
	}

	public Zoo findZoo(String iName, String location) {
		Connection con = null;
		// Statement stmt = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Zoo inst = null;
		try {
			con = getConnection();
			String sql = "select * from Zoo where zooName= ? and location=?";// Not
																				// with
																				// Query
			pst = con.prepareStatement(sql);
			pst.setString(1, iName);
			pst.setString(2, location);
			rs = pst.executeQuery();
			while (rs.next()) {
				inst = new Zoo();
				inst.setZooId(rs.getInt(1));
				inst.setZooName(rs.getString(2));
				inst.setLocation(rs.getString(3));
				inst.setPhoneNo(rs.getString(4));
				inst.setEntryFee(rs.getDouble(5));
				inst.setOpenTime(rs.getTime(6));
				inst.setCloseTime(rs.getTime(7));
				inst.setStatus(STATUS.valueOf(rs.getString(8)));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
			
		}
		return inst;
	}
	
}