package xml.write;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Write {
    public static void main(String[] args) throws IOException {
        // 通过DocumentHelper
        Document doc = DocumentHelper.createDocument();
        // 添加并得到根元素
        Element root = doc.addElement("books");
        // 为根元素添加子元素
        Element book = root.addElement("book");
        book.addAttribute("id", "b01");
        // 为book添加子元素
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        Element price = book.addElement("price");
        name.addText("第七天");
        author.addText("余华");
        price.addText("50");

        // 第一种输出方式
        Writer writer1 = new FileWriter("src/xml/bookout1.xml");
        doc.write(writer1);
        writer1.close();

        // 第二种输出方式
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/xml/bookout2.xml"), format);
        xmlWriter.write(doc);
        xmlWriter.close();
    }
}
