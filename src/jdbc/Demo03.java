package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        // 事物和模拟回滚
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/learning?useSSL=false";
        Connection connection = DriverManager.getConnection(url, "root", "88888888");
        // 关闭自动提交,jdbc默认自动提交，现在关掉
        connection.setAutoCommit(false);


        PreparedStatement ps = connection.prepareStatement("insert into temp (id) values (?)");
        ps.setInt(1, 1);
        ps.execute();

        Thread.sleep(1000);

        System.out.println("插入编号为1");
        try {
            ps.setInt(1, 2);
//            ps.setObject(1, "object");
            ps.execute();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
    }

}
