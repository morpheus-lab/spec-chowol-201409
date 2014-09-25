package url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	
	public static void main(String[] args) {
		
		URL url = null;
		
		try {
			url = new URL("http://www.naver.com/static/p/file.txt?query#fragment");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if (url != null) {
			System.out.println("프로토콜: " + url.getProtocol());
			System.out.println("호 스 트: " + url.getHost());
			System.out.println("포    트: " + url.getPort());
			System.out.println("경    로: " + url.getPath());
			System.out.println("쿼    리: " + url.getQuery());
			System.out.println("Fragment: " + url.getRef());
		}
	}
	
}
