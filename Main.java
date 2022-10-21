public class Main {
    //facade design pattern used
    static Facade theFacade = new Facade();

    public Main() {
    }

    public static void main(String[] args) {
        UserInfoItem userinfoitem = new UserInfoItem();

        //create product list - by reading the contents from "ProductInfo.txt"
        theFacade.createProductList();

        while (true) {
            boolean bExit;
            System.out.println("login method called");
            bExit = Facade.login(userinfoitem);
            if (bExit)
                break;

            //create user on the basis of their role(buyer/seller) as per their selection in the form of radio button
            theFacade.createUser(userinfoitem);

            //it will attach products to the user on the basis of UserProduct.txt file
            theFacade.AttachProductToUser();

            if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer)

                // if user is a buyer then remind him/her of the due date
                theFacade.remind();

            boolean blogout = false;

            //initially, user need to select the product
            while (!blogout) {

                blogout = theFacade.SelectProduct();
                if (blogout)
                    break;

                //then they can view Menu bar and can perform any function
                blogout = theFacade.productOperation();
            }
        }
    }
}