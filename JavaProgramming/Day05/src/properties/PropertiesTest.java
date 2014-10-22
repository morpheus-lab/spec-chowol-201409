package properties;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
	
	public static void main(String[] args) {
		
		Properties props = System.getProperties();
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			System.out.print(key + " = ");
			Object value = props.get(key);
			System.out.println(value);
		}
		
		
	}
	
	
}
