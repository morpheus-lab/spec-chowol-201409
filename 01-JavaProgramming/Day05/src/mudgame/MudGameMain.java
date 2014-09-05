package mudgame;

public class MudGameMain {
	
	public static void main(String[] args) {
		
		Wizard pika = new Wizard("피카츄");
		
		// 이동
		pika.move("마을회관");
		
		// 체력 및 마나 상태값 조회
//		System.out.println(w1.health);
		pika.displayHealth();
//		System.out.println(w1.mana);
		pika.displayMana();
		
		// 다른 마법사
		Wizard pairi = new Wizard("파이리");
		// 피카츄가 파이리를 공격
		pika.fight(pairi);
		pairi.displayHealth();
		pika.fight(pairi);
		pairi.displayHealth();
		
		// 피카츄가 파이리를 치유
		pika.heal(pairi);
		pairi.displayHealth();
	}
	
}
