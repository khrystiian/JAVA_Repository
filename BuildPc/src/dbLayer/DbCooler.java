package dbLayer;

import java.sql.*;

import modelLayer.Cooler;

public class DbCooler {
	private Connection con;
	
	public DbCooler(){
		con = DbConnection.getInstance().getDBCon();
	}
	 private PreparedStatement getPreparedStatement() throws Exception{
	    	PreparedStatement ps = null;
	    	String query = "select * from Cooler where id = ?";
	    	ps = con.prepareStatement(query);
	    	return ps;
	    }
	    
	    private Cooler findCooler(int id) throws Exception{
	    	Cooler cooler = null;
	    	ResultSet result;
	    	PreparedStatement ps = getPreparedStatement();
	    	String name, description, series = null;
	    	double price = 0.0;
	    	
	    	ps.setInt(1, id);
	    	result = ps.executeQuery();
	    	if(result.next()){
	    		name = result.getString("name");
	    		description = result.getString("description");
	    		series  = result.getString("series");
	            price = result.getDouble("price");
	            id = result.getInt("id");
	            cooler = new Cooler(id, name, description, price, series);
	    	}
	    	return cooler;
	    }
	    
	    private int insertCooler(Cooler cooler) throws Exception{
	    	int nextId = GetMax.getMaxId("select max (id) from Cooler");
	    	nextId++;
	    	System.out.println("next id "+ nextId);
	    	
	    	int rc = -1;
	    	String query = "insert into Cooler (id, name, description, price, series) values ('" + cooler.getId() + "', "
	    			      + cooler.getName() + ",'" + cooler.getDescription() + ",'" + cooler.getPrice() + ",'" +cooler.getSeries() + "');";
	    	System.out.println("insert: " + query);
	    	try{
	    		Statement st = con.createStatement();
	    		st.setQueryTimeout(5);
	    		rc = st.executeUpdate(query);
	    		st.close();
	    	}
	    	catch(Exception e){
	    		System.out.println("Cooler not found");
	    		throw new Exception("Cooler not insert correctly");
	    	}
	    	return rc;
	    }

}
