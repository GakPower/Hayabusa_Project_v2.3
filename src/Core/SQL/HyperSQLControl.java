package Core.SQL;
//
// Author: GakPower
// 
// Date: 13-Jun-2018 (11:11 PM)
//

import java.sql.SQLException;

public class HyperSQLControl {

    private HyperSQL sql;

    public HyperSQLControl(HyperSQL sql){
        this.sql = sql;
    }

    public void setRememberMe(boolean Boolean, String Username){
        int IntBoolean = changeBooleanToInt(Boolean);

        sql.connDB();
        sql.execUpdateCommand("UPDATE RememberMe SET RememberMe="+IntBoolean+", Username=\'"+Username+"\' WHERE ID=1");
        sql.shutDB();
    }
    private int changeBooleanToInt(boolean Boolean){
        return Boolean ? 1 : 0;
    }

    public boolean hasMoreThen1User(){
        boolean result;
        result = isPositive(getMaxIDFromDBTable("Users"));

        return result;
    }
    public int getMaxIDFromDBTable(String table){
        int result = 0;
        try {
            result = tryGetMaxIDFromDBTable(table);
        }catch (SQLException e){
            e.getStackTrace();
        }
        return result;
    }
    private int tryGetMaxIDFromDBTable(String table) throws SQLException {

        sql.connDB();
        sql.execCommand("SELECT MAX(ID) FROM "+table+";");

        int maxID = 0;
        if (sql.getResultSet().next()) {
            maxID = sql.getResultSet().getInt(1);
        }

        sql.shutDB();

        return maxID;
    }
    private boolean isPositive(int number){
        return number > 0;
    }

    public void createTable(String table, String parameters){
        sql.connDB();
        sql.execUpdateCommand("CREATE TABLE "+table+"("+parameters+");");
        sql.shutDB();
    }

    public void addInfoToTable(String table, String info){
        sql.connDB();
        sql.execUpdateCommand("INSERT INTO "+table+" VALUES("+info+");");
        sql.shutDB();
    }

    public boolean getRememberMeBoolean(){
        boolean result = false;
        try{
            result = tryGetRememberMeBoolean();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    private boolean tryGetRememberMeBoolean() throws SQLException {
        boolean Boolean = false;

        sql.connDB();
        sql.execCommand("SELECT RememberMe FROM RememberMe");

        if (sql.getResultSet().next()){
            Boolean = sql.getResultSet().getBoolean(1);
        }

        sql.shutDB();

        return Boolean;
    }
    public String getRememberMeUsername(){
        String result = "";
        try{
            result = tryGetRememberMeUsername();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    private String tryGetRememberMeUsername() throws SQLException {
        String Username = "";

        sql.connDB();
        sql.execCommand("SELECT Username FROM RememberMe");

        if (sql.getResultSet().next()){
            Username = sql.getResultSet().getString(1);
        }

        sql.shutDB();

        return Username;
    }

    public void storeSignInInfoToTable(String[] info, String table){

        sql.connDB();
        sql.execUpdateCommand("INSERT INTO "+table+" VALUES("+info[0]+
                ", "+info[1]+", "+info[2]+", "+info[3]+", "+info[4]+");");

        sql.shutDB();

    }
    public int getNextIDFromTable(String Table){
        return getMaxIDFromDBTable(Table) + 1;
    }

    public String getIDToStringForQuestionOfUsername(String Username) {

        sql.connDB();
        sql.execCommand("SELECT ID FROM SecurityCombo WHERE Username=\'"+Username+"\';");

        int result = 0;
        try {
            if (sql.getResultSet().next()) {
                result = sql.getResultSet().getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql.shutDB();
        return String.valueOf(result);
    }

}
