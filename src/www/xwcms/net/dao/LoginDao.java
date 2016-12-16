package www.xwcms.net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import www.xwcms.net.jdbc.Jdbc;

public class LoginDao {

	Connection con=null;
	Statement st=null;
	PreparedStatement pst;
	ResultSet rs=null;
	Jdbc  jdbc=new Jdbc();
	
	public String adminLogin(String adminName,String adminPwd)
	{
		String backValue=null;
		con=jdbc.getcon();
		String sql="select adminId from admin where adminName=? and adminpwd=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1,adminName);
			pst.setString(2,adminPwd);
			rs=pst.executeQuery();
			if(rs.next())
			{
				backValue=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			jdbc.closeConnection();
		}
		return backValue;
	}
}
