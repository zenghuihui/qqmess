package www.xwcms.net.jdbc;
import java.sql.*;
public class Jdbc {

	Connection con=null;
	   
	   public Connection getcon()
	   {
		   try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databaseName=cnDate","sa","sa");
			//con=DriverManager.getConnection("Jdbc:odbc:Logging","rr","rr");
			if(con!=null)
			{
				//System.out.println("数据库连接成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		   
	   }
	   public void closeConnection()
	   {
		   try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
}
