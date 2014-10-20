package systemapis;

public class B {
	
	int i;
	
	B() {}
	
	B(int i) {
		this.i = i;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof B) {
			B anotherB = (B) o;
			if (this.i == anotherB.i) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
//		return ("" + i);
//		return Integer.toString(i);
		return String.valueOf(i);
	}
	
}
