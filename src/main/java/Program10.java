/*Program to Develop Procedure with IN Parameters.
 DELIMITER $$
CREATE PROCEDURE getBookBy_Id(IN BID INT)
BEGIN
	SELECT * FROM BOOKS WHERE BOOK_ID=BID ;
END$$
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class Program10 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME = "root";
    private static final String DB_PWD = "admin123";
    private static final String PROCEDURE = "call getBookBy_Id(?)";

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter BOOK ID");
        int bookID=sc.nextInt();

        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
        CallableStatement cstmt = con.prepareCall(PROCEDURE);
        cstmt.setInt(1,bookID);

        ResultSet rs = cstmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3));
        }
        con.close();
    }
}
