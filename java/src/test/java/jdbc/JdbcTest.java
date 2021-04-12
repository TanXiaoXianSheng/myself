package jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static java.lang.System.*;
import static org.junit.Assert.assertTrue;

public class JdbcTest {

    private Connection conn;

    @Before
    public void getConn() {
        conn = DbUtil.getCon();
    }

    @After
    public void closeConn() {
        DbUtil.close(conn);
    }

    @Test
    public void test001() throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from users");
        while (rs.next()) {
            out.println(rs);
            out.println(rs.getInt("users.id") + "," + rs.getString("users.username") + "," + rs.getInt("users.sex"));
        }
    }

    @Test
    public void test002() throws SQLException {
        Statement stat = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stat.executeQuery("select * from users");
        while (rs.next()) {
            out.println(rs);
            out.println(rs.getInt("users.id") + "," + rs.getString("users.username") + "," + rs.getInt("users.sex"));
        }
    }


    @Test
    public void test003() throws SQLException {
        Statement stat = conn.createStatement();
        boolean bool = stat.execute("select * from users", new int[]{1, 2});
        assertTrue(bool);
        ResultSet rs = stat.getResultSet();
        while (rs.next()) {
            out.println(rs);
            //out.println(rs.getInt("users.id") + "," + rs.getString("users.username") + "," + rs.getInt("users.sex"));
        }
    }
    
    @Test
    public void test004() {
        PreparedStatement preStmt = conn.prepareStatement("select * from userscreate table users(	column_1 int null);");
        
    }
    
}
