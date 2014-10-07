package xml.sax.test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class EMPDefaultHandler extends DefaultHandler {

	// ContentHandler 부분
	@Override
	public void startDocument() throws SAXException {
		System.out.println("[ 문서 파싱 시작 ]");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("[ 문서 파싱 끝 ]");
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println(qName + " 엘리먼트 시작");
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println(qName + " 엘리먼트 끝");
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String content = new String(ch, start, length);
		System.out.println("읽은 데이터: " + content);
		super.characters(ch, start, length);
	}

	// ErrorHandler의 부분
	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("WRN: " + e.getMessage());
		super.warning(e);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.err.println("ERR: " + e.getMessage());
		super.error(e);
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.err.println("FER: " + e.getMessage());
		super.fatalError(e);
	}
	
	
	
	
	
}
