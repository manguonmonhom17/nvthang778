package QLSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QL {

	
	private static String DB_URL ="jdbc:sqlserver://DESKTOP-PA4CV49\\LLOYY:1433;databaseName=QLSP;integratedSecurity=true";
        
	 public static void main(String args[]) {
	        try {
	            // connnect to database 'testdb'
	            Connection conn = getConnection(DB_URL);
	            // crate statement
	            Statement stmt = conn.createStatement();
	            // get data from table 'student'
	            ResultSet rs = stmt.executeQuery("select * from SanPham");
	            // show data
	            System.out.println("MaSP      TenSP   NhaSX       MaLoai");
	            while (rs.next()) {
	                System.out.println(rs.getString("MaSP") + "" + rs.getString("TenSP") 
	                        + "  " + rs.getString("NhaSanXuat") + "       " + rs.getString("MaLoaiSP"));
	            }
	            // close connection
	            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	    public static Connection getConnection(String dbURL) {
	        Connection conn = null;
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            conn = DriverManager.getConnection(dbURL);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn;
	    }
}
