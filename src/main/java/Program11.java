/*Program to Develop Procedure with IN & OUT Parameters.
DELIMITER $$
CREATE PROCEDURE getBookNameByPrice(IN bprice INT,OUT bname VARCHAR(100))
BEGIN
	Select BOOK_NAME as bname from BOOKS where BOOK_PRICE <=bprice;
END$$
*/
import java.sql.*;
import java.util.Scanner;

public class Program11 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME = "root";
    private static final String DB_PWD = "admin123";
    private static final String PROCEDURE = "call getBookNameByPrice(?,?)";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Price::");
        int bookPrice = sc.nextInt();

        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
        CallableStatement cstmt = con.prepareCall(PROCEDURE);
        cstmt.setDouble(1,bookPrice);
        cstmt.registerOutParameter(2, Types.VARCHAR);

        ResultSet rs = cstmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        con.close();
    }
}
