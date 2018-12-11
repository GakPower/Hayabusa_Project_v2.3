package Core;

import Core.SQL.CurrentUser;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class TableExtraColumns {

    private static HyperSQL sql = new HyperSQL();
    private static HyperSQLControl sqlControl = new HyperSQLControl(sql);

    private static ArrayList<TableColumn<TableData, String>> columns = new ArrayList<>(21);

    public static ArrayList<TableColumn<TableData, String>> loadExtraColumns(ArrayList<TableColumn<TableData, String>> tableColumns){
        columns = tableColumns;

        for (String columnName : sqlControl.loadExtraColumns()) {
            createColumn(columnName, columns.get(0).getTableView());
        }

        return columns;
    }

    public static void add(String columnName, TableView<TableData> tableView){
        saveExtraColumn(createColumn(columnName, tableView));
    }

    private static void saveExtraColumn(TableColumn<TableData, String> column){
        sqlControl.addInfoToTable("ExtraColumns", (sqlControl.getMaxIDFromDBTable("ExtraColumns")+1)+",\'"+ CurrentUser.getUsername() +"\',\'"+column.getText()+"\'");
    }

    public static void removeExtraColumn(TableColumn<TableData, String> column){

        sql.connDB();
        sql.execCommand("DELETE FROM ExtraColumns WHERE Username=\'"+ CurrentUser.getUsername() +"\' AND ExtraColumns=\'"+column.getText()+"\';");
        int columnIndex = columns.indexOf(column);
        columns.remove(column);
        column.getTableView().getColumns().remove(column);

        ArrayList<String> usernames = TableDatas.getUsernames();
        ArrayList<ArrayList<String>> datas = TableDatas.getData();

        sql.execCommand("TRUNCATE TABLE TableData");

        ArrayList<String> tempData = new ArrayList<>();

        for (int i=0; i < datas.size(); i++) {
            tempData.clear();
            datas.get(i).remove(columnIndex-1);

            TableDatas.save(usernames.get(i), tempData.toArray(new String[0]));
        }

        sql.shutDB();

    }

    private static TableColumn<TableData, String> createColumn(String name, TableView<TableData> tableView){
        TableColumn<TableData, String> column = new TableColumn<>(name);
        columns.add(column);
        initCellFactory(column);
        tableView.getColumns().add(column);

        return column;
    }

    private static void initCellFactory(TableColumn<TableData, String> column){
        column.setCellValueFactory(data ->
                data.getValue().getExtraValue(columns.indexOf(column)-21)
        );
    }

    public static ArrayList<TableColumn<TableData, String>> getColumns(){
        return columns;
    }
}
