package dbLayer;

import java.sql.*;

import modelLayer.*;

public class DbHdd {
	private Connection con;
	
	public DbHdd(){
		con = DbConnection.getInstance().getDBCon();
	}

	 private PreparedStatement getPreparedStatement() throws Exception{
	    	PreparedStatement ps = null;
	    	String query = "select * from Hdd where id = ?";
	    	ps = con.prepareStatement(query);
	    	return ps;
	    }
	    
	    private Hdd findHdd(int id) throws Exception{
	    	Hdd hdd = null;
	    	ResultSet result;
	    	PreparedStatement ps = getPreparedStatement();
	    	String name, description = null;
	    	double price = 0.0;
	    	
	    	ps.setInt(1, id);
	    	result = ps.executeQuery();
	    	if(result.next()){
	    		name = result.getString("name");
	    		description = result.getString("description");
	            price = result.getDouble("price");
	            id = result.getInt("id");
	            hdd = new Hdd(id, name, description, price);
	    	}
	    	return hdd;
	    }
	    
	    private int insertHdd(Hdd hdd) throws Exception{
	    	int nextId = GetMax.getMaxId("select max (id) from Hdd");
	    	nextId++;
	    	System.out.println("next id "+ nextId);
	    	
	    	int rc = -1;
	    	String query = "insert into Hdd (id, name, description, price) values ('" + hdd.getId() + "', "
	    			      + hdd.getName() + ",'" + hdd.getDescription() + ",'" + hdd.getPrice() + "');";
	    	System.out.println("insert: " + query);
	    	try{
	    		Statement st = con.createStatement();
	    		st.setQueryTimeout(5);
	    		rc = st.executeUpdate(query);
	    		st.close();
	    	}
	    	catch(Exception e){
	    		System.out.println("Hdd not found");
	    		throw new Exception("Hdd not insert correctly");
	    	}
	    	return rc;
	    }
}
