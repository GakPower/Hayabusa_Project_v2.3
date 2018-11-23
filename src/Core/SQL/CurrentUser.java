package Core.SQL;
//
// Author: GakPower
// 
// Date: 13-Jun-2018 (6:15 PM)
//

public class CurrentUser {

    private static String username = "";

    public static String getUsername() {
        return username;
    }
    public static void setUsername(String usernames){
        username = usernames;
    }
}
