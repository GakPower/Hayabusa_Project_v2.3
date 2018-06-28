package Core.SQL;
//
// Author: GakPower
// 
// Date: 13-Jun-2018 (6:15 PM)
//

public class User {

    private final String Username;
    private final String Password;

    public User(String username, String password){
        Username = username;
        Password = password;
    }


    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
}
