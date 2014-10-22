package interfaces;

public class KTX101 implements KTX {

	private int speed;
	
	private String[] stoppingStations = {
			"서울", "대전", "동대구", "부산"
	};
	
	public KTX101() {
		
	}
	
	@Override
	public void ride() {
		System.out.println("탑승");
	}

	@Override
	public void speedUp() {
		if (speed <= maxSpeed - 10)
			speed += 10;
		
		System.out.println("속도를 증가시킵니다.");
	}

	@Override
	public void speedDown() {
		if (speed >= 10)
			speed -= 10;
		else
			speed = 0;
		
		System.out.println("속도를 감소시킵니다.");
	}

	@Override
	public void getSpeed() {
		System.out.println("현재 속도는 " + speed + " km/h 입니다.");
	}

	@Override
	public void getNumberOfCars() {
		 System.out.println("이 열차는 16량 편성입니다.");
	}

	@Override
	public String[] getStoppingStations() {
		return stoppingStations;
	}

	@Override
	public String getService() {
		return "서비스를 제공합니다.";
	}

}
