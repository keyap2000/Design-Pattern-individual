import java.util.ArrayList;

public class Product {

	ArrayList<Trading> tradingList= new ArrayList<>();

	private Trading trading;
	static String productName;

	public Product(String strProductName) {
		this.productName = strProductName;
	}

	public Product(String productType, String productName){}

	void AddTrading(Trading newTrading)
	{
		tradingList.add(newTrading);
	}

	public String toString()
	{
		return productName;
	}

	//visitor design pattern
	void accept(NodeVisitor visitor)
	{
		visitor.visitProduct(this);
	}
}