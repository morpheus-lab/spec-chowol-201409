package interface2;

public class Fighter extends Unit
implements Attackable, Fightable, Movable {

	@Override
	public void move() {
		System.out.println("�̵��մϴ�.");
	}

	@Override
	public void fight() {
		System.out.println("���� ����");
	}

	@Override
	public void fight(int skill) {
		System.out.println("��ų" + skill + "�� ����Ͽ� ���� ����");
	}

	@Override
	public void attack() {
		System.out.println("����");
	}

	@Override
	public void heal() {
		System.out.println("ġ��");
	}

	
	
}
