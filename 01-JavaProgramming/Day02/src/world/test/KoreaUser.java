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
		System.out.println("�α�: " + p);
//		k.capital = "����";
		k.setCapital("����");
		System.out.println(k.getSpecial());
		String[] list = k.getSpecial();
		System.out.println(list[0]);
		
	}
	
}
