package Core;

import Core.DayConvertion.DateConvertion;
import Core.SQL.CurrentUser;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import javafx.scene.control.TableView;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class TableDatas {
    private static HyperSQL sql = new HyperSQL();
    private static HyperSQLControl sqlControl = new HyperSQLControl(sql);

    private static ArrayList<TableData> tableInfo = new ArrayList<>();

    private static ArrayList<String> usernames;
    private static ArrayList<ArrayList<String>> data;

    public static void load(TableView<TableData> tableView){
        sql.connDB();
        sql.execCommand("SELECT * FROM TableData WHERE Username=\'"+ CurrentUser.getUsername()+"\' ORDER BY ID;");

        ResultSet resultSet = sql.getResultSet();
        try {
            if(!resultSet.next()){
                System.out.println("No Data Found");
            }else{
                tableView.getItems().clear();
                do{
                    Array array = resultSet.getArray(3);
                    TableData tableData = new TableData(convertSQLArrayToStringArrayList(array));
                    tableData.setId(resultSet.getInt(1)+"");
                    tableView.getItems().add(tableData);

                    add(tableData);
                }
                while(resultSet.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.shutDB();
        }
    }
    public static void add(TableData tableData)
    {
        tableInfo.add(tableData);
    }
    public static void set(int index, TableData tableData){
        tableInfo.add(index, tableData);
    }
    public static void save(TableData tableData){
        System.out.println(Arrays.toString(tableData.getArrayOfData()));
        String[] array = new String[tableData.getArrayOfData().length];
        for (int i = 0; i < tableData.getArrayOfData().length; i++) {
            if (i==0 || i==7){
                array[i] = "\'"+ DateConvertion.convertToEnglish(tableData.getArrayOfData()[i]) +"\'";
            }else{
                array[i] = "\'"+ tableData.getArrayOfData()[i] +"\'";
            }
        }
        System.out.println(Arrays.toString(array));
        sqlControl.addInfoToTable("TableData", (sqlControl.getNextIDFromDBTableForUsername("TableData", CurrentUser.getUsername()))+", "+ "\'"+CurrentUser.getUsername()+"\'" + ", ARRAY"+ Arrays.toString(array));
    }
    public static void save(String usernames, String[] data){
        String[] array = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            array[i] = "\'"+ data[i] +"\'";
        }
        sqlControl.addInfoToTable("TableData", (sqlControl.getNextIDFromDBTableForUsername("TableData", CurrentUser.getUsername()))+", "+ "\'"+usernames+"\'" + ", ARRAY"+ Arrays.toString(array));
    }

    public static void setToDB(TableData tableData){
        String[] newData = tableData.getArrayOfData();
        for (int i = 0; i < tableData.getArrayOfData().length; i++) {
            if(i==0 || i==7){
                newData[i] = DateConvertion.convertToEnglish(newData[i]);
            }
            newData[i] = "\'"+newData[i]+"\'";
        }
        sql.connDB();
        sql.execUpdateCommand("UPDATE TableData SET Data=Array"+ Arrays.toString(newData) +" WHERE Username=\'"+CurrentUser.getUsername()+"\' AND ID="+tableData.getId()+";");
        sql.shutDB();
    }

    public static ArrayList<TableData> getTableInfo(){
        return tableInfo;
    }


    private static void getAllData(){

        ArrayList<String> Usernames = new ArrayList<>();
        ArrayList<ArrayList<String>> Data = new ArrayList<>();

        sql.connDB();
        sql.execCommand("SELECT * FROM TableData");
        try {
            while(sql.getResultSet().next())
            {
                Usernames.add(sql.getResultSet().getString(2));

                Array array = sql.getResultSet().getArray(3);
                Data.add(convertSQLArrayToStringArrayList(array));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.shutDB();

        usernames = Usernames;
        data = Data;
    }

    private static ArrayList<String> convertSQLArrayToStringArrayList(Array array) throws SQLException {
        Object[] arraystr = (Object[]) array.getArray();
        ArrayList<String> tempData = new ArrayList<>();
        for (Object o : arraystr) {
            tempData.add(String.valueOf(o));
        }
        tempData.set(0, DateConvertion.convertToGreek(tempData.get(0)));
        tempData.set(7, DateConvertion.convertToGreek(tempData.get(7)));

        return tempData;
    }

    public static ArrayList<String> getUsernames(){
        getAllData();
        return usernames;
    }

    public static ArrayList<ArrayList<String>> getData(){
        getAllData();
        return data;
    }

    public static void delete(String username, int id) {
        sql.connDB();
        sql.execUpdateCommand("DELETE FROM TableData WHERE Username=\'"+username+"\' AND ID="+id+";");
        sql.shutDB();
    }
}
