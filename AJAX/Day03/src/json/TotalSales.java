package json;

public class TotalSales {

	// { "totals": [
	//			{},
	//			{}
	//		]
	// }

	private LocalSales[] totals;

	public LocalSales[] getTotals() {
		return totals;
	}

	public void setTotals(LocalSales[] totals) {
		this.totals = totals;
	}

}
