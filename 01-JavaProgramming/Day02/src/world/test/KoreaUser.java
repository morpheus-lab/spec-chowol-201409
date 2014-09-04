package world.test;

import world.asia.Korea;

public class KoreaUser {

	public static void main(String[] args) {
		
		Korea k;
		k = new Korea();
//		k.population = 10;
		k.setPopulation(0);
		k.setPopulation(10);
		
		int p = k.getPopulation();
		System.out.println("인구: " + p);
//		k.capital = "서울";
		k.setCapital("서울");
		System.out.println(k.getSpecial());
		String[] list = k.getSpecial();
		System.out.println(list[0]);
		
	}
	
}
