/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package marksapp.database;
import java.sql.*;
/**
 *
 * @author sangyakoirala
 */
public class MySqlConnection implements DbConnection{

    @Override
    public Connection openConnection() {
      try{
          String username="root";
          String password="newpassword";
          String database="marks";
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn;
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+
                  database,username,password);
          return conn;
      } catch(Exception e){
          System.out.println("EXCEPTION"+e);
          return null;
      }
    }

    @Override
    public void closeConnection(Connection conn) {
       try{
           if(conn!=null && !conn.isClosed()){
               conn.close();
           }
       } catch(Exception e){
           
       }
    }
    
}
