package dbLayer;

import java.sql.*;
import modelLayer.*;

public class DbGraphicsCard {
	private Connection con;

	public DbGraphicsCard(){
		con  = DbConnection.getInstance().getDBCon();
	}
	 private PreparedStatement getPreparedStatement() throws Exception{
	    	PreparedStatement ps = null;
	    	String query = "select * from GraphicsCard where id = ?";
	    	ps = con.prepareStatement(query);
	    	return ps;
	    }
	    
	    private GraphicsCard findGfx(int id) throws Exception{
	    	GraphicsCard gfx = null;
	    	ResultSet result;
	    	PreparedStatement ps = getPreparedStatement();
	    	String name, description, pci = null;
	    	double price = 0.0;
	    	
	    	//int id = 0;
	    	ps.setInt(1, id);
	    	result = ps.executeQuery();
	    	if(result.next()){
	    		name = result.getString("name");
	    		description = result.getString("description");
	            pci = result.getString("pci");
	            price = result.getDouble("price");
	            id = result.getInt("id");
	            gfx = new GraphicsCard(id, name, description, price, pci);
	    	}
	    	return gfx;
	    }
	    
	    private int insertGraphicsCard(GraphicsCard gfx) throws Exception{
	    	int nextId = GetMax.getMaxId("select max (id) from GraphicsCard");
	    	nextId++;
	    	System.out.println("next id "+ nextId);
	    	
	    	int rc = -1;
	    	String query = "insert into GraphicsCard(id, name, description, price, pci) values ('" + gfx.getId() + "', "
	    			      + gfx.getName() + ",'" + gfx.getDescription() + ",'" + gfx.getPrice() + ",'"  + gfx.getPci()  +"');";
	    	System.out.println("insert: " + query);
	    	try{
	    		Statement st = con.createStatement();
	    		st.setQueryTimeout(5);
	    		rc = st.executeUpdate(query);
	    		st.close();
	    	}
	    	catch(Exception e){
	    		System.out.println("GraphicsCard not found");
	    		throw new Exception("GraphicsCard not insert correctly");
	    	}
	    	return rc;
	    }
}
