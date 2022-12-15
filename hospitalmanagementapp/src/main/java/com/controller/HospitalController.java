package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HospitalInterfaceDAO;
import com.dao.HospitalInterfaceDAOImpl;
import com.dao.UserInterfaceDAO;
import com.dao.UserInterfaceDAOImpl;
import com.model.Hospital;
import com.model.User;

/**
 * Servlet implementation class HospitalController
 */
public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	HospitalInterfaceDAO hifi = null;
	UserInterfaceDAO uifi=null;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HospitalController() {
		hifi = new HospitalInterfaceDAOImpl();
		uifi=new UserInterfaceDAOImpl();
		
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println(action);
		if (action == null) {
			action = "LOGIN";
		}
		switch (action) {
		case "ADD":
			insertpatient(request, response);
			break;
		case "LIST":
			patientlist(request, response);
			break;
		case "EDIT":
			singalpatient(request, response);
			break;
		case "DELETE":
			deletepatient(request, response);
			break;
		case "LOGIN":
			userlogin(request,response);
			break;
		case "ADDUSER":
			insetuser(request,response);
			break;

		default:
			patientlist(request, response);
			break;
		}
	}

	private void insetuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("uname");
		String password=request.getParameter("upassword");
		User user=new User(name,password);
		if(uifi.insertUser(user)) {
			request.setAttribute("NOTIFICATION", "User inserted succesfully");
			dispatcher=request.getRequestDispatcher("/views/login_form.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("NOTIFICATION", "Some thing went wrong");
			dispatcher=request.getRequestDispatcher("/views/user_signup.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void userlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("uname");
		String password=request.getParameter("upassword");
		User user=new User(name,password);
		if(uifi.loginUser(user)) {
			request.setAttribute("NOTIFICATION", "USER login succesfully");
			dispatcher =request.getRequestDispatcher("/views/patient_form.jsp");
		
		}
		else {
			request.setAttribute("NOTIFICATION", "Some thing went wrong");
			dispatcher=request.getRequestDispatcher("/views/login_form.jsp");
		}	dispatcher.forward(request, response);	
	}

	private void deletepatient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if (hifi.deletePatientById(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Delete patient succesfully");
		}
		patientlist(request, response);

	}

	private void singalpatient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Hospital theHospital = hifi.viewPatientById(Integer.parseInt(id));
		request.setAttribute("hospital", theHospital);
		dispatcher = request.getRequestDispatcher("/views/patient_form.jsp");
		dispatcher.forward(request, response);
	}

	private void patientlist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Hospital> al = hifi.viewAllPatient();
		request.setAttribute("list", al);
		dispatcher = request.getRequestDispatcher("/views/patient_list.jsp");
		dispatcher.forward(request, response);

	}

	private void insertpatient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println(id);
		Hospital hospital = new Hospital();
		hospital.setName(request.getParameter("name"));
		hospital.setEmail(request.getParameter("email"));
		hospital.setAddress(request.getParameter("address"));
		hospital.setContact(request.getParameter("contact"));

		if (id.isEmpty() || id == null) {
			if (hifi.insertPatient(hospital)) {
				request.setAttribute("NOTIFICATION", "Insert Patient add succesfully");
			} 
		}else {
				hospital.setId(Integer.parseInt(id));
				if (hifi.updatePatient(hospital)) {
					request.setAttribute("NOTIFICATION", "Update Patient add succesfully");
				}
			
		}
		patientlist(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
