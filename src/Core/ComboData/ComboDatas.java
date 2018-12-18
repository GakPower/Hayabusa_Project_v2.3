package Core.ComboData;

import Core.Components.ComboBox;
import Core.SQL.CurrentUser;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ComboDatas
{
    private static HyperSQL sql = new HyperSQL();
    private static HyperSQLControl sqlControl = new HyperSQLControl(sql);

    private static ArrayList<ComboData> comboInfo = new ArrayList<>();

    public static void load(HashMap<String, ComboBox> comboBoxes){

        sql.connDB();
        sql.execCommand("SELECT * FROM ComboData WHERE Username=\'"+CurrentUser.getUsername()+"\' ORDER BY ID;");

        try {
            comboInfo.clear();
            while(sql.getResultSet().next()){
                ComboBox comboBox = comboBoxes.get(sql.getResultSet().getString(3));
                comboBox.add(sql.getResultSet().getString(4));

                comboInfo.add(new ComboData(comboBox.getPromptText(), comboBox.getItems().get(comboBox.getItems().size()-1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.shutDB();
    }

    public static void save(ComboData comboData) {

        sql.connDB();
        sql.execCommand("SELECT Data FROM ComboData WHERE Username=\'" + CurrentUser.getUsername() + "\' AND GroupName=\'" + comboData.getGroupName() + "\' AND Data=\'" + comboData.getValue() + "\';");
        try {
            if (!sql.getResultSet().next()) {
                sqlControl.addInfoToTable("ComboData",
                        sqlControl.getNextIDFromDBTableForUsername("ComboData",
                                CurrentUser.getUsername()) + ", \'" + CurrentUser.getUsername() + "\', \'" + comboData.getGroupName() + "\', \'" + comboData.getValue() + "\'");
                comboInfo.add(comboData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql.shutDB();

    }
    public static void save(HashMap<String, ComboBox> comboBoxes, ArrayList<ComboData> values){
        for (int i = 0; i < comboBoxes.size(); i++) {
            String groupName = values.get(i).getGroupName();
            String value = values.get(i).getValue();

            if (!value.isEmpty()){
                comboBoxes.get(groupName).add(value);
                save(values.get(i));
            }
        }
    }
    public static void delete(String groupName, String value){
        sql.connDB();
        sql.execUpdateCommand("DELETE FROM ComboData WHERE Username=\'"+CurrentUser.getUsername()+"\' AND GroupName=\'"+groupName+"\' AND Data=\'"+value+"\';");
        sql.shutDB();

        for (ComboData comboData: comboInfo){
            if (comboData.getGroupName().equals(groupName) && comboData.getValue().equals(value)){
                comboInfo.remove(comboData);
                break;
            }
        }
    }
}
