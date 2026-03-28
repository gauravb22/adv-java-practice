/*Program to Develop JDBC application to increase salary of all Employees.
Read Hike Percentage from keyword and update salary with given percentage.
Formula: NewSalary=existingSal+(existingSal* hike)/100; */

import java.sql.*;
import java.util.Scanner;

public class Program7 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME ="root";
    private static final String DB_PWD ="admin123";
    private static final String SELECT_SQL="SELECT * FROM EMPLOYEE";
    private static final String UPDATE_SQL ="UPDATE EMPLOYEE SET EMP_SALARY=? WHERE EMP_ID=?";
    public static void main(String[]args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hike :: ");
        double hike = sc.nextDouble();

        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(SELECT_SQL);
        PreparedStatement pstmt =con.prepareStatement(UPDATE_SQL);

        while(rs.next()){
            int empID =rs.getInt("EMP_ID");
            double existingSal=rs.getDouble("EMP_SALARY");
            double newSal= existingSal+(existingSal*hike)/100;

            pstmt.setDouble(1,newSal);
            pstmt.setInt(2,empID);
            pstmt.executeUpdate();
        }
        System.out.println("Update Completed..");
        con.close();
    }
}
