package exercise;

public class ForLoop {
	
	public static void main(String[] args) {
		
		int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		
		/*
		 * 이 배열의 3 번째 항목부터 7 번째 항목까지의 값을
		 * 모두 더해서 출력하는 프로그램을
		 * for 문을 이용해서 작성해보세요.
		 */
		/*
		int sum = 0;
		for (int i = 2; i < 7; i++) {
			sum += arr[i];
//			sum = sum + arr[i];
		}
		System.out.println(sum);
		*/
		
		/*
		 * 이 배열에서 7의 배수가 처음으로 나올때까지
		 * 값들을 순서대로 출력하세요. (처음 나오는 7의 배수까지 출력)
		 */
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			if (arr[i] % 7 == 0)
				break;
		}
		
		
	}
	
}
