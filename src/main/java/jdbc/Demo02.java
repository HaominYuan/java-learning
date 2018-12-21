package jdbc;

import java.sql.*;

public class Demo02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 批量处理的时候可以用一下这种方式
        // 首先关闭自动提交
        // 然后用statement，预编译的方式耗内存
        // 最后执行语句，并commit().


        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/learning?useSSL=false";
        Connection connection = DriverManager.getConnection(url, "root", "88888888");
        // 关闭自动提交,jdbc默认自动提交，现在关掉
        connection.setAutoCommit(false);
        long begin = System.currentTimeMillis();
        Statement statement = connection.createStatement();
        for (int i = 0; i < 20000; i++) {
            statement.addBatch("insert into temp (id) values (" + i + ")");

        }

        statement.executeBatch();
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.println("执行时间为：" + (end - begin));
        statement.close();
        connection.close();

    }
}
