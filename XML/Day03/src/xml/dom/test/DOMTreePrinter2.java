package xml.dom.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTreePrinter2 {
	
	public static void main(String[] args) throws Exception {
		
		// XML을 파싱할 파서 준비 작업
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setValidating(false);
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();	// DOM Parser
		
		// XML 문서를 파싱
		Document doc = builder.parse("file:///C:/Users/bit/git/spec-chowol-201409/XML-Day03/res/emp.xml");
		
		Element empInfo = doc.getDocumentElement();	// <사원정보>
		System.out.println(empInfo.getNodeName());
		
		NodeList emps = empInfo.getChildNodes();	// <사원>, <사원>
		for (int i = 0; i < emps.getLength(); i++) {
			Element emp = (Element) emps.item(i);	// <사원>
			System.out.println("    " + emp.getNodeName());
			
			// <사원>의 자식 노드들 출력
			NodeList empChildren = emp.getChildNodes();
			for (int j = 0; j < empChildren.getLength(); j++) {
				Element empChild = (Element) empChildren.item(j);
				System.out.print("        " + empChild.getNodeName());
				
				// 속성이 있다면 출력
				if (empChild.hasAttributes()) {
					System.out.print(" (");
					
					NamedNodeMap map = empChild.getAttributes();
					for (int k = 0; k < map.getLength(); k++) {
						if (k > 0) {
							System.out.print(", ");
						}
						Attr attr = (Attr) map.item(k);
						System.out.print(attr.getNodeName() + " = " +
								attr.getNodeValue());
					}
					
					System.out.print(")");
				}
				// <사원>/<??> 의 내용
				System.out.println(" = " + empChild.getTextContent());
			}
		}
		
//		Node sibling = empInfo.getFirstChild();
//		while (sibling != null) {
//			// working
//			sibling = sibling.getNextSibling();
//		}
	}
	
}
