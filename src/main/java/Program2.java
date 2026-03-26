//Program to perform Select Query using Result Set, retrive a bookName and bookPrice by Book_id
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program2 {
    private static final String DB_URL ="jdbc:mysql://localhost:3306/advjdb";
    private static final String DB_UNAME ="root";
    private static final String DB_PWD ="admin123";
    private static final String SELECT_SQL="SELECT * FROM BOOKS WHERE BOOK_ID=103";

    public static void main(String[]args)throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
        Statement stmt=con.createStatement();

        ResultSet rs = stmt.executeQuery(SELECT_SQL);

        if(rs.next()){
            int bookid=rs.getInt("BOOK_ID");
            String bookname=rs.getString("BOOK_NAME");
            int bookprice=rs.getInt("BOOK_PRICE");

            System.out.print(bookid+"  ");
            System.out.print(bookname+"  ");
            System.out.print(bookprice);
        }
        else{
            System.out.println("No Records found");
        }
        con.close();
    }
}
