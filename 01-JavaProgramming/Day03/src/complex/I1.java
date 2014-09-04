package complex;

public interface I1 {

	public static final int CONST_1 = 1;	// 명시적 static final
	
	public int var1 = 1;	// 묵시적 static final
	
	int var2 = 2;	// 묵시적 public static final
	
	public abstract void m1(); // 명시적 public abstract
	
	void m2();	// 묵시적 public abstract
	
}
