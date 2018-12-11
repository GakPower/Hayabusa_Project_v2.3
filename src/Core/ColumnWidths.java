package Core;

import Core.SQL.CurrentUser;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import javafx.scene.control.TableColumn;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ColumnWidths
{
    private static HyperSQL sql = new HyperSQL();
    private static HyperSQLControl sqlControl = new HyperSQLControl(sql);

    private static ArrayList<Integer> widths = new ArrayList<>();

    /*public static void editWidth(int index, int newValue){
        widths.set(index, newValue);
        save(widths);
    }*/

    public static void load(ArrayList<TableColumn<TableData, String>> columns){
        sql.connDB();
        try {
            sql.execCommand("SELECT ColumnWidth FROM ColumnWidth WHERE Username=\'" + CurrentUser.getUsername() + "\';");

            if (sql.getResultSet().next()){
                widths.clear();
                Array array = sql.getResultSet().getArray(1);
                Object[] arraystr = (Object[]) array.getArray();
                for (int i = 0; i < columns.size(); i++) {
                    widths.add(Integer.valueOf(String.valueOf(arraystr[i])));
                    columns.get(i).prefWidthProperty().setValue(Integer.valueOf(String.valueOf(arraystr[i])));
                    System.out.println(Integer.valueOf(String.valueOf(arraystr[i])));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.shutDB();
    }

    public static void save(ArrayList<Integer> widthsData){
        widths = widthsData;
        sql.connDB();

        sql.execCommand("DELETE FROM ColumnWidth WHERE Username=\'"+CurrentUser.getUsername()+"\';");
        sqlControl.addInfoToTable("ColumnWidth", "\'"+CurrentUser.getUsername()+"\', ARRAY"+ Arrays.toString(widthsData.toArray()));
        System.out.println("**"+Arrays.toString(widthsData.toArray()));

        sql.shutDB();
    }
}
