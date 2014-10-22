package interfaces;

public class KTX101 implements KTX {

	private int speed;
	
	private String[] stoppingStations = {
			"����", "����", "���뱸", "�λ�"
	};
	
	public KTX101() {
		
	}
	
	@Override
	public void ride() {
		System.out.println("ž��");
	}

	@Override
	public void speedUp() {
		if (speed <= maxSpeed - 10)
			speed += 10;
		
		System.out.println("�ӵ��� ������ŵ�ϴ�.");
	}

	@Override
	public void speedDown() {
		if (speed >= 10)
			speed -= 10;
		else
			speed = 0;
		
		System.out.println("�ӵ��� ���ҽ�ŵ�ϴ�.");
	}

	@Override
	public void getSpeed() {
		System.out.println("���� �ӵ��� " + speed + " km/h �Դϴ�.");
	}

	@Override
	public void getNumberOfCars() {
		 System.out.println("�� ������ 16�� ���Դϴ�.");
	}

	@Override
	public String[] getStoppingStations() {
		return stoppingStations;
	}

	@Override
	public String getService() {
		return "���񽺸� �����մϴ�.";
	}

}
