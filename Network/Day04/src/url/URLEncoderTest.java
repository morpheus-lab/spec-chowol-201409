package url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String s = "안녕하세요";
		
		String encodedStr = URLEncoder.encode(s, "UTF-8");
		
		String webEncoded = "%EC%95%88%EB%85%95%ED%95%98%EC%84%B8%EC%9A%94";
		
		System.out.println(encodedStr);
		
		System.out.println(encodedStr.equals(webEncoded));
		
	}
	
}
