//Fetch id, name, price from BOOKS table By Using ResulSet

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program4 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME ="root";
    private static final String DB_PWD ="admin123";
    private static final String SELECT_SQL="SELECT BOOK_ID,BOOK_NAME,BOOK_PRICE FROM BOOKS";
    public static void main(String[]args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        ResultSet rs=stmt.executeQuery(SELECT_SQL);

        System.out.println("Query Execution Completed.. Data availabe in ResultSet..");
        while(rs.next()){
            rs.refreshRow();
            System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3));
        }
        con.close();
    }
}