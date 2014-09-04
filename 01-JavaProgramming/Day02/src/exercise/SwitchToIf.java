package exercise;

public class SwitchToIf {

	public static void main(String[] args) {
//		int num = 3;
//		switch (num) {
//		case 1:
//			System.out.print("Good Morning, Java");
//			break;
//		case 2:
//			System.out.println("Good Afternoon, Java");
//			break;
//		case 3:
//			System.out.println("Good Evening, Java");
//			break;
//		default:
//			System.out.println("Hello, Java");
//		}
//		System.out.println("Done.");
		
		int num = 3;
		if (num == 1) {
			System.out.print("Good Morning, Java");
		}
		else if (num == 2) {
			System.out.println("Good Afternoon, Java");
		}
		else if (num == 3) {
			System.out.println("Good Evening, Java");
		}
		else {
			System.out.println("Hello, Java");
		}
		System.out.println("Done.");
	}

}
