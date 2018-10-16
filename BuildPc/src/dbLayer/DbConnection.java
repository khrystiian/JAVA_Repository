package dbLayer;

import java.sql.*;

public class DbConnection {

	private static final String driver = "jdbc:sqlserver://127.0.0.1:1433";
	private static final String databaseName = ";databaseName=BuildPC";
	
	private static String userName = "; user=sa";
	private static String password = ";password=khrystiian";
	
	private DatabaseMetaData dma;
	private static Connection con;
	private static DbConnection instance = null;
	
	private DbConnection(){
		String url = driver + databaseName + userName + password;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Load of the class ok");
		} catch (ClassNotFoundException e) {
			System.out.println("Can not find the driver");
			e.printStackTrace();
		}
		try{
			con = DriverManager.getConnection(url);
			con.setAutoCommit(true);
			dma = con.getMetaData();
			System.out.println("Connection to "+ dma.getURL());
			System.out.println("Driver " + dma.getDriverName());
			System.out.println("Database product name " + dma.getDatabaseProductName());;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void closeConnection(){
		try{
			con.close();
			System.out.println("Connection closed");
		}
		catch(Exception e){
			System.out.println("Error trying to close the database " + e.getMessage());
		}
	}
	
		public Connection getDBCon(){
			return con;
		}
		
		public static DbConnection getInstance(){
			if(instance==null){
				instance = new DbConnection();
			}
			return instance;
		}
	}

