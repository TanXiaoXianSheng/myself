package jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static java.lang.System.*;

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

    /**
     *
     * 参考：https://blog.csdn.net/thirtysix1207/article/details/1799800
     * 参数01：
     * ResultSet.TYPE_FORWARD_ONLY    Result 指针只可向后移动
     * ResultSet.TYPE_SCROLL_INSENSITIVE    ResultSet 指针可前后移动，不及时同步数据库数据变化
     * ResultSet.TYPE_SCROLL_SENSITIVE    ResultSet 指针可前后移动，并及时同步数据库数据变化
     *
     * 参数02：
     * ResultSet.CONCUR_READ_ONLY   ResultSet 只读
     * ResultSet.CONCUR_UPDATABLE    ResultSet 可更新数据库数据
     * @throws SQLException
     */
    @Test
    public void test002() throws SQLException {
        Statement stat = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stat.executeQuery("select * from users");
        while (rs.next()) {
            out.println(rs.getInt("users.id") + "," + rs.getString("users.username") + "," + rs.getInt("users.sex"));
        }
        out.println("------------------------------------------");
        while (rs.next()) {
            out.println(rs.getInt("users.id") + "," + rs.getString("users.username") + "," + rs.getInt("users.sex"));
        }
    }


    @Test
    public void test003() throws SQLException {
        Statement stat = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stat.executeQuery("select * from users");
        while (rs.next()) {
            out.println(rs.getInt("users.id") + "," + rs.getString("users.username") + "," + rs.getInt("users.sex"));
        }
        out.println("------------------------------------------");
        while (rs.next()) {
            out.println(rs.getInt("users.id") + "," + rs.getString("users.username") + "," + rs.getInt("users.sex"));
        }
    }
    
    @Test
    public void test004() throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from users");
        while (rs.next()) {
            out.println(rs.getInt("users.id") + "," + rs.getString("users.username") + "," + rs.getInt("users.sex"));
        }
    }

    @Test
    public void test005() throws SQLException {
        PreparedStatement preStmt = conn.prepareStatement("insert into users(username, sex) value('123', 2)", Statement.RETURN_GENERATED_KEYS);
        int a = preStmt.executeUpdate();
        ResultSet rs = preStmt.getGeneratedKeys();
        while (rs.next()) {
            out.println(rs.getInt(1));
            out.println(rs.getInt("GENERATED_KEY"));
        }
    }

    @Test
    public void test006() throws SQLException {
        PreparedStatement preStmt = conn.prepareStatement("insert into users(username, sex) value('123', 2)", Statement.NO_GENERATED_KEYS);
        int a = preStmt.executeUpdate();
        ResultSet rs = preStmt.getGeneratedKeys();
        while (rs.next()) {
            out.println(rs.getInt(1));
            out.println(rs.getInt("GENERATED_KEY"));
        }
    }

    @Test
    public void test007() throws SQLException {
        PreparedStatement preStmt = conn.prepareStatement("insert into users(username, sex) value('123', 2)");
        int a = preStmt.executeUpdate();
        ResultSet rs = preStmt.getGeneratedKeys();
        while (rs.next()) {
            out.println(rs.getInt(1));
            out.println(rs.getInt("GENERATED_KEY"));
        }
    }
    
}
