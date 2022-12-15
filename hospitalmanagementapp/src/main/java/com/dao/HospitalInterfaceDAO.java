package com.dao;

import java.util.ArrayList;

import com.model.Hospital;

public interface HospitalInterfaceDAO {
	public boolean insertPatient(Hospital hospital);
	public ArrayList<Hospital> viewAllPatient();
	public Hospital viewPatientById(int id);
	public boolean updatePatient(Hospital hospital);
	public boolean deletePatientById(int id);
}
