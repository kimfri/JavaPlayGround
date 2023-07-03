package org.kimfri.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
    XmlParser xmlParser = new XmlParser();
    xmlParser.doit();
  }

  private void doit() throws ParserConfigurationException, IOException, SAXException, TransformerException {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = builder.parse(new File("src/test/resources/file1.xml"));
    doc.getDocumentElement().normalize();

    List<String> removeUs = new ArrayList<>();
    final NodeList nodeList = doc.getElementsByTagName("session");
    final NodeList childNodes = nodeList.item(0).getChildNodes();
    System.err.println("childNodes.len: " + childNodes.getLength());
    for (int i = 0; i < childNodes.getLength(); i++) {
      final Node node = childNodes.item(i);
      System.err.println("node:  " + node.getNodeName());
      if (!hasGrandChildren(node)) {
        removeUs.add(node.getNodeName());
      }
    }

    for (String name : removeUs) {
      System.err.println("name: " + name);
      final NodeList nl = doc.getElementsByTagName(name);
      doc.getDocumentElement().removeChild(nl.item(0));
    }


    writeXml(doc);
  }

  boolean hasGrandChildren(Node node) {
    System.err.println("nodeName: " + node.getNodeName());
    if (node.getNodeName().equals("comments")) {
      return false;
    }
    return true;
  }

  void writeXml(Document document) throws TransformerException, IOException {
    String fileName = "target/file1_modified.xml";
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    DOMSource source = new DOMSource(document);
    FileWriter writer = new FileWriter(new File(fileName));
    StreamResult result = new StreamResult(writer);
    transformer.transform(source, result);
  }
}
