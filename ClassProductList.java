import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

	public ClassProductList(){}


	//read content from the file : Product Category(Meat, Produce) and Product name
    public void InitializeFromFile() {
		try {
			BufferedReader file;
			String strProductName;
			file = new BufferedReader(new FileReader("ProductInfo.txt"));
			while ((strProductName = file.readLine()) != null) {
				Product product = new Product(strProductName);
				add(product);
			}
			System.out.println("products added successfully !");
		} catch (Exception ignored) {
		}
	}
}