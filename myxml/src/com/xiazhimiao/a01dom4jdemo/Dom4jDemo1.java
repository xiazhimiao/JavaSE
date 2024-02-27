package com.xiazhimiao.a01dom4jdemo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dom4jDemo1 {
    public static void main(String[] args) throws DocumentException {

        ArrayList<Person> list = new ArrayList<>();

        SAXReader saxReader = new SAXReader();
        File file = new File("myxml\\src\\com\\xiazhimiao\\a01dom4jdemo\\person.xml");
        //获取文档对象
        Document dom = saxReader.read(file);
        //一层一层解析
        //获取根标签
        Element rootElement = dom.getRootElement();
        //获取根标签中的子标签
        List<Element> elements = rootElement.elements();
        //遍历把person中的内容加入person集合
        for (Element element : elements) {
            //获取属性值
            Attribute id = element.attribute("id");
            int idValue= Integer.parseInt(id.getText());

            //获取年龄
            Element age = element.element("age");
            double ageValue = Double.parseDouble(age.getText());

            //获取姓名
            Element name = element.element("name");
            String nameValue = name.getText();

            //创建Person对象
            Person person = new Person(idValue,nameValue,ageValue);
            //添加到集合
            list.add(person);
        }
        //打印集合
        System.out.println(list);
        //遍历集合
        //list.stream().forEach(System.out::println);这个流多余了
        list.forEach(System.out::println);

    }
}
