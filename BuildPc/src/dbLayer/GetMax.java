package dbLayer;

import java.sql.*;

public class GetMax {
	
	public GetMax(){
		
	}
	
	public static int getMaxId(String query){
		ResultSet result;
		int id = -1;
		try{
			Statement st = DbConnection.getInstance().getDBCon().createStatement();
			result = st.executeQuery(query);
			if(result.next()){
				id = result.getInt(1);
			}
		}
		catch(Exception e){
			System.out.println("Query exception: Error in reading maxId " + e);
		}
		return id;
	}

}
