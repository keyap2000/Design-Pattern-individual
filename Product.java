import java.util.ArrayList;

public class Product {

	ClassProductList classProductList;
	ArrayList<Trading> tradingList= new ArrayList<>();

	private Trading trading;
	String productName;

	public Product(String strProductName) {
		this.productName = strProductName;
	}

	void AddTrading(Trading newTrading)
	{
		tradingList.add(newTrading);
	}

	public String toString()
	{
		return productName;
	}

	void accept(NodeVisitor visitor)
	{
		visitor.visitProduct(this);
	}
}