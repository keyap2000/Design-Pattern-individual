import java.util.ArrayList;

public class Product {

	ClassProductList classProductList;
	ArrayList<Trading> tradingList= new ArrayList<>();

	private Trading trading;

	public Product(String strProductName) {
	}

	void AddTrading(Trading newTrading)
	{
		tradingList.add(newTrading);
	}
}
