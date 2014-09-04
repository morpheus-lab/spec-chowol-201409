package string;

public class EqualsTest {
	
	public static void main(String[] args) {
		
		String s1 = new String("Hello Java!");
		String s2 = new String("Hello");
		String s3 = "HeLLo";
		String s4 = "Hello";
		
		System.out.println("*** Hash Code ***");
		System.out.println("s1: " + s1.hashCode());
		System.out.println("s2: " + s2.hashCode());
		System.out.println("s3: " + s3.hashCode());
		System.out.println("s4: " + s4.hashCode());
		
		System.out.println("*** '==' 비교 ***");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		
		System.out.println("*** equals() 비교 ***");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));
		
//		System.out.println(s1.charAt(5)); // StringIndexOutOfBoundsException 발생
		
		// substring()
		System.out.println(s1.substring(2, 6));
		System.out.println(s1.substring(3));
		
		// trim()
		String str = "  \t    Hi? I'm John. Nice to meet you!      ";
		System.out.println("[" + str + "]");
		str = str.trim();
		System.out.println("[" + str + "]");
		
		// special characters
//		'\t';	// tab
//		'\r';	// carriage return
//		'\n';	// line feed
		
		// toUpperCase()
		System.out.println(str.toUpperCase());
		// toLowerCase()
		System.out.println(str.toLowerCase());
		
		// 대소문자 관계없이 비교
		System.out.println(s2.toUpperCase().equals(s3.toUpperCase()));
		System.out.println(s2.toLowerCase().equals(s3.toLowerCase()));
		
		
		// replace()
		String helloWorld = "Hello World!!";
		String replacedStr = helloWorld.replace('o', 'a');
		System.out.println(replacedStr);
		
		// startsWith()
		if (helloWorld.startsWith("hell")) {
			System.out.println("hell로 시작하는 문자열");
		} else {
			System.out.println("hell로 시작하지 않는 문자열");
		}
		
		// endsWith()
		if (helloWorld.endsWith("orld!")) {
			System.out.println("orld!로 끝나는 문자열");
		} else {
			System.out.println("orld!로 끝나지 않는 문자열");
		}
		
		String helloJava = "hello jane! java is wonderful!";
		
		// indexOf()
		System.out.println(helloJava.indexOf('l'));
		System.out.println(helloJava.indexOf('l', 3));
		System.out.println(helloJava.indexOf("ja"));
		System.out.println(helloJava.indexOf("ja", 7));
		
		// lastIndexOf()
		System.out.println(helloJava.lastIndexOf('l'));
		System.out.println(helloJava.lastIndexOf('a', 1));
		System.out.println(helloJava.lastIndexOf("ja"));
		System.out.println(helloJava.lastIndexOf("ja", 10));
		
	}
	
}
