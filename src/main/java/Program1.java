/*First JDBC Program to insert books in books table */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program1 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_NAME ="root";
    private static final String DB_PWD ="admin123";
    private static final String INSERT_SQL="INSERT INTO BOOKS VALUES(102,'Python',12000)";

    public static void main(String[]Args)throws  Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(DB_URL,DB_NAME,DB_PWD);
        Statement stmt=con.createStatement();
        int rowsEffected =stmt.executeUpdate(INSERT_SQL);
        System.out.println("Record Inserted count::"+ rowsEffected);
        con.close();
    }
}
