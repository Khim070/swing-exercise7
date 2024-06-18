import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con;
        //String sql = "CREATE DATABASE testDB";
        //String createtable = "CREATE TABLE Staff(Id int, LastName varchar(255), FirstName varchar(255), City varchar(255))";
        //String insertrecord = "INSERT INTO Staff(Id, LastName, FirstName, City) VALUES(2,'Chansok','LEANG','Kandal')";
        String query1 = "SELECT * FROM Staff";
        try{
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3307/","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/testDB","root","");
            Statement stmt = con.createStatement();
            //stmt.execute(sql);
            //stmt.execute(createtable);
            //stmt.executeUpdate(insertrecord);
            ResultSet rs = stmt.executeQuery(query1);
            while(rs.next()){
                int id = rs.getInt("Id");
                String LastName = rs.getString("LastName");
                String FirstName = rs.getString("FirstName");
                String City = rs.getString("City");

                System.out.println("ID is: " + id);
                System.out.println("LastName is: " + LastName);
                System.out.println("FirstName is: " + FirstName);
                System.out.println("City is: " + City);
                System.out.println("----------------------------");
            }
            System.out.println("Success");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}