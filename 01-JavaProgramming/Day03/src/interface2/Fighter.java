package interface2;

public class Fighter extends Unit
implements Attackable, Fightable, Movable {

	@Override
	public void move() {
		System.out.println("이동합니다.");
	}

	@Override
	public void fight() {
		System.out.println("전투 시작");
	}

	@Override
	public void fight(int skill) {
		System.out.println("스킬" + skill + "을 사용하여 전투 시작");
	}

	@Override
	public void attack() {
		System.out.println("공격");
	}

	@Override
	public void heal() {
		System.out.println("치유");
	}

	
	
}
