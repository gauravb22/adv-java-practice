//Write a java Program to retrive all the record from the database table and display on the console.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program3 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME ="root";
    private static final String DB_PWD ="admin123";
    private static final String SELECT_SQL="SELECT * FROM BOOKS";

    public static void main(String[]args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_SQL);

        while (rs.next()) {
            System.out.print(rs.getInt("BOOK_ID"));
            System.out.print(rs.getString("BOOK_NAME"));
            System.out.print(rs.getInt("BOOK_PRICE"));
            System.out.println();
        }
        con.close();
    }
}
