package xml.read;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Read {
    public static void main(String[] args) throws DocumentException {
        // 创建对象
        SAXReader saxReader = new SAXReader();
        // 读取文件,生成Document对象
        Document document = saxReader.read("src/xml/scores2.xml");
        // 获取根元素
        Element root = document.getRootElement();
        // 获取子元素
        for (var temp : root.elements()) {
            // 获取元素的属性
            System.out.println(temp.attribute("id"));
            System.out.println(temp.attribute("sex"));
            Element name = temp.element("name");
            Element password = temp.element("password");
            Element age = temp.element("age");
            System.out.println(name.getText());
            System.out.println(password.getText());
            System.out.println(age.getText());
        }
    }
}
