package chat;

import java.io.IOException;

public class ChattingServerMain {
	
	public static void main(String[] args) throws IOException {
		
		ChattingServer server = new ChattingServer(10001);
		
		while (true) {
			ChattingThread t = server.accept();
			server.addClient(t);
			t.start();
		}
		
	}
	
}
