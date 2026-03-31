/*Program to Develop a program to take values in employee table and in emp_address table at
same time by using Transaction Management */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Program13 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME = "root";
    private static final String DB_PWD = "admin123";
    private static final String EMP_INSERT="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
    private static final String EMP_INSERT_ADDR=" INSERT INTO EMP_ADDRESS VALUES(?,?,?,?)";

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
        con.setAutoCommit(false);

        try {
            PreparedStatement pstmt = con.prepareStatement(EMP_INSERT);
            pstmt.setInt(1, 107);
            pstmt.setString(2, "Jhonny");
            pstmt.setInt(3,9000);
            pstmt.setString(4,"Accounts");
            pstmt.setString(5, "Hyd");
            pstmt.setString(6,"Male");
            pstmt.executeUpdate();

            pstmt = con.prepareStatement(EMP_INSERT_ADDR);
            pstmt.setString(1, "Akola");
            pstmt.setString(2, "Maharashtra");
            pstmt.setString(3, "India");
            pstmt.setInt(4,107);
            pstmt.executeUpdate();

            con.commit();
            System.out.println("Record Inserted...");
        }
        catch (Exception e){
            System.out.println("Tansaction RolledBack...");
            con.rollback();
        }
        con.close();
    }
}