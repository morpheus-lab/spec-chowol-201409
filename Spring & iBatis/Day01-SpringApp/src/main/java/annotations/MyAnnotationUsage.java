package annotations;

//@MyAnnotation(value="클래스")
public class MyAnnotationUsage {
	
	@MyAnnotation(value="필드")
	String field;
	
//	@MyAnnotation(value="생성자")
	public MyAnnotationUsage() {
	}
	
	@MyAnnotation(value="메서드")
	public void myMethod() {
//		@MyAnnotation("지역변수")
		String local;
	}
	
}
