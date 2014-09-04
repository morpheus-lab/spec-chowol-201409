package exercise;

public class ArrayExample {
	
	public static void main(String[] args) {
		
//		int table[][] = 
//			{
//				{1, 2, 3, 4},
//				{5, 6, 7, 8},
//				{9, 10, 11, 12}
//			};
//		
//		System.out.println(table.length);
//		System.out.println(table[0].length);
		
		int table[][] = {
				{1, 2, 3, 4},
				{5, 6, 7, 8, 9, 10, 11},
				{12, 13, 14, 15, 16, 17, 18, 19}
		};
		
		int table1[][] = new int[3][];
		table1[0] = new int[4];
		table1[1] = new int[7];
		table1[2] = new int[8];
		
		int val = 1;
		for (int i = 0; i < table1.length; i++) {
			for (int j = 0; j < table1[i].length; j++) {
				table1[i][j] = val++;
			}
		}
		
	}
	
}
