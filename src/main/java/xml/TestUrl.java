package xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class TestUrl {
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
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        List<Url> list = selAll();
        writeNumToXml(list);
    }


    private static void writeNumToXml(List<Url> list) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element nums = document.addElement("urls");
        for (Url num : list) {
            nums.addElement("url")
                    .addAttribute("id", num.getID() + "")
                    .addAttribute("url", num.getUrl());
        }

        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/xml/urls.xml"), format);
        xmlWriter.write(document);
        xmlWriter.close();
    }

    private static List<Url> selAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from record";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Url> list = new ArrayList<>();
        while (resultSet.next()) {
            Url num = new Url();
            num.setID(resultSet.getInt("id"));
            num.setUrl(resultSet.getString("url"));
            list.add(num);
        }
        preparedStatement.close();
        connection.close();
        return list;
    }


    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

}
