package generic;

public class GenericEx<E, F> {
	
	private E value;
	private F value2;
	
	public E getValue() {
		return value;
	}
	
	public void setValue(E value) {
		this.value = value;
	}

	public F getValue2() {
		return value2;
	}

	public void setValue2(F value2) {
		this.value2 = value2;
	}
	
}
