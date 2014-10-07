package xml.sax.test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserTest {
	
	public static void main(String[] args) throws Exception {
		
		// factory 객체 얻기
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// DTD validation 활성화
		factory.setValidating(true);
		// Namespace 해석 비활성화
		factory.setNamespaceAware(false);
		
		// SAXParser 객체 얻기
		SAXParser parser = factory.newSAXParser();
		
		// DefaultHandler 상속받은 EMPDefaultHandler 객체 생성
		EMPDefaultHandler handler = new EMPDefaultHandler();
		
		// handler를 이용해서 XML 문서 파싱
		parser.parse("file:///C:/Users/bit/git/spec-chowol-201409/XML-Day03/res/emp.xml", handler);
	}
	
}
























