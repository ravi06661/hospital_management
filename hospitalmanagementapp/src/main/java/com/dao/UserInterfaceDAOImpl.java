package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;
import com.mysql.cj.protocol.Resultset;
import com.util.DbConnection;

public class UserInterfaceDAOImpl implements UserInterfaceDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String q = null;

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.creation();
			q = "insert into user(uname,upassword) values(?,?)";
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUpassword());
			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User viewUserById(int id) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.creation();
			q = "select * from user where uid='" + id + ",'";
			pstmt = con.prepareStatement(q);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setUpassword(rs.getString(3));
				return u;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.creation();
			q = "update user set uname=?,upassword=? where uid='" + user.getUid() + "'";
			pstmt = con.prepareStatement(q);

			pstmt.setInt(3, user.getUid());
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUpassword());
			if (pstmt.executeUpdate() != 0) {
				System.out.println("user was updated succesfully");
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			con = DbConnection.creation();
			q = "delete from user where uid='" + id + "'";
			pstmt = con.prepareStatement(q);
			if (pstmt.executeUpdate() != 0) {
				System.out.println("user was delete succesfully");
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		try {
			String name = user.getUname();
			String password = user.getUpassword();
			con = DbConnection.creation();
			q = "select * from user";
			pstmt = con.prepareStatement(q);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (name.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
					System.out.println("correct userName and password");
					return true;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
