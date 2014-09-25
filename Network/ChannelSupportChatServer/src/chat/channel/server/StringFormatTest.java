package chat.channel.server;

public class StringFormatTest {
	
	public static void main(String[] args) {
		
		String output = String.format("[%3d] %-40s %-10s", 3, "드루와~", "안영미");
		
		System.out.println(output);
		
		System.out.println("드루와~                                    ".getBytes().length);
		
	}
	
}
