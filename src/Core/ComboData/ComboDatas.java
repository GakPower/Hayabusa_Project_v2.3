package Core.ComboData;

import Core.Components.ComboBox;
import Core.SQL.CurrentUser;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ComboDatas
{
    private static HyperSQL sql = new HyperSQL();
    private static HyperSQLControl sqlControl = new HyperSQLControl(sql);

    private static ArrayList<ComboData> comboInfo = new ArrayList<>();

    public static void load(ArrayList<ComboBox> comboBoxes){
        sql.connDB();
        sql.execCommand("SELECT * FROM ComboData WHERE Username=\'"+ CurrentUser.getUsername() +"\' ORDER BY ID;");
        try {
            comboInfo.clear();
            while(sql.getResultSet().next()){
                Array array = sql.getResultSet().getArray(4);

                String groupName = sql.getResultSet().getString(3);
                ArrayList<String> arrayList = convertSQLArrayToStringArrayList(array);
                ComboData comboData = new ComboData(groupName, arrayList);

                for (ComboBox comboBox : comboBoxes)
                {
                    if (comboBox.getPromptText().equals(groupName))
                    {
                        comboBox.setItems(comboData.getValues());
                        comboInfo.add(comboData);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.shutDB();
    }

    public static void create(ComboData comboData){
        sqlControl.addInfoToTable("ComboData",
                sqlControl.getNextIDFromDBTableForUsername("ComboData",
                        CurrentUser.getUsername())+", \'"+CurrentUser.getUsername()+"\', \'"+comboData.getGroupName()+"\', Array"+ Arrays.toString(comboData.getValues().toArray()));
        comboInfo.add(comboData);
    }
    public static void save(String groupName, String value){
        sql.connDB();
        sql.execCommand("SELECT Data FROM ComboData WHERE Username=\'"+CurrentUser.getUsername()+"\' AND GroupName=\'"+groupName+"\';");
        ArrayList<String> data;
        try {
            boolean edited = false;
            if (sql.getResultSet().next()){
                data = convertSQLArrayToStringArrayList(sql.getResultSet().getArray(1));
                if (!data.contains(value)){
                    data.add("\'"+value+"\'");
                    edited = true;
                }
                sql.execUpdateCommand("UPDATE ComboData SET Data=Array"+ Arrays.toString(data.toArray()) +" WHERE Username=\'"+CurrentUser.getUsername()+"\' AND GroupName=\'"+groupName+"\';");
                for (ComboData comboData: comboInfo) {
                    if (comboData.getGroupName().equals(groupName) && edited){
                        comboData.getValues().add(value);
                    }
                }
            }else{
                create(new ComboData(groupName, value));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.shutDB();
    }
    public static void save(ArrayList<ComboBox> comboBoxes, ArrayList<String> values){
        for (int i = 0; i < comboBoxes.size(); i++) {
            String groupName = comboBoxes.get(i).getPromptText();
            String value = values.get(i);
            save(groupName, value);
        }
    }
    public static void delete(String groupName, String value){
        sql.connDB();
        sql.execCommand("SELECT Data FROM ComboData WHERE Username=\'"+CurrentUser.getUsername()+"\' AND GroupName=\'"+groupName+"\';");
        ArrayList<String> data = new ArrayList<>();
        try {
            if (sql.getResultSet().next()){
                data = convertSQLArrayToStringArrayList(sql.getResultSet().getArray(1));
                data.remove(value);
                for (ComboData comboData: comboInfo){
                    comboData.getValues().remove(value);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql.execUpdateCommand("UPDATE ComboData SET Data=Array"+ Arrays.toString(data.toArray()) +" WHERE Username=\'"+CurrentUser.getUsername()+"\' AND GroupName=\'"+groupName+"\';");

        sql.shutDB();
    }

    public static ArrayList<ComboData> getConboData(){
        return comboInfo;
    }

    private static ArrayList<String> convertSQLArrayToStringArrayList(Array array) throws SQLException {
        Object[] arraystr = (Object[]) array.getArray();
        ArrayList<String> tempData = new ArrayList<>();
        for (Object o : arraystr) {
            tempData.add(String.valueOf(o));
        }

        return tempData;
    }
}
