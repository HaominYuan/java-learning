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
        System.out.println(root.elements().getClass());
        for (var temp : root.elements()) {
            // 获取元素的属性
            System.out.println(((Element) temp).attribute("id"));
            System.out.println(((Element) temp).attribute("sex"));
            Element name = ((Element) temp).element("name");
            Element password = ((Element) temp).element("password");
            Element age = ((Element) temp).element("age");
            System.out.println(name.getText());
            System.out.println(password.getText());
            System.out.println(age.getText());
        }
    }
}
