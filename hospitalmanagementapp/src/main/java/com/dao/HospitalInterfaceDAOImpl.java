package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Hospital;
import com.mysql.cj.protocol.Resultset;
import com.util.DbConnection;

public class HospitalInterfaceDAOImpl implements HospitalInterfaceDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Hospital hospital = new Hospital();

	public boolean insertPatient(Hospital hospital) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.creation();
		 String	q = "insert into patient_list(name,email,address,contact) values(?,?,?,?)";
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, hospital.getName());
			pstmt.setString(2, hospital.getEmail());
			pstmt.setString(3, hospital.getAddress());
			pstmt.setString(4, hospital.getContact());
			if (pstmt.executeUpdate() != 0) {
				System.out.println("Patient added succesfully");
				return true;

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Hospital> viewAllPatient() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Hospital> al = new ArrayList<Hospital>();
			con = DbConnection.creation();
			 String q = "select * from patient_list";
			pstmt = con.prepareStatement(q);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				hospital = new Hospital();
				hospital.setId(rs.getInt(1));
				hospital.setName(rs.getString(2));
				hospital.setEmail(rs.getString(3));
				hospital.setAddress(rs.getString(4));
				hospital.setContact(rs.getString(5));
				al.add(hospital);

			}
			return al;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public Hospital viewPatientById(int id) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.creation();
			 String q = "select * from patient_list where id='" +id+"'";
			pstmt = con.prepareStatement(q);
			rs = pstmt.executeQuery();
			rs.next();
			hospital=new Hospital();
			hospital.setId(rs.getInt(1));
			hospital.setName(rs.getString(2));
			hospital.setEmail(rs.getString(3));
			hospital.setAddress(rs.getString(4));
			hospital.setContact(rs.getString(5));
			return hospital;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public boolean updatePatient(Hospital hospital) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.creation();
			 String q = "update patient_list set name=?,email=?,address=?,contact=? where id=?";
			pstmt = con.prepareStatement(q);
			pstmt.setInt(5, hospital.getId());
			pstmt.setString(1, hospital.getName());
			pstmt.setString(2, hospital.getEmail());
			pstmt.setString(3, hospital.getAddress());
			pstmt.setString(4, hospital.getContact());
			if (pstmt.executeUpdate() != 0) {
				System.out.println("Update succesfully");
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePatientById(int id) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.creation();
			 String q = "delete from patient_list where id='"+id+"'";
			pstmt = con.prepareStatement(q);
			if (pstmt.executeUpdate() != 0) {
				System.out.println("deleted succesfully");
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
