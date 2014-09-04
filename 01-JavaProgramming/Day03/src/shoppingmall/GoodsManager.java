package shoppingmall;

public interface GoodsManager {
	
	public String[] getGoodsList();
	
	public void getGoodsInfo(String goodsId);
	
	public int getNormalPrice();
	
	public int getSpecialPrice(String loginId);
	
}
