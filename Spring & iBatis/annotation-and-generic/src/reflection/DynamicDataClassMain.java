package reflection;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

public class DynamicDataClassMain {
	
	public static void main(String[] args) throws Exception {
		
		System.out.print("클래스 다운로드");
		URL url = new URL("http://www.morpheus.re.kr/DynamicData.class");
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("bin/DynamicData.class");
		byte[] buf = new byte[16];
		int len = -1;
		while ((len = in.read(buf)) > -1) {
			out.write(buf, 0, len);
			System.out.print(".");
		}
		out.flush();
		System.out.println();
		out.close();
		in.close();
		
		System.out.println("다운로드 완료");
		
		Class c = Class.forName("DynamicData");
		Object obj = c.newInstance();
		System.out.println(obj);
		
		Method[] methods = c.getDeclaredMethods();
		Method methodToInvoke = null;
		
		String methodName = "goodBye";
		
		for (Method m : methods) {
//			System.out.println(m);
			if (m.getName().equals(methodName)) {
				methodToInvoke = m;
			}
		}
		System.out.println(methodToInvoke);
		
		methodToInvoke.invoke(obj, null);//=> ((DynamicData)obj).sayHello()
		
	}
	
}
