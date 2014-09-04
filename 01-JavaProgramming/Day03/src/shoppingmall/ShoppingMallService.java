package shoppingmall;

public class ShoppingMallService {
	
	public static void main(String[] args) {
		
		// 로그인
		MemberManager mm = new BoardManagerImpl();
		mm.doLogin("로그인 아이디", "로그인 패스워드");
		
		
		// 상품조회
		GoodsManager gm = null;
		gm.getGoodsList();
		
		// 가격조회
		gm.getNormalPrice();
		gm.getSpecialPrice("로그인 아이디");
		
		// 게시판 글 쓰기
		BoardManager bm = null;
		bm.write("아이디", "제목", "내용");
		
		// 게시판 글 읽기
		bm.getPost("아이디", "게시글 아이디");
		
		
	}
	
}
