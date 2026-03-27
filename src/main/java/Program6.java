/*Program to input as a Department or Work_Location or Gender and return Emtloyee Details.
* If user enter only dept then retrive all emp of that deparatment.
* If user enter only Work_location then retirice all emp from that location.
* If user doesn't enter any values then all records.*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Program6 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME ="root";
    private static final String DB_PWD ="admin123";
    public static void main(String[]args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Dept:: ");
        String dept=sc.nextLine();
        System.out.println("Enter Work Loacation:: ");
        String workLocation=sc.nextLine();
        System.out.println("Enter Gender:: ");
        String gender=sc.nextLine();

        StringBuilder sql=new StringBuilder("SELECT * FROM EMPLOYEE WHERE 1=1");

        if(dept!=null && !dept.equals("null")){
            sql.append(" AND EMP_DEPT=?");
        }
        if(workLocation!=null && !workLocation.equals("null")){
            sql.append(" AND WORK_LOCATION=?");
        }
        if(gender!=null && !gender.equals("null")){
            sql.append(" AND EMP_GENDER=?");
        }

        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

        PreparedStatement pstmt=con.prepareStatement(sql.toString());

        int index=1;

        if(dept!=null && !dept.equals("null")){
            pstmt.setString(index,dept);
            index++;
        }
        if(workLocation!=null && !workLocation.equals("null")){
            pstmt.setString(index,workLocation);
            index++;
        }
        if(gender!=null && !gender.equals("null")){
            pstmt.setString(index,gender);
            index++;
        }

        ResultSet rs= pstmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString(1)+"--"+ rs.getString(2)+"--"+rs.getString(3));
        }
        con.close();
    }
}
