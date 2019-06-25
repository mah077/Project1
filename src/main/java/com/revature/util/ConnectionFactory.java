
	package com.revature.util;

	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class ConnectionFactory {
		
		private static String url;
		private static String user;
		private static String password;
		//private static final String PROPERTIES_FILE = "src/main/resources/database.properties";
		private static final String PROPERTIES_FILE = "/database.properties";
		private static ConnectionFactory cf;
		
		public static synchronized Connection getConnection() {
			if (cf==null) {
				cf = new ConnectionFactory();
			}
			
			return cf.createConnection();	
		}
		
		private ConnectionFactory() {
			Properties prop = new Properties();
			try (InputStream is = getClass().getResourceAsStream(PROPERTIES_FILE);){
			prop.load(is);
			
			 url=prop.getProperty("url");
			 user=prop.getProperty("user");
			 password=prop.getProperty("password");
			 			
			} catch (FileNotFoundException e) {
				LoggingUtil.error("file not found "+e.getMessage());
				LoggingUtil.info();
				e.printStackTrace();
			} catch (IOException e) {
				LoggingUtil.info();
				LoggingUtil.error(e.getMessage());
				System.out.println("not found");
				e.printStackTrace();
			}
		}
		
		private Connection createConnection() {
			Connection conn = null;
			
			try {
				Class.forName("org.postgresql.Driver");
				LoggingUtil.trace(url);
				LoggingUtil.trace(user);
				LoggingUtil.trace(password);
				conn = DriverManager.getConnection(url, user,password);
				LoggingUtil.trace("Connected...");
			} catch (SQLException e) {
				e.printStackTrace();
				LoggingUtil.error(e.getMessage());	LoggingUtil.error(e.getMessage());
				LoggingUtil.warn("Faild to make DB Connection");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
			
		}
	}



