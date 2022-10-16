public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	/* if(UserType == 0){
		Buyer
	}
	else{
		seller
	}
	if(nProductCategory == 0){
		meat
	}
	else{
		produce
	}
	*/

	Facade(){}

	public boolean login() {
		Login login = new Login();
		UserInfoItem userinfoitem = new UserInfoItem();
		userinfoitem.strUserName = login.GetUserName();
		userinfoitem.UserType = login.GetUserType();
		return false;
	}

	public void addTrading() {
		TradingMenu theTradingMenu;

		if(thePerson.type == 0){		//buyer
			//theTradingMenu = new BuyerTradingMenu();
		}
		else{							//seller
			//theTradingMenu = new SellerTradingMenu();
		}
	}

	public void viewTrading() {
		TradingMenu theTradingMenu;

		if(thePerson.type == 0){		//buyer
			//theTradingMenu = new BuyerTradingMenu();
		}
		else{							//seller
			//theTradingMenu = new SellerTradingMenu();
		}

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {
		Reminder theReminder = new Reminder();
	}

	public void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer) /// student
		{
			thePerson = new Buyer();
		} else /// instructor
		{
			thePerson = new Seller();
		}
		thePerson.uname = userinfoitem.strUserName;
	}

	public void createProductList() {

	}

	public void AttachProductToUser() {

	}

	public Product SelectProduct() {
		return null;
	}

	public void productOperation() {

	}

	public static void main(String[] args) {
		System.out.println("Facade class implemented");
	}

}
