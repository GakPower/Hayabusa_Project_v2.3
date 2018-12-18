package Core.ExtraFields;

import Core.Components.ComponentType;
import Core.SQL.CurrentUser;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.ArrayList;


public class ExtraGroups {

    private static HyperSQL sql = new HyperSQL();
    private static HyperSQLControl sqlControl = new HyperSQLControl(sql);
    public static ArrayList<ExtraGroup> extraGroups = new ArrayList<>();
    public static ArrayList<VBox> vBoxes = new ArrayList<>();

    public static void add(ExtraGroup extraGroup){
        extraGroups.add(extraGroup);
        save(extraGroup.getGroupName(), extraGroup.getComponentType().toString());
        /*if (extraGroup.getComponentType()==ComponentType.COMBOBOX){
            ComboData comboData = new ComboData(((ComboBox)extraGroup.getComponent()).getPromptText());
            ComboDatas.create(comboData);
            ComboDatas.getConboData().add(comboData);
        }*/
    }

    public static void remove(String promptText){
        for (ExtraGroup extraGroup: extraGroups) {
            if (extraGroup.getGroupName().equals(promptText)){
                extraGroups.remove(extraGroup);
                sql.connDB();
                sql.execCommand("SELECT ID FROM ExtraGroups WHERE Username=\'"+ CurrentUser.getUsername() +"\' AND GroupName=\'"+ promptText +"\';");
                try {
                    if (sql.getResultSet().next()) {
                        sql.shutDB();
                        for (ExtraGroup extraGroup1 : ExtraGroups.extraGroups) {
                            save(extraGroup1.getGroupName(), extraGroup1.getComponentType().toString());
                        }
                        sql.connDB();
                        sql.execCommand("DELETE FROM ExtraGroups WHERE Username=\'" + CurrentUser.getUsername() + "\' AND GroupName=\'" + promptText + "\';");
                        sql.shutDB();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        load();
    }

    private static void load(){
        vBoxes.clear();
        for (ExtraGroup extraGroup : extraGroups) {
            addToLayout(extraGroup);
        }
    }
    public static void loadContent(){
        sql.connDB();
        sql.execCommand("SELECT GroupName, ComponentType FROM ExtraGroups");

        try {
            while (sql.getResultSet().next()){
                extraGroups.add(new ExtraGroup(sql.getResultSet().getString(1), ComponentType.valueOf(sql.getResultSet().getString(2))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql.shutDB();
    }

    private static void save(String groupName, String componentType){
        sqlControl.addInfoToTable("ExtraGroups", (sqlControl.getMaxIDFromDBTable("ExtraGroups")+1)+
                ", \'"+ CurrentUser.getUsername() +"\', \'"+groupName+"\', \'"+componentType+"\'");
    }

    private static VBox initVBox(){
        VBox vBox = new VBox(50);
        vBox.setPrefSize(340,500);

        return vBox;
    }

    public static VBox getVBox(){
        return vBoxes.get(vBoxes.size()-1);
    }

    static void addToLayout(ExtraGroup extraGroup){
        if (ExtraGroups.vBoxes.size() == 0){
            ExtraGroups.vBoxes.add(ExtraGroups.initVBox());
        }

        if(ExtraGroups.getVBox().getChildren().size() > 6){
            ExtraGroups.vBoxes.add(ExtraGroups.initVBox());
        }

        ExtraGroups.getVBox().getChildren().add(extraGroup.getHBox());
        VBox.setMargin(extraGroup.getHBox(), new Insets(0,0,0,0));
        if (ExtraGroups.getVBox().getChildren().size() == 1){
            VBox.setMargin(extraGroup.getHBox(), new Insets(30,0,0,0));
        }
    }
}
