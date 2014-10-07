package xml.dom.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SiblingExplorer {

	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder
				.parse("file:///C:/Users/bit/git/spec-chowol-201409/XML-Day03/res/emp.xml");
		Element rootElement = document.getDocumentElement();
		
		// 사원정보/사원[0]
		Element emp = (Element) rootElement.getFirstChild();
		
		/*
		// 사원정보/사원[0]/성명
		Element ename = (Element) emp.getFirstChild();
		System.out.println(ename.getNodeName());
		
		// 사원정보/사원[0]/부서
		Element dept = (Element) ename.getNextSibling(); // 다음 형제 노드 탐색
//		ename.getPreviousSibling();	// 이전 형제 노드 탐색
		System.out.println(dept.getNodeName());
		*/
		
		// 사원정보/사원[0] 의 모든 자식 노드 탐색
//		Node currNode = emp.getFirstChild();
//		while (currNode != null) {
//			System.out.println(currNode.getNodeName() + " = " +
//					currNode.getTextContent());
//			
//			currNode = currNode.getNextSibling();
//		}
		
		// 사원정보/사원[0] 의 모든 자식 노드를 한꺼번에 조회해서 탐색
		NodeList children = emp.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			System.out.println(child.getNodeName() + " = " +
					child.getTextContent());
		}
	}

}




























