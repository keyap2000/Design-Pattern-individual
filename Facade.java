import java.io.BufferedReader;
import java.io.FileReader;

public class Facade {

	private int UserType;

	private Product theSelectedProduct = null;

	private int nProductCategory = 0;

	ClassProductList theProductList;

	private Person thePerson;

	Facade(){

	}

	public static boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.GetUserName();
		userinfoItem.UserType = login.GetUserType();
		System.out.println("userinfoitem : "+ userinfoItem);
		return login.isExit();
	}

	public void addTrading(Product product) {
		TradingMenu theTradingMenu;

		//bridge design pattern
		if(thePerson.type == 0){		//buyer
			theTradingMenu = new BuyerTradingMenu();
		}
		else{							//seller
			theTradingMenu = new SellerTradingMenu();
		}
		Trading trading = new Trading();
		theTradingMenu.ShowMenu(trading, thePerson);
		product.AddTrading(trading);
	}

	public void viewTrading(Trading trading) {
		TradingMenu theTradingMenu;

		if(thePerson.type == 0){		//buyer
			theTradingMenu = new BuyerTradingMenu();
		}
		else{							//seller
			theTradingMenu = new SellerTradingMenu();
		}
		theTradingMenu.ShowMenu(trading, thePerson);
	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.GetProductList());
	}

	public void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer) /// buyer

			//bridge design pattern
		{
			thePerson = new Buyer();
		} else /// seller
		{
			thePerson = new Seller();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}

	public void createProductList() {
		theProductList = new ClassProductList();
		theProductList.InitializeFromFile();
	}

	public void AttachProductToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserProduct.txt"));
			String aline, strUserName, productName;
			while ((aline = file.readLine()) != null) // until the EOF is reached
			{
				strUserName = GetUserName(aline);
				productName = GetProductName(aline);
				System.out.println("username : " + strUserName);
				System.out.println("product name : " + productName);
				if (strUserName.compareTo(thePerson.UserName) == 0) // for matching the UserName
				{
					theSelectedProduct = FindProductByProductName(productName);
					System.out.println("selected product is - " + theSelectedProduct);
					if (theSelectedProduct != null) /// Find the product in the ProductList
					{
						System.out.println("current product is added in the person ");
						thePerson.AddProduct(theSelectedProduct);
					}
				}
//				Product product[] = {new Product("Meat", "Beef")};
//				theSelectedProduct = product[0];
				System.out.println("inside else");
			}
		} catch (Exception exception) {
		}
	}

	private Product FindProductByProductName(String strProductName) {

		//iterator design pattern
		ProductIterator Iterator = new ProductIterator(theProductList);
		return (Product) Iterator.next(strProductName);
	}

	private String GetProductName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1);
	}

	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	//actual return type - Product
	public Boolean SelectProduct() {
		ProductSelectDialog theDlg = new ProductSelectDialog();
		theSelectedProduct = theDlg.ShowDlg(thePerson.classProductList);
		thePerson.currentProduct = theSelectedProduct;
		nProductCategory = theDlg.nProductCategory;
		return theDlg.isLogout();
	}

	//actual return type - void
	public boolean productOperation() {
		thePerson.CreateProductMenu(theSelectedProduct, nProductCategory);
		return thePerson.ShowMenu();
		//// 0: logout
		// 1: select other product
	}
}