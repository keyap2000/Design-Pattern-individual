import java.io.BufferedReader;
import java.io.FileReader;

public class Login {

    private String UserBox = null;
    private UserInfoItem.USER_TYPE UserType = UserInfoItem.USER_TYPE.Buyer;     //by default - buyer

    Login(){

    }

    public String GetUserName(String loginCredentials) {
        int separator = loginCredentials.lastIndexOf(':');
        return loginCredentials.substring(0, separator);
    }

    void LoginButtonClicked(){
        BufferedReader file;
        System.out.println("login button clicked");

        try{
            if (true)//// Buyer - BuyerRadio.isSelected()
            {
                UserType = UserInfoItem.USER_TYPE.Buyer; /// 0 for student
                file = new BufferedReader(new FileReader("StuInfo.txt"));
            } else// instructor
            {
                UserType = UserInfoItem.USER_TYPE.Seller; // 1 for instructor
                file = new BufferedReader(new FileReader("InsInfor.txt"));
            }
            String loginCredentials, UserName, Password;
        }catch(Exception exception){

        }
    }

    // after login get the UserName of the login interface
    String GetUserName() {
        return UserBox;
    }

    UserInfoItem.USER_TYPE GetUserType() {
        return UserType;
    }
}
