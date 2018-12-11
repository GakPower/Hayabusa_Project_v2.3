package Core;

import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import Core.Scenes.Scenes;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class Main extends Application {

    public static Stage stage;
    private final static File file = new File("C:\\Hayabusa Project\\HayaBusa");
    private final static HyperSQL sql = new HyperSQL();
    private final static HyperSQLControl sqlControl = new HyperSQLControl(sql);
    public static Scenes scenes;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        stage.setTitle("Hayabusa Project");
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);

        scenes = Scenes.getInstance();

        scenes.addScene("Login", "Core/Scenes/Login_SingUp/Login_SingUp.fxml");
        scenes.addScene("App", "Core/Scenes/App/App.fxml");

        stage.setScene(Scenes.getFromMap("Login"));

        stage.show();
    }


    public static void main(String[] args) {
        createSQLTablesIfFileDoesNotExist();
        launch(args);
    }
    private static void createSQLTablesIfFileDoesNotExist(){
        if (!file.exists()) {
            sqlControl.createTable("Users","ID int NOT NULL PRIMARY KEY, Username varchar(30) NOT NULL, Password varchar(20) NOT NULL, SafeQuestion int NOT NULL, SafeAnswer varchar(50) NOT NULL");
            sqlControl.createTable("SecurityCombo", "ID int NOT NULL PRIMARY KEY, Username varchar(30) NOT NULL, Question varchar(100) NOT NULL, Answer varchar(50) NOT NULL,");
            sqlControl.createTable("RememberMe","ID int NOT NULL PRIMARY KEY, RememberMe BIT NOT NULL, Username varchar(30) NOT NULL");

            sqlControl.createTable("ExtraGroups", "ID int NOT NULL PRIMARY KEY, Username varchar(30) NOT NULL, GroupName varchar(30) NOT NULL, ComponentType varchar(30) NOT NULL");
            sqlControl.createTable("TableData", "ID int NOT NULL PRIMARY KEY, Username varchar(30) NOT NULL, Data varchar(500) ARRAY NOT NULL");
            //sqlControl.createTable("ColumnWidth", "Username varchar(30) NOT NULL, ColumnWidth int ARRAY NOT NULL");
            sqlControl.createTable("ExtraColumns", "ID int NOT NULL PRIMARY KEY, Username varchar(30) NOT NULL, ExtraColumns varchar(150) NOT NULL");

            sqlControl.addInfoToTable("RememberMe","1, 0, \'Uninitialized UserName\'");
        }
    }
}