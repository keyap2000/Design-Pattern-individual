public class Main {
    //facade design pattern used
    static Facade theFacade = new Facade();

    public Main() {
    }

    public static void main(String[] args) {
        UserInfoItem userinfoitem = new UserInfoItem();
        theFacade.createProductList();
        while (true) {
            boolean bExit;
            System.out.println("login method called");
            bExit = Facade.login(userinfoitem);
            if (bExit)
                break;
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
    }
}