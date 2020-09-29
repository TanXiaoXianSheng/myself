package jdbc;

import java.sql.*;
import java.util.Random;

public class _01 {


    public void insert(PreparedStatement state,Random random){
        String[] usernameArr = new String[]{"Zhao","Qian","Sun","Li","Yi","Er","San","Si","Wu","Guoqin","Zhongqiu","Duanwu","Cunjie","Yuanxiao","Hua","Cao","Fang","Cheng","Zhou","Zhong","Guo"};
        String[] fullnameArr = new String[]{"赵","钱","孙","李","一","二","三","四","五","国庆","中秋","端午","春节","元宵","除夕","话","花","草","方","成","周","中","国"};

        try {
            state.setString(1,usernameArr[random.nextInt(usernameArr.length)] + usernameArr[random.nextInt(usernameArr.length)]);
            state.setString(2,fullnameArr[random.nextInt(fullnameArr.length)] + fullnameArr[random.nextInt(fullnameArr.length)]);
            state.setDate(3,new Date(System.currentTimeMillis()));
            state.setString(4,"188"+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9));
            state.setString(5,"" + +random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9) + "@qq.com");
            state.setString(6,"" + random.nextInt(2));
            state.setString(7,"address");
            state.setString(8,"" + random.nextInt(5));
            state.setDate(9,new Date(System.currentTimeMillis()));
            state.setDate(10,new Date(System.currentTimeMillis()));

            state.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void insertArticle(PreparedStatement preState,Random random) {
        String[] fullnameArr = new String[]{"赵","钱","孙","李","一","二","三","四","五","国庆","中秋","端午","春节","元宵","除夕","话","花","草","方","成","周","中","国"};

        try {
            preState.setString(1,fullnameArr[random.nextInt(fullnameArr.length)] + fullnameArr[random.nextInt(fullnameArr.length)]);

            preState.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void insertUserArticle(PreparedStatement preState,Random random) {
        try {
            preState.setInt(1,random.nextInt(500) + 1);
            preState.setInt(2,random.nextInt(1000));

            preState.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void insertTestAndUser(int count) throws Exception{
        Random random = new Random();

        Connection con = DbUtil.getCon();
        con.setAutoCommit(false);
        PreparedStatement preState = con.prepareStatement("insert into t_user(username,fullname,birthday,phone,email,sex,address,education,create_time,update_time) values(?,?,?,?,?,?,?,?,?,?)");

        for (int i = 0;i < count;i ++){
            this.insert(preState,random);
            if (i % 500 == 0) {
                con.commit();
                System.out.println(i);
            }
        }
        con.commit();

        DbUtil.close(con);
    }

    private void insertArticle(int count) throws Exception{
        Random random = new Random();

        Connection con = DbUtil.getCon();
        con.setAutoCommit(false);
        PreparedStatement preState = con.prepareStatement("insert into t_article(name) values(?)");

        for (int i = 0;i < count;i ++){
            this.insertArticle(preState,random);
            if (i % 500 == 0) {
                con.commit();
                System.out.println(i);
            }
        }
        con.commit();

        DbUtil.close(con);
    }

    private void insertUserArticle(int count) throws Exception {
        Random random = new Random();

        Connection con = DbUtil.getCon();
        con.setAutoCommit(false);
        PreparedStatement preState = con.prepareStatement("insert into t_user_article(user_id,article_id) values(?,?)");

        for (int i = 0;i < count;i ++){
            this.insertUserArticle(preState,random);
            if (i % 500 == 0) {
                con.commit();
                System.out.println(i);
            }
        }
        con.commit();

        DbUtil.close(con);
    }

    public static void main(String[] args) throws Exception{
        _01 demo = new _01();
        //demo.insertTestAndUser(1000);
        //demo.insertArticle(99000);
        demo.insertUserArticle(80000);
    }
}
