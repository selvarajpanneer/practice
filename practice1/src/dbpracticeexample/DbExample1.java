package dbpracticeexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DbExample1 {

	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();
		
		try{  
		
			Class.forName("com.mysql.jdbc.Driver");  
		
			Connection con=(Connection) DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/test","ksr94","$elvaDB1");  
			  
			Statement stmt=(Statement) con.createStatement();  
		
			ResultSet rs=(ResultSet) stmt.executeQuery("select * from student");  
			while(rs.next())  {
			al.add(new Student(rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
			}
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
		
		for(Student s: al) {
			System.out.println("rollno: "+s.getRollno()+" name: "+s.getName()+" age: "+s.getAge()+" hometown: "+s.getHometown());	
		}

	}

}

class Student{
	int rollno;
	String name;
	int age;
	String hometown;
	
	public Student(int rollno,String name,int age,String hometown ) {
		this.rollno=rollno;
		this.name=name;
		this.age=age;
		this.hometown=hometown;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	
	
}

