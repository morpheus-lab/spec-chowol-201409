package shoppingmall;

public class ShoppingMallService {
	
	public static void main(String[] args) {
		
		// �α���
		MemberManager mm = new BoardManagerImpl();
		mm.doLogin("�α��� ���̵�", "�α��� �н�����");
		
		
		// ��ǰ��ȸ
		GoodsManager gm = null;
		gm.getGoodsList();
		
		// ������ȸ
		gm.getNormalPrice();
		gm.getSpecialPrice("�α��� ���̵�");
		
		// �Խ��� �� ����
		BoardManager bm = null;
		bm.write("���̵�", "����", "����");
		
		// �Խ��� �� �б�
		bm.getPost("���̵�", "�Խñ� ���̵�");
		
		
	}
	
}
