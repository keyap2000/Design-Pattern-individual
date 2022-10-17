import java.io.BufferedReader;
import java.io.FileReader;

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

	public void addTrading(Product product) {
		TradingMenu theTradingMenu = new TradingMenu();

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
		theProductList = new ClassProductList();
		theProductList.InitializeFromFile();
	}

	public void AttachProductToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserProduct.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) // not the EOF
			{
				strUserName = GetUserName(aline);
				strCourseName = GetCourseName(aline);
				if (strUserName.compareTo(thePerson.UserName) == 0) /// the UserName mateches
				{
					theSelecteCourse = FindCourseByCourseName(strCourseName);
					if (theSelecteCourse != null) /// Find the Course in the CourseList--->attach
					{
						thePerson.AddCourse(theSelecteCourse);
					}
				}
			}
		} catch (Exception ignored) {
		}
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
