package xml.dom.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DOMTreePrinter {
	
	public static boolean hasChildTextNode(Node node) {
		if (node != null) {
			NodeList children = node.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				if (children.item(i) instanceof Text) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void printNode(Node node, int level) {
		if (node == null) {
			return;
		}
		
		// 출력
		
		switch (node.getNodeType()) {
		case Node.ELEMENT_NODE:
			// 들여쓰기 출력
			String indentation = "";
			for (int i = 0; i < level; i++) {
				indentation += "    ";
			}
			System.out.print(indentation);
			
			System.out.print(node.getNodeName());
			if (!hasChildTextNode(node)) {
				System.out.println();
			}
			NamedNodeMap attrs = node.getAttributes();
			for (int i = 0; i < attrs.getLength(); i++) {
				if (i == 0) {
					System.out.print("(");
				}
				printNode(attrs.item(i), 0);
				if (i < attrs.getLength() - 1) {
					System.out.print(", ");
				} else {
					System.out.print(")");
				}
			}
			
			NodeList children = node.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				printNode(children.item(i), level + 1);
			}
			break;
		case Node.ATTRIBUTE_NODE:
			System.out.print(node.getNodeName() + " = " + node.getNodeValue());
			break;
		case Node.TEXT_NODE:
			Text text = (Text) node;
			System.out.println(" = " + text.getData());
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setValidating(false);
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder
				.parse("file:///C:/Users/bit/git/spec-chowol-201409/XML-Day03/res/emp.xml");
		Element rootElement = document.getDocumentElement();
		
		printNode(rootElement, 0);
	}
	
}
