package exercise;

public class ForLoop {
	
	public static void main(String[] args) {
		
		int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		
		/*
		 * �� �迭�� 3 ��° �׸���� 7 ��° �׸������ ����
		 * ��� ���ؼ� ����ϴ� ���α׷���
		 * for ���� �̿��ؼ� �ۼ��غ�����.
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
		 * �� �迭���� 7�� ����� ó������ ���ö�����
		 * ������ ������� ����ϼ���. (ó�� ������ 7�� ������� ���)
		 */
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			if (arr[i] % 7 == 0)
				break;
		}
		
		
	}
	
}
