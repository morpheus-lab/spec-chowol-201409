package stringbuffer;

public class StringBufferTest {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(12).append('d');
		System.out.println(sb);
		
		sb.setCharAt(0, 'x');
		System.out.println(sb);
		
		sb.insert(1, 3.14);
		System.out.println(sb);
		
		char[] ca = new char[sb.length()];
		sb.getChars(0, sb.length(), ca, 0);
		
		for (int i = 0; i < ca.length; i++) {
			
			System.out.println(ca[i]);
			
		}
		System.out.println();
	}
	
}
