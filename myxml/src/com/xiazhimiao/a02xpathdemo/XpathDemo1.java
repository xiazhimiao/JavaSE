package com.xiazhimiao.a02xpathdemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XpathDemo1 {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("myxml\\src\\com\\xiazhimiao\\a02xpathdemo\\parson.xml"));

        //这里的全文检索“//”，是子孙后代的意思，不论多深都能找到
        List<Node> elements = document.selectNodes("//爹//孙/name");

        System.out.println(elements.size());
        for (Node element : elements) {
            System.out.println(element.getText());
        }

    }
}
