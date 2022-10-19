public class Main {
    static Facade theFacade = new Facade();

    public Main() {
    }

    public static void main(String[] args) {
//		String strUsername;
//		String strUserType = null;
        UserInfoItem userinfoitem = new UserInfoItem();
        theFacade.createProductList();
        while (true) {
            boolean bExit;
            System.out.println("login method called");
            bExit = Facade.login(userinfoitem);
            if (bExit)
                break;
            // userinfoitem.strUserName = "pepe";
            // userinfoitem.UserType = 1;
            theFacade.createUser(userinfoitem);
            theFacade.AttachProductToUser();
            if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer)
                // if user is a buyer then remind him/her of the due date
                theFacade.remind();
            boolean blogout = false;
            while (!blogout) {
                blogout = theFacade.SelectProduct();
                if (blogout)
                    break;
                blogout = theFacade.productOperation();
            }
        }
//    System.out.println(userinfoitem.strUserName +userinfoitem.UserType );
    }
}
