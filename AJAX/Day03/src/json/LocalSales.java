package json;

public class LocalSales {
	// {
	// "location": "Vali",
	// "boardsSold": 1,
	// "bootsSold": 61,
	// "bindingsSold": 17
	// }
	
	private String location;
	private int boardsSold;
	private int bootssold;
	private int bindingsSold;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getBoardsSold() {
		return boardsSold;
	}

	public void setBoardsSold(int boardsSold) {
		this.boardsSold = boardsSold;
	}

	public int getBootssold() {
		return bootssold;
	}

	public void setBootssold(int bootssold) {
		this.bootssold = bootssold;
	}

	public int getBindingsSold() {
		return bindingsSold;
	}

	public void setBindingsSold(int bindingsSold) {
		this.bindingsSold = bindingsSold;
	}

}
