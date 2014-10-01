package car;

public class CarTest {

	public static void main(String[] args) {
		
		// 3 x 2 이차원배열
		Car[][] cars = new Car[3][2];
		
		cars[0][0] = new Car();
		cars[0][1] = new Car("빨간색", "2000cc");
		
		cars[1][0] = new Car("검은색", "1000cc");
		cars[1][1] = new Car("은회색", "3800cc");
		
		cars[2][0] = new Car("진회색", "1600cc");
		
		System.out.println("[i][j] 색  상, 등  급");
		System.out.println("=====================");
		// i행
		for (int i = 0; i < cars.length; i++) {
			// j열
			for (int j = 0; j < cars[i].length; j++) {
				System.out.print("[" + i + "]");
				System.out.print("[" + j + "] ");
				if (cars[i][j] != null)
					cars[i][j].print();
				else
					System.out.println("NULL");
			}
			System.out.println("---------------------");
		}
		
	}
	
}
