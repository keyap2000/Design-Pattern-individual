public class ProductIterator implements ListIterator{

	private ClassProductList classProductList;
	private int CurrentProductNumber=-1;


	public boolean hasNext() {
		return CurrentProductNumber < classProductList.size() - 1;
		//return false;
	}

	ProductIterator(ClassProductList classproductlist){

		classProductList = classproductlist;
	}

	public Product Next() {

		if(hasNext()){
			CurrentProductNumber ++;
			return classProductList.get(CurrentProductNumber);
		}
		else{
			return null;
		}
		//Product product = new Product();
		//return product;
	}

	public void MoveToHead() {

	}

	public void Remove() {
		classProductList.remove(CurrentProductNumber);
	}

    public Product next(String strProductName) {
		Product product;
		product = (Product) Next();
		while(product != null)
		{
			if(strProductName.compareTo(product.toString())==0)
			{
				return product;
			}
			product = (Product) Next();
		}
		return null;
	}

}