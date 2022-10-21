import java.io.BufferedReader;
import java.io.FileReader;

public class Facade {

	private int UserType;

	private Product theSelectedProduct = null;

	private int nProductCategory = 0;

	ClassProductList classProductList;

	private Person thePerson;

	Facade(){

	}

	public static boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);

		//get the username entered by user in GUI and store it in userinfoitem local variable
		userinfoItem.strUserName = login.GetUserName();

		//get the usertype by relating it with username of userinfoitem
		userinfoItem.UserType = login.GetUserType();
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

		//bridge design pattern
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
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer) // Buyer

			//bridge design pattern
		{
			thePerson = new Buyer();
		} else // Seller
		{
			thePerson = new Seller();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}

	public void createProductList() {
		classProductList = new ClassProductList();
		classProductList.InitializeFromFile();
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

				//if the current user and the username(data read from file) matches
				if (strUserName.compareTo(thePerson.UserName) == 0) // for matching the UserName
				{
					//it will return the list of products connected to the current user; it will give option to the user
					//to select the product
					theSelectedProduct = FindProductByProductName(productName);

					if (theSelectedProduct != null) /// Find the product in the ProductList
					{
						thePerson.AddProduct(theSelectedProduct);
					}
				}
			}
		} catch (Exception exception) {
		}
	}

	private Product FindProductByProductName(String strProductName) {

		//iterator design pattern
		ProductIterator Iterator = new ProductIterator(classProductList);
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

	//select product from the given options
	public Boolean SelectProduct() {
		ProductSelectDialog theDlg = new ProductSelectDialog();
		theSelectedProduct = theDlg.ShowDlg(thePerson.classProductList);
		thePerson.currentProduct = theSelectedProduct;
		nProductCategory = theDlg.nProductCategory;
		return theDlg.isLogout();
	}

	public boolean productOperation() {
		thePerson.CreateProductMenu(theSelectedProduct, nProductCategory);
		System.out.println("in product operation");
		return thePerson.ShowMenu();
		// 0: logout
		// 1: select other product
	}
}