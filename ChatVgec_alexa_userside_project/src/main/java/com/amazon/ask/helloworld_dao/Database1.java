package com.amazon.ask.helloworld_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Database1 {
	static Connection cn = null;
	//database-1-alexa-banking.cqoiev0du86m.us-east-1.rds.amazonaws.com/project_db_alexa_banking
	// jdbc:mysql://localhost:3307/project_db
	//for rdp : un = admin pw = Admin1234  
	// un : root pw: root
	static final String HOSTNAME = "jdbc:mysql://chatvgecproject.c0dux59vykqy.us-east-1.rds.amazonaws.com/project_db_chatbot";
	static final String USERNAME = "admin";
	static final String PASSWORD = "Admin12345";

	public static Statement connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
			Statement s = cn.createStatement();

			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public List searchEventtype() {
		List<String> ls4 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("SELECT event_name from createeventtype_table where status = true");
			while (rs.next()) {
				String Eventtype = rs.getString("event_name");
				ls4.add(Eventtype);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls4;

	}
	
	public List searchEventtypeid(String eventtype) {
		List eventls = new ArrayList();

		int Eventtypeinfoid;
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery(
					"SELECT eventtype_id FROM createeventtype_table WHERE event_name ='" + eventtype + "' AND status = true");
			while (rs.next()) {
				Eventtypeinfoid = rs.getInt("eventtype_id");
				eventls.add(Eventtypeinfoid);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eventls;
	}
	
	public List searchEventtypedescription(int eventtypeinfoid) {
		List ls6 = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery(
					"SELECT * FROM eventtypeinfo_table WHERE eventtype_id ='" + eventtypeinfoid + "' AND status = true");
			while (rs.next()) {

				String cost_of_Event = rs.getString("cost_of_event");
				String time_Duration = rs.getString("time_duration");
				String faculty_Coordinator = rs.getString("faculty_coordinator");
				String student_Coordinator = rs.getString("student_coordinator");
				
				String desc = cost_of_Event + time_Duration + faculty_Coordinator + student_Coordinator;
				
		//		EventtypeInfoVO eventtypeinfoVO = new EventtypeinfoVO();
			//	loantypeinfoVO.setLoanRate(Loan_Rate);
		//		loantypeinfoVO.setMaximumloanAmount(maximumloan_Amount);
	//			loantypeinfoVO.setNumberofEmi(numberof_Emi);
//				loantypeinfoVO.setTimeDuration(time_Duration);

				ls6.add(desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls6;
	}

	public List searchScholarshiptype() {
		List<String> ls7 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("SELECT scholarship_name from scholarship_table where status = true");
			while (rs.next()) {
				String Eventtype = rs.getString("scholarship_name");
				ls7.add(Eventtype);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls7;

	}
	
	public List<String> searchScholarshipdescription(String scholarship) {
		List<String> ls8 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("SELECT * FROM scholarship_table WHERE scholarship_name ='"
					+ scholarship + "' AND status = true");
			while (rs.next()) {
				String Faculty_coordinator = rs.getString("faculty_coordinator");
				
				String Scholarshipdescription = rs.getString("scholarship_description");
				
				String Scholarshipdescription1 = ""+scholarship+" Scholarship. - You can connect "+Faculty_coordinator+
						" as responsible faculty for Scholarship. Also you can connect Dhruvil Bhojani who is student coordinator "
						+Scholarshipdescription;
				ls8.add(Scholarshipdescription1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls8;
	}

	public List searchHosteltype() {
		List<String> ls9 = new ArrayList<String>();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery("SELECT hostel_name from hostel_table where status = true");
			while (rs.next()) {
				String Hosteltype = rs.getString("hostel_name");
				ls9.add(Hosteltype);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls9;

	}

	public List searchHosteldescription(String hostel) {
		List<String> ls10 = new ArrayList();
		try {
			Statement s = connection();
			ResultSet rs = s.executeQuery(
					"SELECT * FROM hostel_table WHERE hostel_name ='" + hostel + "' AND status = true");
			while (rs.next()) {

				String hostel_Fees = rs.getString("hostel_fees");
				String totalrooms_Available = rs.getString("totalrooms_available");
				String hostel_Description = rs.getString("hostel_description");
				
				String desc = "The "+hostel+"is the best hostel." +"Fees of Hostel is "+hostel_Fees + ". Total number of rooms available is "+totalrooms_Available +" and " + hostel_Description;
				
				ls10.add(desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls10;
	}


	public static void main(String[] args)
	{
		//Event type
		 String speech4 = ""; 
		 Database1 d4 = new Database1(); 
		 List ls4 = d4.searchEventtype(); 
		 for (int i = 0; i < ls4.size(); i++)
		 { 
			 if (i == 0){ 
			 speech4 = (String) ls4.get(0);
			 } 
			 
			 else {
			 speech4 = speech4 +" Event, " + (String) ls4.get(i);
		 	 } 
		 }
				  
				  System.out.println("Event: " + speech4 + " Event. ");
				  
				 // Getting Event id 
				  String speech5 = ""; 
				  
				  Database1 d5 = new Database1();
				 List eventtypeinfoid = d5.searchEventtypeid("Sports");
				  
			  speech5 = ""+eventtypeinfoid; 
			  System.out.println(speech5);
				 

				// Event Type Information
				String speech6 = "";
				Database1 d6 = new Database1();
				List ls6 = d6.searchEventtypedescription(1);
				
	//			for (int i = 0; i < ls6.size(); i++)
	//			 { 
	//				 if (i == 0){ 
	//				 speech6 = (String) ls6.get(1);
	//				 } 
					 
	//				 else {
	//				 speech6 = speech6 +" Event, " + (String) ls6.get(i);
	//			 	 } 
		//		 }
				speech6 = ""+ls6;
			System.out.println(speech6);
		//		LoantypeinfoVO loantypeinfoVO = (LoantypeinfoVO) ls6.get(0);
		//		System.out.println("DESCRIPTION OF SPEECH 6 :\n rate of interest= " + loantypeinfoVO.getLoanRate()
		//				+ "\n max ammount = " + loantypeinfoVO.getMaximumloanAmount() + "\n emi = "
		//				+ loantypeinfoVO.getNumberofEmi() + "\n duration" + loantypeinfoVO.getTimeDuration());
	//		String speech6 = "";
	//		Database1 d6 = new Database1();
	//		List ls6 = d6.searchEventtypetypedescription(13);
	//		LoantypeinfoVO loantypeinfoVO = (LoantypeinfoVO) ls6.get(0);
	//		System.out.println("DESCRIPTION OF SPEECH 6 :\n rate of interest= " + loantypeinfoVO.getLoanRate()
	//				+ "\n max ammount = " + loantypeinfoVO.getMaximumloanAmount() + "\n emi = "
	//				+ loantypeinfoVO.getNumberofEmi() + "\n duration" + loantypeinfoVO.getTimeDuration());
			
			//Scholarships type
			
			 String speech7 = ""; 
			 Database1 d7 = new Database1(); 
			 List ls7 = d7.searchScholarshiptype(); 
			 for (int i = 0; i < ls7.size(); i++)
			 { 
				 if (i == 0){ 
				 speech7 = (String) ls7.get(0);
				 } 
				 
				 else {
				 speech7 = speech7 +" Scholarship , " + (String) ls7.get(i);
			 	 } 
			 }
					  
					  System.out.println("Scholarship: " + speech7 + " Scholarship. ");
				//Scholarship Description.
			
					  String speech8 = "";
					  Database1 d8 = new Database1(); 
					  List ls8 = d8.searchScholarshipdescription("MYSY");
					  for (int i = 0; i < ls8.size(); i++)
					  { 
						  if (i == 0)
						  { 
							  speech8 = (String) ls8.get(0);
						  }
							 else { 
								 speech8 = "Somewhere error";
								 } 
					  }
					System.out.println("Description : " + speech8 + ". ");
	
					//Hostel type
					 String speech9 = ""; 
					 Database1 d9 = new Database1(); 
					 List ls9 = d9.searchHosteltype(); 
					 for (int i = 0; i < ls9.size(); i++)
					 { 
						 if (i == 0){ 
						 speech9 = (String) ls9.get(0);
						 } 
						 
						 else {
						 speech9 = speech9 +" Hostel , " + (String) ls9.get(i);
					 	 } 
					 }
							  
							  System.out.println("Hostel : " + speech9 + " Hostel. ");
							  
				// Hostel Description
							  
							  String speech10 = "";
							  Database1 d10 = new Database1(); 
							  List ls10 = d10.searchHosteldescription("VGEC");
							  for (int i = 0; i < ls10.size(); i++)
							  { 
								  if (i == 0)
								  { 
									  speech10 = (String) ls10.get(0);
								  }
									 else { 
										 speech10 = "Somewhere error";
										 } 
							  }
							System.out.println("Description : " + speech10 + ". ");
			
	}
}
