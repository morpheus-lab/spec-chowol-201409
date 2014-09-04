package classclass;


public class ClassTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		/*
		Class aClass = a.getClass();
		System.out.println(aClass.getName());
		
		Field[] aFields = aClass.getFields();
		for (int i = 0; i < aFields.length; i++) {
			System.out.println(aFields[i].getName());
		}
		
		Method[] aMethods = aClass.getMethods();
		for (int i = 0; i < aMethods.length; i++) {
			System.out.print(aMethods[i].getDeclaringClass() + ".");
			System.out.print(aMethods[i].getName());
			System.out.print("(");
			Class[] paramsClass = aMethods[i].getParameterTypes();
			for (int j = 0; j < paramsClass.length; j++) {
				System.out.print(paramsClass[j].getName() + " ");
			}
			System.out.println(")");
		}
		*/
		Class clazz = null;
		
//		clazz = A.class;
		A a = new A(0);
		clazz = a.getClass();
		
		A a1 = (A) clazz.newInstance();
		
		System.out.println(a);
		System.out.println(a1);
		
	}
	
}
