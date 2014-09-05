package collection.vs.map;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class DataStructTest {
	
	public void test(Collection c) {
		c.add(new String("first"));
		c.add(new Integer(3));
		c.add(new String("second"));
		c.add(new Integer(3));
		c.add(new Boolean(false));
		System.out.println(c);
	}
	
	public void test(Map m) {
		m.put("1", new String("first"));
		m.put("2", new Integer(3));
		m.put("3", new String("second"));
		m.put("4", new Integer(3));
		m.put("4", new Integer(7));
		System.out.println(m);
	}
	
	public static void main(String[] args) {
		Collection c;
//		c = new Vector();
		c = new HashSet();
		
		Map m;
		m = new TreeMap();
//		m = new Hashtable();
//		m = new HashMap();
		
		DataStructTest t = new DataStructTest();
		
		t.test(c);
		
		t.test(m);
	}
	
	
}
