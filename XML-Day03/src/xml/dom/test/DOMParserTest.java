package xml.dom.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

// import 정리: CTRL + SHIFT + o

public class DOMParserTest {
	
	public static void main(String[] args) throws Exception {
		
		// DOM 파서 팩토리
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		// 팩토리 설정 변경
		// whitespace 무시하도록 설정
		factory.setIgnoringElementContentWhitespace(true);
		// DTD 유효성 검사를 하도록 설정
		factory.setValidating(true);
		// Namespace를 해석하도록 설정
		factory.setNamespaceAware(true);
		
		// DOM 파서
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// XML 문서 파싱
		Document document = builder.parse("file:///C:/Users/bit/git/spec-chowol-201409/XML-Day03/res/emp.xml");
		
		// root 엘리먼트
		Element rootElement = document.getDocumentElement();
		
		System.out.println("최상위 엘리먼트 이름: " + rootElement.getNodeName());
		System.err.println("최상위 엘리먼트 값  : " + rootElement.getNodeValue());
	}
	
}
