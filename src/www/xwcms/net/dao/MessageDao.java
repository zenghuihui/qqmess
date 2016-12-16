package www.xwcms.net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import www.xwcms.net.bean.Message;
import www.xwcms.net.jdbc.Jdbc;

public class MessageDao {


	Connection con=null;
	Statement st=null;
	PreparedStatement pst;
	ResultSet rs=null;
	Jdbc  jdbc=new Jdbc();
	/**
	 * �鿴����������Ϣ
	 */
		@SuppressWarnings("unchecked")
		public List messageList() {
			// TODO Auto-generated method stub
			List list=new ArrayList();
			con=jdbc.getcon();
			String sql="select * from message order by messageTime desc";
			try {
				pst=con.prepareStatement(sql);
				rs=pst.executeQuery();
				while(rs.next())
				{
					Message message=new Message();
					message.setMessageId(rs.getString("messageId"));
					message.setMessageName(rs.getString("messageName"));
					message.setMessageSex(rs.getString("messageSex"));
					message.setMessageEmail(rs.getString("messageEmail"));
					message.setMessageQQ(rs.getString("messageQQ"));
					message.setMessageTel(rs.getString("messageTel"));
					message.setMessageAdd(rs.getString("messageAdd"));
					message.setMessageCont(rs.getString("messageCont"));
					message.setMessageTime(rs.getString("messageTime"));
					list.add(message);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				jdbc.closeConnection();
			}
			
			
			return list;
		}
		/**
		 * ��������ID���ҵ�����¼
		 */
			public Message messageEdit(String messageId) {
				// TODO Auto-generated method stub
				Message message=new Message();
				con=jdbc.getcon();
				String sql="select * from message where messageId=?";
				try {
					pst=con.prepareStatement(sql);
					pst.setString(1,messageId);
					rs=pst.executeQuery();
					while(rs.next())
					{
						
						message.setMessageId(rs.getString("messageId"));
						message.setMessageName(rs.getString("messageName"));
						message.setMessageSex(rs.getString("messageSex"));
						message.setMessageEmail(rs.getString("messageEmail"));
						message.setMessageQQ(rs.getString("messageQQ"));
						message.setMessageTel(rs.getString("messageTel"));
						message.setMessageAdd(rs.getString("messageAdd"));
						message.setMessageCont(rs.getString("messageCont"));
						message.setMessageTime(rs.getString("messageTime"));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					jdbc.closeConnection();
				}
				
				
				return message;
			}
		/**
		 * ���������Ϣ
		 */
		public void messageAdd(Message message) {
			con=jdbc.getcon();
			String sql="insert into message values(?,?,?,?,?,?,?,?,?)";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1,message.getMessageId());
				pst.setString(2, message.getMessageName());
				pst.setString(3,message.getMessageSex());
				pst.setString(4,message.getMessageEmail());
				pst.setString(5,message.getMessageQQ());
				pst.setString(6,message.getMessageTel());
				pst.setString(7,message.getMessageAdd());
				pst.setString(8,message.getMessageCont());
				pst.setString(9,message.getMessageTime());
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				jdbc.closeConnection();
			}
			
			// TODO Auto-generated method stub

		}
		/**
		 * ɾ��������Ϣ
		 */
		public boolean messageDelete(String messageId) {
			// TODO Auto-generated method stub
			boolean fal=false;
			int i=0;
			con=jdbc.getcon();
			String sql = "delete from message where messageId=?";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1,messageId);
				i=pst.executeUpdate();
				if(i>0)
				{
					fal=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				jdbc.closeConnection();
			}
			 return fal;
		}
		/**
		 * �޸�������Ϣ
		 */
		public boolean messageUpdate(Message message) {
			// TODO Auto-generated method stub
			boolean fal=false;
			int i=0;
			con=jdbc.getcon();
			String sql="update message set messageName=?,messageSex=?,messageEmail=?,messageQQ=?,messageTel=?,messageAdd=?,messageCont=?,messageTime=? where messageId=?";
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1,message.getMessageName());
				pst.setString(2,message.getMessageSex());
				pst.setString(3,message.getMessageEmail());
				pst.setString(4,message.getMessageQQ());
				pst.setString(5,message.getMessageTel());
				pst.setString(6,message.getMessageAdd());
				pst.setString(7,message.getMessageCont());
				pst.setString(8,message.getMessageTime());
				pst.setString(9,message.getMessageId());
				i=pst.executeUpdate();
				if(i>0)
				{
					fal=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				jdbc.closeConnection();
			}
			
	         return fal;
		}
}
