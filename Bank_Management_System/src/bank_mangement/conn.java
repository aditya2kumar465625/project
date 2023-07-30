package bank_mangement;
import  java.sql.*;

public class conn {
    Connection c;
    Statement s;
    public  conn(){
  String url = "jdbc:mysql://db4free.net:3306/bank_management";
        try {
            c =  DriverManager.getConnection(url, "aditya465625", "Ak@2018@2006");
            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
