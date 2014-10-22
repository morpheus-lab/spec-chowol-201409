package generic;


public class GenericTest {
	
	public static void main(String[] args) {
		
		GenericEx newGE = new GenericEx();
		
		GenericEx<Object, Object> objGE = new GenericEx<Object, Object>();
		objGE.setValue(new Object());
		System.out.println(objGE.getValue());
		
		GenericEx<String, Integer> strGE = new GenericEx<String, Integer>();
		strGE.setValue("hello generics");
		strGE.setValue2(10);
		System.out.println(strGE.getValue().getClass());
		System.out.println(strGE.getValue2().getClass());
		
		
	}
	
}
