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
            bExit = Facade.login(userinfoitem);
            if (bExit)
                break;
            // userinfoitem.strUserName = "Inst1";
            // userinfoitem.UserType = 1;
            theFacade.createUser(userinfoitem);
            theFacade.AttachProductToUser();
            if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer)
                // if user is a buyer then remind him of the due date
                theFacade.remind();
            boolean bLogout = false;
            while (!bLogout) {
                bLogout = theFacade.SelectProduct();
                if (bLogout)
                    break;
                bLogout = theFacade.productOperation();
            }
        }
//    System.out.println(userinfoitem.strUserName +userinfoitem.UserType );
    }
}
