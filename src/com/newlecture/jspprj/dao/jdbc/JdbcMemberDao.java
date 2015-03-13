package com.newlecture.jspprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.jspprj.dao.MemberDao;
import com.newlecture.jspprj.model.Member;
import com.newlecture.jspprj.model.Notice;

public class JdbcMemberDao implements MemberDao {

	@Override
	public Member getMember(String uid) {
		String sql = "SELECT * FROM Members WHERE Mid=?";

		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uid);
			
			ResultSet rs = st.executeQuery();

			rs.next();

			// 모델 마련하기
			Member m = new Member();
			m.setUid(rs.getString("Mid"));
			m.setPwd(rs.getString("Pwd"));
			m.setName(rs.getString("Name"));
			
			rs.close();
			st.close();
			con.close();
			return m;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
