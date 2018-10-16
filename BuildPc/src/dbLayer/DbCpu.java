package dbLayer;

import java.sql.*;
import modelLayer.*;

public class DbCpu {
	private Connection con;

	public DbCpu(){
		con = DbConnection.getInstance().getDBCon();
	}
	 private PreparedStatement getPreparedStatement() throws Exception{
	    	PreparedStatement ps = null;
	    	String query = "select * from Cpu where id = ?";
	    	ps = con.prepareStatement(query);
	    	return ps;
	    }
	    
	    private Cpu findCpu(int id) throws Exception{
	    	Cpu cpu = null;
	    	ResultSet result;
	    	PreparedStatement ps = getPreparedStatement();
	    	String name, description, socket = null;
	    	double price = 0.0;
	    	
	    	ps.setInt(1, id);
	    	result = ps.executeQuery();
	    	if(result.next()){
	    		name = result.getString("name");
	    		description = result.getString("description");
	            price = result.getDouble("price");
	            socket = result.getString("socket");
	            id = result.getInt("id");
	            cpu = new Cpu(id, name, description, price, socket);
	    	}
	    	return cpu;
	    }
	    
	    private int insertCpu(Cpu cpu) throws Exception{
	    	int nextId = GetMax.getMaxId("select max (id) from Cpu");
	    	nextId++;
	    	System.out.println("next id "+ nextId);
	    	
	    	int rc = -1;
	    	String query = "insert into Cpu (id, name, description, price, socket) values ('" + cpu.getId() + "', "
	    			      + cpu.getName() + ",'" + cpu.getDescription() + ",'" + cpu.getPrice() + ",'" + cpu.getSocket() + "'," +"');";
	    	System.out.println("insert: " + query);
	    	try{
	    		Statement st = con.createStatement();
	    		st.setQueryTimeout(5);
	    		rc = st.executeUpdate(query);
	    		st.close();
	    	}
	    	catch(Exception e){
	    		System.out.println("Cpu not found");
	    		throw new Exception("Cpu not insert correctly");
	    	}
	    	return rc;
	    }
}
