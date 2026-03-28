/*Program to perform Batch Operations in JDBC appliction. */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program12 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME = "root";
    private static final String DB_PWD = "admin123";
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
        Statement stmt =con.createStatement();
        stmt.addBatch("INSERT INTO BOOKS VALUES(104,'AI',1500)");
        stmt.addBatch("INSERT INTO BOOKS VALUES(105,'DSA',1900)");

        int[]count= stmt.executeBatch();
        System.out.println("ROWS EFFECTED ::"+count.length);
        con.close();
        System.out.println("EXECUTION COMPLETED...");
    }
}
