package wrapper;

public class WrapperPrimTest {
	
	public static void main(String[] args) {
		
		byte b = 3;
		int i = 257;
		
		Byte b2 = new Byte(b);
		Integer i2 = new Integer(i);
		
		print( b2 );  // 3
		print( i2 );  // 257

		byte b3 = b2.byteValue();
		int i3 = i2.intValue();
		int i4 = i2.byteValue();
		System.out.println( "b3 = " + b3 ); // b3 = 3
		System.out.println( "i3 = " + i3 ); // i3 = 257
		System.out.println( "i4 = " + i4 ); // i4 = 1
		
		
		
		System.out.println(Integer.toString(15, 16));
		
	}
	
	static void print(Number n) {
		System.out.println( n.intValue() );
	}

	
}
