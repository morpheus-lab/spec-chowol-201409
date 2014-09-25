package chat.channel.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ChatServerThread extends Thread {
	
	// 이 쓰레드에게 할당된 클라이언트와 연결되어 있는 소켓
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;
	private String userId;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void sendMessage(String message) throws IOException {
		writer.write(message + "\n");
		writer.flush();
	}
	
	public String readMessage() throws IOException {
		return reader.readLine();
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	@Override
	public void run() {
		
		try {
			// 클라이언트와 메시지를 주고 받을 Writer 및 Reader 객체 생성
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 환영 메시지를 클라이언트로 보내기
			sendMessage("스펙초월 채팅 서버에 접속하신 것을 환영합니다.");
			
			// 클라이언트로부터 로그인 정보 입력받기
			sendMessage("아이디를 입력하세요.");
			this.userId = readMessage();
			
			// 중복 아이디를 사용하는 클라이언트가 있는지 체크
			// TODO
			
			boolean willLeave = false;
			while (!willLeave) {
				// 클라이언트에게 메뉴 보여주기
				sendMessage("[채팅방 목록]\n"
						+ ChatServer.getAllChannelInfos()
						+ "\n1. 채팅방 개설   2. 채팅방 참여   3. 접속 종료");
				// 클라이언트가 선택한 메뉴 읽기
				int menu = -1;
				while (!(menu > 0 && menu < 4)) {
					try {
						sendMessage("메뉴를 선택하세요.");
						menu = Integer.parseInt(readMessage());
					} catch (NumberFormatException e) {
						menu = -1;
					}
				}
				
				switch (menu) {
				case 1:
					// 채팅방 개설에 필요한 정보 입력 받기
					sendMessage("방 제목을 입력하시오.");
					String channelTitle = readMessage();
					// 채팅방 개설
					ChatChannel channel = new ChatChannel(this.userId, channelTitle);
					// 서버의 채팅방 목록에 개설된 채팅방 추가
					synchronized (ChatServer.CHANNELS) {
						ChatServer.CHANNELS.add(channel);
					}
					// 개설된 채팅방에 입장시키기
					channel.letClientJoin(this);
					break;
				case 2:
					// 채팅방 번호 선택
					boolean channelSelectOk = false;
					ChatChannel channelToJoin = null;
					while (!channelSelectOk) {
						try {
							sendMessage("방을 선택하세요.");
							int channelNo = Integer.parseInt(readMessage());
							// 입력한 방 번호가 있나?
							synchronized (ChatServer.CHANNELS) {
								for (int i = 0; i < ChatServer.CHANNELS.size(); i++) {
									ChatChannel c = ChatServer.CHANNELS.get(i);
									if (c.getChannelNo() == channelNo) {
										// c가 입장할 채널
										channelToJoin = c;
										channelSelectOk = true;
										break;
									}
								}
							}
						} catch (NumberFormatException e) {
							channelSelectOk = false;
						}
					}
					// 채팅방에 입장
					if (channelToJoin != null) {
						channelToJoin.letClientJoin(this);
					} else {
						sendMessage("존재하지 않는 방입니다.");
					}
					break;
				case 3:
					willLeave = true;
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(userId + "님의 접속이 종료되었습니다.");
		} finally {
			// ChatServer의 CLIENTS로부터 이 클라이언트 제거
			
			// ChatServer의 모든 채팅방으로부터 이 클라이언트 제거
			
			// 접속 종료
			try {
				sendMessage("접속을 종료합니다. ㅂㅇㅉㅇㅉㅇ");
			} catch (IOException e) {}
			try {
				writer.close();
			} catch (IOException e) {}
			try {
				reader.close();
			} catch (IOException e) {}
			try {
				socket.close();
			} catch (IOException e) {}
		}
		
	}
	
	
}
