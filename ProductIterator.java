import java.util.Iterator;

public class ProductIterator implements Iterator{

	private ClassProductList classProductList = null;
	private int CurrentProductNumber=-1;

	ProductIterator(ClassProductList classproductlist){
		classProductList = classproductlist;
	}

	//to check if it has any other object after current object
	public boolean hasNext() {
		return CurrentProductNumber < classProductList.size() - 1;
	}

	//to iterate over the next product objects
	public Object next() {
		if(hasNext()){
			CurrentProductNumber ++;
			return classProductList.get(CurrentProductNumber);
		}
		else{
			return null;
		}
	}

	public void MoveToHead() {

	}

	public void remove() {
		classProductList.remove(CurrentProductNumber);
	}

    public Object next(String strProductName) {
		Product product = (Product) next();
		while(product != null)
		{
			if(strProductName.compareTo(product.toString())==0)
			{
				return product;
			}
			product = (Product) next();
		}
		return null;
	}
}