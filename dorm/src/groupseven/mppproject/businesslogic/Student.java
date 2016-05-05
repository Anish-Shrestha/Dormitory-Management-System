package groupseven.mppproject.businesslogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import groupseven.mppproject.businesslogic.interfaces.IPerson;
import groupseven.mppproject.dataaccess.ConnectManager;


public class Student implements IPerson {
    private int id;
    private String name;
    private String email;
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    public Student(int id, String name, String email){
    	this.id=id;
    	this.name=name;
    	this.email=email;	
    }
    
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public void getPersonInfo(int id) {
		try {
		con=ConnectManager.getConnection();
		String sql = "select * from student where studentId='" + id + "'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
			if (rs.next()) {
				this.id=rs.getInt("studentId");
				this.name=rs.getString("studentName");
			    this.email=rs.getString("studentEmail");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
