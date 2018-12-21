package jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class Demo01 {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;


    static {
        Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("DB.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = "jdbc:mysql://localhost/learning?useSSL=false";
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(driver);

        // 这里建立连接是通过socket来连接，异常耗时
        Connection connection = DriverManager.getConnection(url, user, password);

        // statement 效率低并且容易发生sql注入，但是在大规模插入的时候preparedStatement语句因为预编译会占用内存
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM orders";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("cust_id"));
        }

        // preparedStatement会预编译
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orders set order_date = ? where cust_id = ?");
        preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
        preparedStatement.setInt(2, 10001);

        // executeUpdate 适用于DELETE,UPDATE,INSERT，返回的是影响的行的数目
        // executeQuery 适用于SELECT语句
        // execute 返回boolean，如果有结果则为true
        System.out.println(preparedStatement.executeUpdate());

        preparedStatement.close();
        preparedStatement = connection.prepareStatement("SELECT * FROM orders where cust_id = ?");
        preparedStatement.setInt(1, 10001);

        // ResultSet采用的是游标结构
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1) + resultSet.getString(2) + " " + resultSet.getString(3));
        }




        // 记得关闭
        preparedStatement.close();
        connection.close();
    }
}
