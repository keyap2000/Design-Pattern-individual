public class UserInfoItem {

    //predefined 2 user categories
    public enum USER_TYPE { Buyer, Seller }

    String strUserName;
    USER_TYPE UserType; // 0 : Buyer, 1: Seller

    UserInfoItem(){}
}