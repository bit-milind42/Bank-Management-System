import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
            // Class.forName(com.mysql.cj.jdbc.Driver);
            // create connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "12345678");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
