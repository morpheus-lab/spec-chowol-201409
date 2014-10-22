package annotations;

import java.lang.annotation.Annotation;

public class ReflectionTest {
	
	public static void main(String[] args) throws Exception {
		
		Class clazz = Class.forName("annotations.MyClass1");
		
		Annotation[] annos = clazz.getAnnotations();
		if (annos != null) {
			for (Annotation a : annos) {
				System.out.println(a.toString());
			}
		}
		
		Object obj = clazz.newInstance();
		
	}
	
}
