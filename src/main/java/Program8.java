/*Program to Develop JDBC application to increase salary of all Employees.
Read Hike Percentage from keyword and update salary with given percentage
BY Using SQL QUERY.*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Program8 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME ="root";
    private static final String DB_PWD ="admin123";
    public static void main(String[]args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hike :: ");
        double hike = sc.nextDouble();

        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
        String UPDATE_SQL_SAL = " UPDATE EMPLOYEE SET EMP_SALARY = EMP_SALARY+(EMP_SALARY*?)/100";

        PreparedStatement pstmt = con.prepareStatement(UPDATE_SQL_SAL);
        pstmt.setDouble(1, hike);
        pstmt.executeUpdate();
        System.out.println("UPDATE COMPLETED....");
        con.close();
    }
}
