package shoppingmall;

public interface BoardManager {
	
	public void write(String loginId, String title, String content);
	
	public void delete(String loginId, String postId);
	
	public void getPost(String loginId, String postId);
	
}
