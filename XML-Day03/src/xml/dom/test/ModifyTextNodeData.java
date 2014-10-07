package xml.dom.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class ModifyTextNodeData {
	
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
		
		// 사원정보/사원[0]/성명
		Element ename = (Element) emp.getFirstChild();
		
		/* TEXT NODE 값 변경 */
		
		// 사원정보/사원[0]/성명/#text
		Text textNode = (Text) ename.getFirstChild();
		
		System.out.println("바꾸기 전 값: " + textNode.getData());
		
		// 값 변경
		textNode.setData("홍길동");
		
		System.out.println("바꾼 후 값: " + textNode.getData());
		
		/* ATTRIBUTE 값 변경 */
		// 사원정보/사원[0]/성명/@사번
		Attr empno = ename.getAttributeNode("사번");
		
		System.out.println("속성 바꾸기 전: " + empno.getNodeValue());
		
//		empno.setValue("99999");
		ename.setAttribute("사번", "77777");
		
		System.out.println("속성 바꾼 후: " + empno.getNodeValue());
		
		// 사원 엘리먼트 추가
		Element newEmp = document.createElement("사원"); // 새로운 노드 생성
		// 새 노드의 위치 설정
//		rootElement.appendChild(newEmp); // 맨 마지막 child로 append
		rootElement.insertBefore(newEmp, rootElement.getFirstChild()); // 맨 앞에 삽입
	}
	
}







