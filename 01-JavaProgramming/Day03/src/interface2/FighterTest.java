package interface2;

public class FighterTest {

	public void testUnit(Unit unit) {
		if (unit != null) {
			unit.heal();
		}
	}
	
	public void moveUnit(Movable m) {
		if (m != null)
			m.move();
	}
	
	
	public static void main(String[] args) {
		
		FighterTest test = new FighterTest();
		
		Fighter f = new Fighter();
		
		if (f instanceof Unit) {
			System.out.println("UnitÀÇ ÀÚ¼Õ");
			test.testUnit(f);
		}
		if (f instanceof Fightable) {
			Fightable fightable = (Fightable) f;
			fightable.fight();
		}
		if (f instanceof Movable) {
//			Movable m = (Movable) f;
//			m.move();
			test.moveUnit(f);
		}
		if (f instanceof Attackable) {
			((Attackable) f).attack();
		}
		
		
	}
	
	
}
