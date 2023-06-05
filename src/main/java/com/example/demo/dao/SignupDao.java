package com.example.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import com.example.demo.model.Response;
import com.example.demo.model.SignupModel;
import com.example.demo.service.SignupService;

@Component // one parts
public class SignupDao implements SignupService {

	Response res = new Response();

	// Global access in all method is access
	String url = "jdbc:mysql://127.0.0.1:3306/kgm";
	String username = "root";
	String password = "root";

	@Override
	public Response addUsers(SignupModel data) {

		
		
		
		String uuid = UUID.randomUUID().toString();
		data.setsNo(uuid);
		
		data.setCreatedBy(uuid);
		data.setUpdatedBy(uuid);

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		
		data.setCreatedDate(date);
		data.setUpdatedDate(date);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mySQL driver class
			try (Connection con = DriverManager.getConnection(url, username, password);
					Statement st = con.createStatement();) {

				String insertQuery = "INSERT INTO kgm.user_details(s_no,first_name,last_name,email_id,password,dob,age,gender,mobile_number,created_date,update_date,created_by,update_by)VALUES('"
						+ data.getsNo() + "','" + data.getFirstName() + "','" + data.getLastName() + "','"
						+ data.getEmailId() + "','" + data.getPassword() + "'," + data.getDob() + "," + data.getAge()
						+ ",'" + data.getGender() + "'," + data.getMobileNumber() + "," + data.getCreatedDate() + ","
						+ data.getUpdatedDate() + ",'"+data.getCreatedBy()+"','"+data.getUpdatedBy()+"');";

				System.out.println(insertQuery);
				st.executeUpdate(insertQuery);
				
				res.setData("Created Successfully !!");
				res.setResponseCode(200);
				res.setResponseMsg("success this programmming");

			} catch (Exception e) {

			}
		} catch (Exception e) {
			e.printStackTrace();
			
			res.setData(" Not Created  !!");
			res.setResponseCode(500);
			res.setResponseMsg("error this programmming");
		}
		return res;
	}

	@Override
	public Response deleteUsers() {

		return res;
	}

	@Override
	public Response getAllUsers() {

		return res;
	}

	@Override
	public Response getUserById() {

		return res;
	}

	@Override
	public Response updateUsers() {

		return res;
	}

}
