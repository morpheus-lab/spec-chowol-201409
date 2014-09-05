package mudgame;

import java.util.ArrayList;

public abstract class Unit implements Movable {
	
	public String unitName;
	public int health;
	public ArrayList<String> skills;
	
	@Override
	public void move(String direction) {
		System.out.println(direction + " 방향으로 이동합니다.");
	}

	public void displayHealth() {
		System.out.println("현재 체력은 " + this.health + "입니다.");
	}
	
}
