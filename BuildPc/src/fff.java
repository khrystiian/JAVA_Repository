import java.sql.*;

public class fff{

public Project findWithPreQuery( int pnumber)
        {   System.out.println("Find with preCompiled");
            if(pStmtSelect == null){
               pStmtSelect =  getPreparedStmt();          
            }
            Project pObj = null;
            ResultSet results;
            try{
           
            pStmtSelect.setInt(1,pnumber);
            results = pStmtSelect.executeQuery();
            if(results.next()){
                 pObj = buildProject(results);	
            }
            }
            catch(Exception e){
                e.getMessage();
            }
            return pObj;
       }
        private PreparedStatement getPreparedStmt()
        {
           try{ 
            String query = "select pname, pnumber, plocation from project" +
                           " where pnumber = ?";
            System.out.println("Preparestatement " + query);
            pStmtSelect = con.prepareStatement(query);
            
           }
           catch(Exception e){
                e.getMessage();
            }
           return pStmtSelect;
        }
        
        // example using  prepared stmt
        public int insertProject(Project pObj)
        { 
            int rc = -1; 
            PreparedStatement pstmt = null;
             String insert = "insert into project (pname, pnumber,plocation, dnum)"+
                     "values (?,?,?,?)";
             System.out.println(insert);
             try{
                pstmt = con.prepareStatement(insert);
                pstmt.setString(1,pObj.getName());
                pstmt.setInt(2, pObj.getPnumber());
                pstmt.setString(3,pObj.getLocation());
                pstmt.setInt(4, pObj.getDepartment().getDnumber());
                rc = pstmt.executeUpdate();
                                 
                
             }
             catch(SQLException sqlE)
             {
                 System.out.println("SQL Error");
                 System.out.println(sqlE.getMessage());   
             }
             catch(Exception e){
                 e.getMessage();
                 
             }
             return rc;
             
        }
        public int deleteProject(int pnumber)
        {
           int rc = -1;
           PreparedStatement pstmt = null;
           String delete = "delete from project where pnumber = ?";
           System.out.println(delete);
             try{
                pstmt = con.prepareStatement(delete);
                pstmt.setInt(1,pnumber);
                rc = pstmt.executeUpdate();                       
             }
             catch(SQLException sqlE)
             {
                 System.out.println("SQL Error");
                 System.out.println(sqlE.getMessage());   
             }
             catch(Exception e){
                 e.getMessage();
                 
             }
            return rc;
        }
        }
}