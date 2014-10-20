package stringtokenizer;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	
	public static void main(String[] args) {
		
		String text = "Now is the time for all good men (and women)...";
		
		StringTokenizer st = new StringTokenizer(text);
		
//		while (st.hasMoreTokens()) {
//			
//			String word = st.nextToken();
//			
//			System.out.println(word);
//			
//		}
		
		text = "http://www.go:ogle.com/";
		st = new StringTokenizer(text, "/:.");
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			System.out.println(word);
		}
	}
	
}
