package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private final static String dbUrl = "jdbc:mysql://localhost:3307/db_test";
    private final static String dbUsername = "root";
    private final static String dbPassword = "1226";
    private final static String jdbcName = "com.mysql.jdbc.Driver";

    public static Connection getCon(){
        Connection con = null;
        try {
            Class.forName(jdbcName);
            con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Connection con = getCon();
        close(con);
    }
}
