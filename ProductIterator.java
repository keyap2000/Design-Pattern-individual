import java.util.Iterator;

public class ProductIterator implements Iterator{

	private ClassProductList classProductList = null;
	private int CurrentProductNumber=-1;

	ProductIterator(ClassProductList classproductlist){
		System.out.println("in product iterator" + classproductlist);
		classProductList = classproductlist;
	}

	public boolean hasNext() {
		System.out.println("class product list : " + classProductList);
		return CurrentProductNumber < classProductList.size() - 1;
	}

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