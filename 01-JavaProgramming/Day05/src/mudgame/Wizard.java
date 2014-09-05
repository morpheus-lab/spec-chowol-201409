package mudgame;

public class Wizard extends Unit implements Fightable, Healable {
	
	public int mana;
	
	public Wizard(String unitName) {
		this.unitName = unitName;
		this.health = 100;
		this.mana = 100;
	}
	
	@Override
	public void heal(Unit targetUnit) {
		System.out.println(this.unitName + "님이 " + targetUnit.unitName + "님을 치유하였습니다.");
		if (targetUnit.health > 90) {
			targetUnit.health = 100;
			System.out.println(targetUnit.unitName + "님의 체력이 가득 찼습니다.");
		} else {
			targetUnit.health += 10;
			System.out.println(targetUnit.unitName + "님의 체력이 10 증가하였습니다.");
		}
	}

	@Override
	public void fight(Unit targetUnit) {
		System.out.println(this.unitName + "님이 " + targetUnit.unitName + "님을 공격하였습니다.");
		if (targetUnit.health < 10) {
			targetUnit.health = 0;
			System.out.println(targetUnit.unitName + "님이 사망하였습니다.");
		} else {
			targetUnit.health -= 10;
			System.out.println(targetUnit.unitName + "님의 체력이 10 감소하였습니다.");
		}
	}
	
	public void displayMana() {
		System.out.println("현재 마나는 " + this.mana + "입니다.");
	}

}
