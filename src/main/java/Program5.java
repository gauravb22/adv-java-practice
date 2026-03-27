import com.mysql.cj.ServerPreparedQueryTestcaseGenerator;

import java.sql.*;
import java.util.Scanner;

public class Program5 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME ="root";
    private static final String DB_PWD ="admin123";
    public static void main(String[]args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Price");
        double price=sc.nextDouble();

        Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
        StringBuilder sb=new StringBuilder("SELECT * FROM BOOKS");

        if(price>0){
            sb.append(" WHERE BOOK_PRICE<=?");
        }

        PreparedStatement pstmt=con.prepareStatement(sb.toString());

        if(price>0){
            pstmt.setDouble(1,price);
        }
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3));
        }
        con.close();
    }
}
