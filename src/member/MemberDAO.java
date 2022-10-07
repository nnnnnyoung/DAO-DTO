package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	
	Connection conn=null;
	
	MemberDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean connect() {
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void input(MemberInfo m) {
		if(connect()) {
			String sql="insert into member1 values(?,?,?,?,?)";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, m.getId());
				psmt.setString(2, m.getName());
				psmt.setString(3, m.getPass());
				psmt.setString(4, m.getAddr());
				psmt.setInt(5, m.getPoint());
				int r=psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 실패하였습니다.");
		}
	}
	
	public void del(String id) {
		
		if(connect()) {
			String sql="delete from member1 where id=?";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, id);				
				int r=psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	public void modi(MemberInfo m) {
		if(connect()) {
			String sql="update member1 set name=?, pass=?, addr=?, point=? where id=?";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, m.getName());
				psmt.setString(2, m.getPass());
				psmt.setString(3, m.getAddr());
				psmt.setInt(4, m.getPoint());
				psmt.setString(5, m.getId());
				int r= psmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	   public void search(String id) {
		      ResultSet rs=null;
		      if(connect()) {
		         String sql="select * from member1 where id like '%"+id+"%'";
		         
		         try {
//		            PreparedStatement psmt=conn.prepareStatement(sql);
//		            psmt.setString(1, "'%"+id+"%'");
		        	 
		        	Statement psmt=conn.createStatement();

		            rs=psmt.executeQuery(sql);
		            while(rs.next()) {
		               System.out.println("이름: "+rs.getString("name"));
		               System.out.println("비밀번호: "+rs.getString("pass"));
		               System.out.println("주소: "+rs.getString("addr"));
		               System.out.println("포인트: "+rs.getInt("point"));
		               System.out.println("----------------");

		            }

		            conn.close();
		         } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		         }
		      }
		      
		   }

	public ArrayList <MemberInfo> prt() {
		ResultSet rs=null;
		if(connect()) {
			String sql="select * from member1";
			ArrayList <MemberInfo> mList=new ArrayList<>();
			
			try {
				Statement st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					MemberInfo ML=new MemberInfo();
					ML.setId(rs.getString("id"));
					ML.setName(rs.getString("name"));
					ML.setAddr(rs.getString("addr"));
					ML.setPass(rs.getString("pass"));
					ML.setPoint(rs.getInt("point"));
					mList.add(ML);
				}
				conn.close();
				return mList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public int cheak(String id) { //id 체크 메서드, 수정과 입력에 사용된다.
		ResultSet rs=null;
		if(connect()) {
			String sql="select id from member1 where id=?";
			try {
				PreparedStatement psmt=conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs=psmt.executeQuery();
				
				if(rs.next()) { //입력한 아이디가 이미 테이블에 있을 경우
					conn.close();
					return 0; //0을 리턴
				}
				conn.close();	
				return 1; // 입력한 아이디가 테이블에 없을 경우 1을 리턴
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 2; //커넥션 실패시 2를 리턴
	}
	
	
	public int login(MemberInfo M) {
		ResultSet rs=null;
		if(connect()) {
			String sql = "select id,pass from member1 where id=? and pass=?";
			try {
				PreparedStatement p1=conn.prepareStatement(sql);
				p1.setString(1, M.getId());
				p1.setString(2, M.getPass());
				
				rs=p1.executeQuery();
				
				if(rs.next()) {
					conn.close();
					return 0;
				}
				conn.close();
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 2;
	}
	
	

	
	
	
	
	
	
	

}
