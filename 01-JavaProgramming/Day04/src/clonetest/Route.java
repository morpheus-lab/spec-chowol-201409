package clonetest;

public class Route implements Cloneable {
	
	String routeName;
	int[] path;
	double cost;	
	
	public boolean equals(Route o) {
		return false;
	}
	
	public Route clone() {
		Route clone = new Route();
		
		// 멤버 변수의 복제
		clone.routeName = this.routeName;
		if (path != null) {
			clone.path = this.path.clone();
		}
		clone.cost = this.cost;
		
		return clone;
	}
	
}
