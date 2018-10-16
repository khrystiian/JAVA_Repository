package dbLayer;

import java.sql.*;

import modelLayer.*;


public class DbMotherboard {
    private Connection con;
    
    public DbMotherboard(){
    	con = DbConnection.getInstance().getDBCon();
    }
    
    private PreparedStatement getPreparedStatement() throws Exception{
    	PreparedStatement ps = null;
    	String query = "select * from Motherboard where id = ?";
    	ps = con.prepareStatement(query);
    	return ps;
    }
    
    private Motherboard findMth(int id) throws Exception{
    	Motherboard mth = null;
    	ResultSet result;
    	PreparedStatement ps = getPreparedStatement();
    	String name, description, socket, series, type, pci = null;
    	double price = 0.0;
    	
    	//int id = 0;
    	ps.setInt(1, id);
    	result = ps.executeQuery();
    	if(result.next()){
    		name = result.getString("name");
    		description = result.getString("description");
    		socket = result.getString("socket");
    		series  = result.getString("series");
    		type = result.getString("type");
            pci = result.getString("pci");
            price = result.getDouble("price");
            id = result.getInt("id");
            mth = new Motherboard(id, name, description, price, socket, series, pci, type);
    	}
    	return mth;
    }
    
    private int insertMotherboard(Motherboard mth) throws Exception{
    	int nextId = GetMax.getMaxId("select max (id) from Motherboard");
    	nextId++;
    	System.out.println("next id "+ nextId);
    	
    	int rc = -1;
    	String query = "insert into Motherboard (id, name, description, price, socket, series, pci, type) values ('" + mth.getId() + "', "
    			      + mth.getName() + ",'" + mth.getDescription() + ",'" + mth.getPrice() + ",'" + mth.getSocket() + "'," + mth.getPci() + "'," + 
    			        mth.getType() +"');";
    	System.out.println("insert: " + query);
    	try{
    		Statement st = con.createStatement();
    		st.setQueryTimeout(5);
    		rc = st.executeUpdate(query);
    		st.close();
    	}
    	catch(Exception e){
    		System.out.println("Motherboard not found");
    		throw new Exception("Motherboard not insert correctly");
    	}
    	return rc;
    }
}
