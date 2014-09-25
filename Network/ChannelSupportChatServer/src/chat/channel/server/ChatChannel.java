package chat.channel.server;

import java.io.IOException;
import java.util.ArrayList;

public class ChatChannel {
	
	private static Integer channelSeq = 0;
	
	// 채팅방이 갖는 속성
	// 필드 (멤버 변수)
	
	// 이 채팅방에 속해 있는 클라이언트 목록
	private ArrayList<ChatServerThread> channelClients;
	
	// 채팅방 번호
	private int channelNo;
	
	// 채팅방 개설한 사람의 ID
	private String channelOwnerId;
	
	// 채팅방 제목
	private String channelTitle;
	
	// 채팅방이 개설될 때, 초기 작업
	// 생성자
	public ChatChannel(String chnnelOwnerId, String channelTitle) {
		this.channelOwnerId = chnnelOwnerId;
		this.channelTitle = channelTitle;
		this.channelClients = new ArrayList<ChatServerThread>();
		synchronized (channelSeq) {
			this.channelNo = ++channelSeq;
		}
	}
	
	// 채팅방의 기능
	
	public int getChannelNo() {
		return this.channelNo;
	}
	
	// 이 채팅방에 속한 모든 클라이언트에게 메시지 보내기
	public void sendMessageToAllInThisChannel(String message) throws IOException {
		synchronized (channelClients) {
			for (int i = 0; i < channelClients.size(); i++) {
				ChatServerThread client = channelClients.get(i);
				client.sendMessage(message);
			}
		}
	}
	
	// 이 채팅방에 참여시키기
	public void letClientJoin(ChatServerThread client) throws IOException {
		synchronized (channelClients) {
			channelClients.add(client);
		}
		client.sendMessage("[" + channelTitle + "] 채팅방에 입장하였습니다.");
		sendMessageToAllInThisChannel(client.getUserId() + "님이 입장하였습니다.");
		while (true) {
			// 클라이언트로부터 메시지 수신
			String message = client.readMessage();
			// "/quit"을 입력하면 방에서 나감
			if ("/quit".equals(message)) {
				letClientLeave(client);
				break;
			}
			// 이 채팅방의 모든 클라이언트로 메시지 송신
			sendMessageToAllInThisChannel(client.getUserId() + ": " + message);
		}
	}
	
	// 이 채팅방으로 부터 내보내기
	public void letClientLeave(ChatServerThread client) throws IOException {
		synchronized (channelClients) {
			channelClients.remove(client);
		}
		sendMessageToAllInThisChannel(client.getUserId() + "님이 나가셨습니다.");
	}
	
	// 이 채팅방에 대한 정보 조회
	public String getInfo() {
		return String.format("[%3d] %-40s %-10s", channelNo, channelTitle, channelOwnerId);
	}
	
}
