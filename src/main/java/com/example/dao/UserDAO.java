package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserDAO {

	@Autowired
	private DataSource dataSource; // Updated to DataSource for proper DI

	// Setter Injection for DataSource
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	

	public void createUser(User user) throws SQLException {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO USERS (STDID, STDNAME, STDMOBILE) VALUES (?, ?, ?)");) {

			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setLong(3, user.getMobile());
			ps.executeUpdate();
		}
	}

	

	
}
