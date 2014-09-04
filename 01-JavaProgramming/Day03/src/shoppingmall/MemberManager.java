package shoppingmall;

public interface MemberManager {

	public void doLogin(String loginId, String loginPw);
	
	public int getMemberLevel(String loginId);
	
	public void modifyLoginPassword(String loginId, String oldLoginPw, String loginPw);
	
	
}
