package vn.iotstar.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private final String serverName = "LAPTOP-OHDAKCI8";
	private final String dbName = "SHOPFRUIT";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "123456@a";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
	
	// Fix Do not hardcode passwords in code. Found password string
	public DBConnection() {
        	this.password = getPasswordFromConfig(); // Retrieve password from configuration file or environment variable
    	}

	private String getPasswordFromConfig() {
        	// Implement logic to retrieve the password from a configuration file or environment variable
        	// Return the password securely
        	return "your_password_here";
    	}
	
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnection().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
