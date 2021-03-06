package Core.Scenes.App;
//
// Author: GakPower
// 
// Date: 14-Jun-2018 (12:01 AM)
//

import Core.*;
import Core.Animations.Animation;
import Core.Animations.AnimationControls;
import Core.ComboData.ComboData;
import Core.ComboData.ComboDatas;
import Core.Components.ComboBox;
import Core.Components.Component;
import Core.Components.ComponentFactories.GroupFactory;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.Components.GroupOfComponents.GroupType;
import Core.DayConvertion.DateConvertion;
import Core.ExtraFields.ExtraGroup;
import Core.ExtraFields.ExtraGroups;
import Core.SQL.CurrentUser;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import Core.Scenes.Dialog;
import Core.Scenes.UIControls;
import com.jfoenix.controls.*;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static Core.Components.ComponentFactory.createComponent;

@SuppressWarnings("Duplicates")
public class AppController {

    @FXML private AnchorPane mainMenu_Anchor;
    @FXML private StackPane mainApp_Stack;

    @FXML private ProgressIndicator progressIndicator;
    @FXML private Text editingRowLabel;
    @FXML private VBox statVBox;
    @FXML private HBox statHbox;
    @FXML private JFXButton editRowButton;
    @FXML private JFXButton deleteRowButton;
    @FXML private Label helpLabel;
    @FXML public JFXButton sysRestoreButton;
    @FXML public JFXButton sysBackupButton;
    @FXML public Label sysBackupLabel;
    @FXML public Label sysRestoreLabel;
    @FXML public JFXButton accRestoreButton;
    @FXML public JFXButton accBackupButton;
    @FXML public Label accBackupLabel;
    @FXML public Label accRestoreLabel;

    @FXML private Label tripsLabel;
    @FXML private Label cmrLabel;
    @FXML private Label incomeLabel;
    @FXML private Label kilometersLabel;
    @FXML private Label trucksLabel;

    /*public TableColumn<TableData, String> idcolumn;
    public TableColumn<TableData, Integer> numcolumn;
    public TableColumn<TableData, String> fckcolumn;*/
    @FXML private ScrollPane otherScrollPane;
    @FXML public TableView<TableData> tableview;
    //@FXML public TableView<ArrayList<String>> tableview;

    @FXML private TableColumn<TableData, String> id;
    @FXML private TableColumn<TableData, String> departureDate;
    @FXML private TableColumn<TableData, String> departureTime;
    @FXML private TableColumn<TableData, String> exportationProduct;
    @FXML private TableColumn<TableData, String> departureEnterprise;
    @FXML private TableColumn<TableData, String> departureShip;
    @FXML private TableColumn<TableData, String> departurePort;
    @FXML private TableColumn<TableData, String> unloadingLocations;
    @FXML private TableColumn<TableData, String> arrivalDate;
    @FXML private TableColumn<TableData, String> arrivalTime;
    @FXML private TableColumn<TableData, String> importationProduct;
    @FXML private TableColumn<TableData, String> arrivalEnterprise;
    @FXML private TableColumn<TableData, String> arrivalShip;
    @FXML private TableColumn<TableData, String> arrivalPort;
    @FXML private TableColumn<TableData, String> loadingLocations;
    @FXML private TableColumn<TableData, String> truck;
    @FXML private TableColumn<TableData, String> company;
    @FXML private TableColumn<TableData, String> cmr;
    @FXML private TableColumn<TableData, String> income;
    @FXML private TableColumn<TableData, String> kilometers;
    @FXML private TableColumn<TableData, String> comments;
    private static ArrayList<TableColumn<TableData, String>> columns = new ArrayList<>(21);
    /*@FXML private TableColumn<ArrayList<String>, String> id;
    @FXML private TableColumn<ArrayList<String>, String> departureDate;
    @FXML private TableColumn<ArrayList<String>, String> departureTime;
    @FXML private TableColumn<ArrayList<String>, String> exportationProduct;
    @FXML private TableColumn<ArrayList<String>, String> departureEnterprise;
    @FXML private TableColumn<ArrayList<String>, String> departureShip;
    @FXML private TableColumn<ArrayList<String>, String> departurePort;
    @FXML private TableColumn<ArrayList<String>, String> unloadingLocations;
    @FXML private TableColumn<ArrayList<String>, String> arrivalDate;
    @FXML private TableColumn<ArrayList<String>, String> arrivalTime;
    @FXML private TableColumn<ArrayList<String>, String> importationProduct;
    @FXML private TableColumn<ArrayList<String>, String> arrivalEnterprise;
    @FXML private TableColumn<ArrayList<String>, String> arrivalShip;
    @FXML private TableColumn<ArrayList<String>, String> arrivalPort;
    @FXML private TableColumn<ArrayList<String>, String> loadingLocations;
    @FXML private TableColumn<ArrayList<String>, String> truck;
    @FXML private TableColumn<ArrayList<String>, String> company;
    @FXML private TableColumn<ArrayList<String>, String> cmr;
    @FXML private TableColumn<ArrayList<String>, String> income;
    @FXML private TableColumn<ArrayList<String>, String> kilometers;
    @FXML private TableColumn<ArrayList<String>, String> comments;
    private ArrayList<TableColumn<ArrayList<String>, String>> columns = new ArrayList<>(20);*/


    @FXML private JFXButton minAddFieldButton;
    @FXML private JFXButton minRemoveFieldButton;

    @FXML private AnchorPane newFieldAnchor;
    @FXML private AnchorPane removeFieldAnchor;

    @FXML private ImageView arrowNewField;
    @FXML private ImageView arrowRemoveField;

    @FXML private ImageView newField_ImageError;
    @FXML private Label newField_Error;
    @FXML private ImageView removeField_ImageError;
    @FXML private Label removeField_Error;

    @FXML private JFXTextField newField_TextField;
    @FXML private JFXTextField removeField_TextField;

    @FXML private JFXRadioButton radioField;
    @FXML private JFXRadioButton radioList;

    @FXML private JFXButton removeFieldButton;
    @FXML private JFXButton addFieldButton;

    private Component newField_Comp;
    private Component removeField_Comp;
    private GroupOfComponents newField_Group;
    private GroupOfComponents removeField_Group;

    @FXML private AnchorPane otherAnchor;
    private HBox hBox = new HBox();


    @FXML private JFXButton saveButton;
    @FXML private ImageView exitMenuButton;

    @FXML private AnchorPane userWin;
    @FXML private AnchorPane tableWin;
    @FXML private AnchorPane addWin;
    @FXML private AnchorPane statWin;
    @FXML private AnchorPane settWin;

    @FXML private ImageView arrow;
    @FXML private AnchorPane userButton;
    @FXML private AnchorPane tableButton;
    @FXML private AnchorPane addButton;
    @FXML private AnchorPane statButton;
    @FXML private AnchorPane settButton;

    @FXML private JFXDatePicker DepDate;
    @FXML private JFXTimePicker DepTime;
    @FXML private JFXComboBox DepProduct;
    @FXML private JFXComboBox DepEnterprise;
    @FXML private JFXComboBox DepShip;
    @FXML private JFXComboBox DepPort;
    @FXML private JFXComboBox DepUnloadingLoc;

    @FXML private JFXDatePicker ArrDate;
    @FXML private JFXTimePicker ArrTime;
    @FXML private JFXComboBox ArrProduct;
    @FXML private JFXComboBox ArrEnterprise;
    @FXML private JFXComboBox ArrShip;
    @FXML private JFXComboBox ArrPort;
    @FXML private JFXComboBox ArrLoadingLoc;

    @FXML private Label ArrDate_Error;
    @FXML private Label ArrTime_Error;
    @FXML private Label ArrProduct_Error;
    @FXML private Label ArrEnterprise_Error;
    @FXML private Label ArrShip_Error;
    @FXML private Label ArrPort_Error;
    @FXML private Label ArrLoadingLoc_Error;

    @FXML private Label DepDate_Error;
    @FXML private Label DepTime_Error;
    @FXML private Label DepProduct_Error;
    @FXML private Label DepEnterprise_Error;
    @FXML private Label DepShip_Error;
    @FXML private Label DepPort_Error;
    @FXML private Label DepUnloadingLoc_Error;

    @FXML private Label OthTruck_Error;
    @FXML private Label OthCompany_Error;
    @FXML private Label OthCMR_Error;
    @FXML private Label OthIncome_Error;
    @FXML private Label OthKil_Error;
    @FXML private Label OthCom_Error;


    @FXML private ImageView DepDate_ImageError;
    @FXML private ImageView DepTime_ImageError;
    @FXML private ImageView DepProduct_ImageError;
    @FXML private ImageView DepEnterprise_ImageError;
    @FXML private ImageView DepShip_ImageError;
    @FXML private ImageView DepPort_ImageError;
    @FXML private ImageView DepUnloadingLoc_ImageError;

    @FXML private ImageView ArrTime_ImageError;
    @FXML private ImageView ArrDate_ImageError;
    @FXML private ImageView ArrProduct_ImageError;
    @FXML private ImageView ArrEnterprise_ImageError;
    @FXML private ImageView ArrShip_ImageError;
    @FXML private ImageView ArrPort_ImageError;
    @FXML private ImageView ArrLoadingLoc_ImageError;

    @FXML private ImageView OthTruck_ImageError;
    @FXML private ImageView OthCompany_ImageError;
    @FXML private ImageView OthCMR_ImageError;
    @FXML private ImageView OthIncome_ImageError;
    @FXML private ImageView OthKil_ImageError;
    @FXML private ImageView OthCom_ImageError;

    @FXML private JFXButton ArrProduct_But;
    @FXML private JFXButton ArrEnterprise_But;
    @FXML private JFXButton ArrShip_But;
    @FXML private JFXButton ArrPort_But;
    @FXML private JFXButton ArrLoadingLoc_But;

    @FXML private JFXButton DepProduct_Butt;
    @FXML private JFXButton DepEnterprise_But;
    @FXML private JFXButton DepShip_But;
    @FXML private JFXButton DepPort_But;
    @FXML private JFXButton DepUnloadingLoc_But;

    @FXML private JFXButton OthTruck_But;
    @FXML private JFXButton OthCompany_But;

    @FXML private JFXComboBox OthTruck;
    @FXML private JFXComboBox OthCompany;
    @FXML private JFXTextField OthCMR;
    @FXML private JFXTextField OthIncome;
    @FXML private JFXTextField OthKil;
    @FXML private JFXTextArea OthCom;

    @FXML private JFXCheckBox ComCheck;

    @FXML private JFXButton exitButtonUser;
    @FXML private JFXButton exitButtonTable;
    @FXML private JFXButton exitButtonAdd;
    @FXML private JFXButton exitButtonStat;
    @FXML private JFXButton exitButtonSett;

    @FXML private JFXButton minButtonAdd;
    @FXML private JFXButton minButtonUser;
    @FXML private JFXButton minButtonStat;
    @FXML private JFXButton minButtonSett;
    @FXML private JFXButton minButtonTable;

    private ErrorLabel ArrDate_Error_Label;
    private ErrorLabel ArrTime_Error_Label;
    private ErrorLabel ArrProduct_Error_Label;
    private ErrorLabel ArrEnterprise_Error_Label;
    private ErrorLabel ArrShip_Error_Label;
    private ErrorLabel ArrPort_Error_Label;
    private ErrorLabel ArrLoadingLoc_Error_Label;

    private ErrorLabel DepDate_Error_Label;
    private ErrorLabel DepTime_Error_Label;
    private ErrorLabel DepProduct_Error_Label;
    private ErrorLabel DepEnterprise_Error_Label;
    private ErrorLabel DepShip_Error_Label;
    private ErrorLabel DepPort_Error_Label;
    private ErrorLabel DepUnloadingLoc_Error_Label;

    private ErrorLabel OthTruck_Error_Label;
    private ErrorLabel OthCompany_Error_Label;
    private ErrorLabel OthCMR_Error_Label;
    private ErrorLabel OthIncome_Error_Label;
    private ErrorLabel OthKil_Error_Label;
    private ErrorLabel OthCom_Error_Label;

    private ErrorLabel newField_Error_Label;
    private ErrorLabel removeField_Error_Label;


    private Component ArrDate_Comp;
    private Component ArrTime_Comp;
    private Component ArrProduct_Comp;
    private Component ArrEnterprise_Comp;
    private Component ArrShip_Comp;
    private Component ArrPort_Comp;
    private Component ArrLoadingLoc_Comp;

    private Component DepDate_Comp;
    private Component DepTime_Comp;
    private Component DepProduct_Comp;
    private Component DepEnterprise_Comp;
    private Component DepShip_Comp;
    private Component DepPort_Comp;
    private Component DepUnloadingLoc_Comp;

    private Component OthTruck_Comp;
    private Component OthCompany_Comp;
    private Component OthCMR_Comp;
    private Component OthIncome_Comp;
    private Component OthKil_Comp;
    private Component OthCom_Comp;

    private GroupOfComponents ArrDate_Group;
    private GroupOfComponents ArrTime_Group;
    private GroupOfComponents ArrProduct_Group;
    private GroupOfComponents ArrEnterprise_Group;
    private GroupOfComponents ArrShip_Group;
    private GroupOfComponents ArrPort_Group;
    private GroupOfComponents LoadingLoc_Group;

    private GroupOfComponents DepDate_Group;
    private GroupOfComponents DepTime_Group;
    private GroupOfComponents DepProduct_Group;
    private GroupOfComponents DepEnterprise_Group;
    private GroupOfComponents DepShip_Group;
    private GroupOfComponents DepPort_Group;
    private GroupOfComponents UnloadingLoc_Group;

    private GroupOfComponents OthTruck_Group;
    private GroupOfComponents OthCompany_Group;
    private GroupOfComponents OthCMR_Group;
    private GroupOfComponents OthIncome_Group;
    private GroupOfComponents OthKil_Group;
    private GroupOfComponents OthCom_Group;


    private AnchorPane activeWin;
    private AnchorPane activeButton;

    private HashMap<AnchorPane, AnchorPane> windows = new HashMap<>();
    private HashMap<AnchorPane, String> oldStyles = new HashMap<>();
    private HashMap<AnchorPane, String> newStyles = new HashMap<>();
    private HashMap<AnchorPane, JFXButton> exitButtons = new HashMap<>();
    private HashMap<AnchorPane, JFXButton> minButtons = new HashMap<>();

    private boolean loadData = false;

    //private ArrayList<Integer> columnsWidth = new ArrayList<>(20);

    private boolean editingRow = false;
    private HyperSQL sql = new HyperSQL();


    private int editingRowID;
    private HashMap<String, ComboBox> comboBoxes = new HashMap<>();

    private TableData getSelectedRow(){
        return tableview.getSelectionModel().getSelectedItem();
    }
    private void reduceTableIDByOne(int id){
        for (int i = id - 1; i < tableview.getItems().size(); i++) {
            tableview.getItems().get(i).setId(i + 1 + "");
        }
    }
    private void reduceDBIDByOne(int id){
        sql.connDB();
        sql.execUpdateCommand("UPDATE TableData SET ID=ID-1 WHERE ID >=" + id + " AND Username=\'" + CurrentUser.getUsername() + "\';");
        sql.shutDB();
    }
    private void reduceIDByOne(int id){
        reduceTableIDByOne(id);
        reduceDBIDByOne(id);
    }
    private void initNoRowSelectedDialog(){
        Dialog dialog = new Dialog(mainApp_Stack,
                "You have not select any row. Select a row by clicking on It",
                "OK",
                "Core/Scenes/App/StyleSheet.css",
                "dialogButton",
                mainMenu_Anchor, tableWin);
        dialog.getButton().setOnAction(event1 -> dialog.close());
    }
    private void removeRow(TableData selectedRow, int id){
        tableview.getItems().remove(selectedRow);
        TableDatas.delete(CurrentUser.getUsername(), id);
    }
    private void setHelpToolTip(){
        helpLabel.setTooltip(new Tooltip("To Edit or Delete a row from the Table you have to select the row and click the right button"));
    }
    private void setSettToolTips(){
        Tooltip tooltip = new Tooltip();
        tooltip.setStyle("-fx-font-size: 20;");
        sysBackupLabel.setTooltip(new Tooltip("You can get a backup of the whole system with all the accounts"));
        sysRestoreLabel.setTooltip(new Tooltip("You can restore a backup you have taken of the whole system with all the accounts"));
        accBackupLabel.setTooltip(new Tooltip("You can get a backup of your account"));
        accRestoreLabel.setTooltip(new Tooltip("You can restore a backup you have taken of your account"));
    }
    private void setOnActionDelete(){
        deleteRowButton.setOnAction(event ->
        {
            TableData selectedRow = getSelectedRow();
            if (selectedRow != null)
            {
                int id = Integer.valueOf(selectedRow.getId());

                removeRow(selectedRow, id);
                reduceIDByOne(id);
            }else{
                initNoRowSelectedDialog();
            }
        });
    }
    private void transferExtraColumnsTableInputs(TableData selectedRow){
        for (int i = 21; i < 21 + ExtraGroups.extraGroups.size(); i++) {
            if (i - 21 < selectedRow.getExtraData().size()) {
                ExtraGroups.extraGroups.get(i - 21).getComponent().setText(selectedRow.getExtraData().get(i - 21));
            } else {
                ExtraGroups.extraGroups.get(i - 21).getComponent().setText("");
            }
        }
    }
    private void transferTableInputs(TableData selectedRow){
        DepDate_Group.setInput(selectedRow.getDepartureDate());
        DepTime_Group.setInput(selectedRow.getDepartureTime());
        DepProduct_Group.setInput(selectedRow.getExportationProduct());
        DepEnterprise_Group.setInput(selectedRow.getDepartureEnterprise());
        DepShip_Group.setInput(selectedRow.getDepartureShip());
        DepPort_Group.setInput(selectedRow.getDeparturePort());
        UnloadingLoc_Group.setInput(selectedRow.getUnloadingLocations());
        ArrDate_Group.setInput(selectedRow.getArrivalDate());
        ArrTime_Group.setInput(selectedRow.getArrivalTime());
        ArrProduct_Group.setInput(selectedRow.getImportationProduct());
        ArrEnterprise_Group.setInput(selectedRow.getArrivalEnterprise());
        ArrShip_Group.setInput(selectedRow.getArrivalShip());
        ArrPort_Group.setInput(selectedRow.getArrivalPort());
        LoadingLoc_Group.setInput(selectedRow.getLoadingLocations());
        OthTruck_Group.setInput(selectedRow.getTruck());
        OthCompany_Group.setInput(selectedRow.getCompany());
        OthCMR_Group.setInput(selectedRow.getCmr());
        OthIncome_Group.setInput(selectedRow.getIncome());
        OthKil_Group.setInput(selectedRow.getKilometers());
        if (!selectedRow.getComments().equals("No Comment")) {
            OthCom_Group.setInput(selectedRow.getComments());
            OthCom_Group.checkBox.setSelected(true);
        } else {
            OthCom_Group.setInput("");
            OthCom_Group.checkBox.setSelected(false);
        }

        transferExtraColumnsTableInputs(selectedRow);
    }
    private void setOnActionEdit(){
        editRowButton.setOnAction(event -> {
            TableData selectedRow = getSelectedRow();
            if (selectedRow != null) {
                editingRow = true;
                editingRowLabel.setVisible(true);

                editingRowID = Integer.valueOf(selectedRow.getId());
                transferTableInputs(selectedRow);

                switchWindow(addButton);
            }else{
                initNoRowSelectedDialog();
            }
        });
    }
    private void banAllNonNumberForJFXTextField(JFXTextField textField){
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML private void initialize()
    {
        setHelpToolTip();
        setSettToolTips();
        setOnActionDelete();
        setOnActionEdit();

        banAllNonNumberForJFXTextField(OthCMR);
        banAllNonNumberForJFXTextField(OthIncome);
        banAllNonNumberForJFXTextField(OthKil);

        initializeHashMaps();
        menuButtonsSwitchSetup();
        minExitButtonsListeners();

        initScrollBar();

        initErrorLabels();
        initComponents();
        initGroup();

        initComboBoxesHashMap();
        initAddField();
        initRemoveField();
        initMinButtons();

        initColumnProperties();

        setOnActionSave();

        setOnClickStat();
    }
    private void setOnClickStat(){
        DataSorter dataSorter = new DataSorter(tableview.getItems());
        double pieChartStartingAngle = 30;
        double pieChartSize = 465;
        ////////////////////////////////////////////////////////////
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> barLoadedEmptyTripsChart = new BarChart<>(xAxis,yAxis);
        barLoadedEmptyTripsChart.setPrefWidth(500);
        barLoadedEmptyTripsChart.setTitle("Loaded/Empty Trips (by year)");

        xAxis.setLabel("Year");
        yAxis.setLabel("Trips");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Loaded");
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Empty");
        //////////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieLoadedEmptyData =
                FXCollections.observableArrayList();
        PieChart pieLoadedEmpty = new PieChart(pieLoadedEmptyData);
        pieLoadedEmpty.setTitle("Loaded/Empty Trips");
        pieLoadedEmpty.setStartAngle(pieChartStartingAngle);
        pieLoadedEmpty.setPrefSize(pieChartSize,pieChartSize);
        //////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieCompanyData =
                FXCollections.observableArrayList();
        PieChart pieCompany = new PieChart(pieCompanyData);
        pieCompany.setTitle("Company");
        pieCompany.setStartAngle(pieChartStartingAngle);
        pieCompany.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieExportProductData =
                FXCollections.observableArrayList();
        PieChart pieExportProduct = new PieChart(pieExportProductData);
        pieExportProduct.setTitle("Exportation Product");
        pieExportProduct.setStartAngle(pieChartStartingAngle);
        pieExportProduct.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieDepEnterpriseData =
                FXCollections.observableArrayList();
        PieChart pieDepartureEnterprise = new PieChart(pieDepEnterpriseData);
        pieDepartureEnterprise.setTitle("Departure Enterprise");
        pieDepartureEnterprise.setStartAngle(pieChartStartingAngle);
        pieDepartureEnterprise.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieDepShipData =
                FXCollections.observableArrayList();
        PieChart pieDepShip = new PieChart(pieDepShipData);
        pieDepShip.setTitle("Departure Ship");
        pieDepShip.setStartAngle(pieChartStartingAngle);
        pieDepShip.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieDepPortData =
                FXCollections.observableArrayList();
        PieChart pieDepPort = new PieChart(pieDepPortData);
        pieDepPort.setTitle("Departure Port(From-To)");
        pieDepPort.setStartAngle(pieChartStartingAngle);
        pieDepPort.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieUnloadingLocData =
                FXCollections.observableArrayList();
        PieChart pieUnloadingLoc = new PieChart(pieUnloadingLocData);
        pieUnloadingLoc.setTitle("Unloading Locations");
        pieUnloadingLoc.setStartAngle(pieChartStartingAngle);
        pieUnloadingLoc.setPrefSize(pieChartSize,pieChartSize);
        ////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieImportProductData =
                FXCollections.observableArrayList();
        PieChart pieImportProduct = new PieChart(pieImportProductData);
        pieImportProduct.setTitle("Importation Product");
        pieImportProduct.setStartAngle(pieChartStartingAngle);
        pieImportProduct.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieArrEnterpriseData =
                FXCollections.observableArrayList();
        PieChart pieArrEnterprise = new PieChart(pieArrEnterpriseData);
        pieArrEnterprise.setTitle("Arrival Enterprise");
        pieArrEnterprise.setStartAngle(pieChartStartingAngle);
        pieArrEnterprise.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieArrShipData =
                FXCollections.observableArrayList();
        PieChart pieArrShip = new PieChart(pieArrShipData);
        pieArrShip.setTitle("Arrival Ship");
        pieArrShip.setStartAngle(pieChartStartingAngle);
        pieArrShip.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieArrPortData =
                FXCollections.observableArrayList();
        PieChart pieArrPort = new PieChart(pieArrPortData);
        pieArrPort.setTitle("Arrival Port(From-To)");
        pieArrPort.setStartAngle(pieChartStartingAngle);
        pieArrPort.setPrefSize(pieChartSize,pieChartSize);
        /////////////////////////////////////////////////////
        ObservableList<PieChart.Data> pieLoadingLocData =
                FXCollections.observableArrayList();
        PieChart pieLoadingLoc = new PieChart(pieLoadingLocData);
        pieLoadingLoc.setTitle("Loading Locations");
        pieLoadingLoc.setStartAngle(pieChartStartingAngle);
        pieLoadingLoc.setPrefSize(pieChartSize,pieChartSize);
        ////////////////////////////////////////////////////
        final CategoryAxis yearXAxis = new CategoryAxis();
        final NumberAxis incomeYAxis = new NumberAxis();
        yearXAxis.setLabel("Year");
        incomeYAxis.setLabel("Income");

        final LineChart<String,Number> lineYearlyIncome = new LineChart<>(yearXAxis, incomeYAxis);
        lineYearlyIncome.setTitle("Yearly Income");
        lineYearlyIncome.setLegendVisible(false);

        XYChart.Series yearlyIncomeSeries = new XYChart.Series();
        lineYearlyIncome.getData().add(yearlyIncomeSeries);

        statButton.setOnMouseClicked(event -> {

            currentStatHBox = new HBox();
            ///////// Update BarChart ///////////
            SortedMap<String, ArrayList<TableData>> yearlySortedData = dataSorter.getYearlySortedData();
            int emptyTrips = 0;
            int tempNumOfEmptyTrips;
            for (String year : yearlySortedData.keySet()) {
                tempNumOfEmptyTrips = 0;
                for (TableData data : yearlySortedData.get(year)) {
                    if (data.getExportationProduct().equals("-")){
                        tempNumOfEmptyTrips++;
                    }
                }
                series1.getData().add(new XYChart.Data<>(year, yearlySortedData.get(year).size()-tempNumOfEmptyTrips));
                series2.getData().add(new XYChart.Data<>(year, tempNumOfEmptyTrips));
                emptyTrips += tempNumOfEmptyTrips;
            }

            if (!statHbox.getChildren().contains(barLoadedEmptyTripsChart)
                    && tableview.getItems().size() > 0){
                barLoadedEmptyTripsChart.getData().clear();
                barLoadedEmptyTripsChart.getData().addAll(series1, series2);
                statHbox.getChildren().add(barLoadedEmptyTripsChart);
            }

            resizeBarLoadedEmptyChart(yearlySortedData, barLoadedEmptyTripsChart);
            ///////// Update PieChart (LoadedEmpty) ///////////
            pieLoadedEmptyData.clear();
            if ((tableview.getItems().size()-emptyTrips) > 0) {
                pieLoadedEmptyData.add(new PieChart.Data("Loaded", tableview.getItems().size()-emptyTrips));
            }
            if (emptyTrips > 0) {
                pieLoadedEmptyData.add(new PieChart.Data("Empty", emptyTrips));
            }

            addChartsToStatVBox(pieLoadedEmpty);
            ///////// Update PieChart (Company) ///////////
            SortedMap<String, ArrayList<TableData>> companySortedData = dataSorter.getCompanySortedData();
            pieCompanyData.clear();
            int tempNumOfTripsPerPerson;
            for (String company : companySortedData.keySet()) {
                tempNumOfTripsPerPerson = companySortedData.get(company).size();
                pieCompanyData.add(new PieChart.Data(company, tempNumOfTripsPerPerson));
            }
            addChartsToStatVBox(pieCompany);
            //////// Update PieChart (Export Product) ////
            SortedMap<String, ArrayList<TableData>> expProductSortedData = dataSorter.getExpProductSortedData();
            pieExportProductData.clear();
            int tempNumOfExpProduct;
            for (String expProduct : expProductSortedData.keySet()) {
                tempNumOfExpProduct = expProductSortedData.get(expProduct).size();
                if (expProduct.equals("-")){
                    expProduct = "None";
                }
                pieExportProductData.add(new PieChart.Data(expProduct, tempNumOfExpProduct));
            }
            addChartsToStatVBox(pieExportProduct);
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> depEnterpriseSortedData = dataSorter.getDepEnterpriseSortedData();
            pieDepEnterpriseData.clear();
            int tempNumOfDepEnterprise;
            for (String depEnterprise : depEnterpriseSortedData.keySet()) {
                tempNumOfDepEnterprise = depEnterpriseSortedData.get(depEnterprise).size();
                pieDepEnterpriseData.add(new PieChart.Data(depEnterprise, tempNumOfDepEnterprise));
            }
            addChartsToStatVBox(pieDepartureEnterprise);
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> pieDepShipSortedData = dataSorter.getDepShipSortedData();
            pieDepShipData.clear();
            int tempNumOfDepShip;
            for (String depShip : pieDepShipSortedData.keySet()) {
                tempNumOfDepShip = pieDepShipSortedData.get(depShip).size();
                pieDepShipData.add(new PieChart.Data(depShip, tempNumOfDepShip));
            }
            addChartsToStatVBox(pieDepShip);
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> pieDepPortSortedData = dataSorter.getDepPortSortedData();
            pieDepPortData.clear();
            int tempNumOfDepPort;
            for (String depPort : pieDepPortSortedData.keySet()) {
                tempNumOfDepPort = pieDepPortSortedData.get(depPort).size();
                pieDepPortData.add(new PieChart.Data(depPort, tempNumOfDepPort));
            }
            addChartsToStatVBox(pieDepPort);
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> pieUnloadingLocSortedData = dataSorter.getUnloadingLocSortedData();
            pieUnloadingLocData.clear();
            int tempNumOfUnloadingLoc;
            for (String unloadingLoc : pieUnloadingLocSortedData.keySet()) {
                tempNumOfUnloadingLoc = pieUnloadingLocSortedData.get(unloadingLoc).size();
                pieUnloadingLocData.add(new PieChart.Data(unloadingLoc, tempNumOfUnloadingLoc));
            }
            addChartsToStatVBox(pieUnloadingLoc);
            /////////////////////////////////////////////
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> impProductSortedData = dataSorter.getImportProductSortedData();
            pieImportProductData.clear();
            int tempNumOfImpProduct;
            for (String impProduct : impProductSortedData.keySet()) {
                tempNumOfImpProduct = impProductSortedData.get(impProduct).size();
                if (impProduct.equals("-")){
                    impProduct = "None";
                }
                pieImportProductData.add(new PieChart.Data(impProduct, tempNumOfImpProduct));
            }
            addChartsToStatVBox(pieImportProduct);
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> arrEnterpriseSortedData = dataSorter.getArrEnterpriseSortedData();
            pieArrEnterpriseData.clear();
            int tempNumOfArrEnterprise;
            for (String arrEnterprise : arrEnterpriseSortedData.keySet()) {
                tempNumOfArrEnterprise = arrEnterpriseSortedData.get(arrEnterprise).size();
                pieArrEnterpriseData.add(new PieChart.Data(arrEnterprise, tempNumOfArrEnterprise));
            }
            addChartsToStatVBox(pieArrEnterprise);
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> pieArrShipSortedData = dataSorter.getArrShipSortedData();
            pieArrShipData.clear();
            int tempNumOfArrShip;
            for (String arrShip : pieArrShipSortedData.keySet()) {
                tempNumOfArrShip = pieArrShipSortedData.get(arrShip).size();
                pieArrShipData.add(new PieChart.Data(arrShip, tempNumOfArrShip));
            }
            addChartsToStatVBox(pieArrShip);
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> pieArrPortSortedData = dataSorter.getArrPortSortedData();
            pieArrPortData.clear();
            int tempNumOfArrPort;
            for (String arrPort : pieArrPortSortedData.keySet()) {
                tempNumOfArrPort = pieArrPortSortedData.get(arrPort).size();
                pieArrPortData.add(new PieChart.Data(arrPort, tempNumOfArrPort));
            }
            addChartsToStatVBox(pieArrPort);
            /////////////////////////////////////////////
            SortedMap<String, ArrayList<TableData>> pieLoadingLocSortedData = dataSorter.getLoadingLocSortedData();
            pieLoadingLocData.clear();
            int tempNumOfLoadingLoc;
            for (String loadingLoc : pieLoadingLocSortedData.keySet()) {
                tempNumOfLoadingLoc = pieLoadingLocSortedData.get(loadingLoc).size();
                pieLoadingLocData.add(new PieChart.Data(loadingLoc, tempNumOfLoadingLoc));
            }
            addChartsToStatVBox(pieLoadingLoc);
            /////////////////////////////////////////////
            yearlyIncomeSeries.getData().clear();
            for (String year: yearlySortedData.keySet()) {
                double incomeOfTheYear = yearlySortedData.get(year).stream().mapToDouble(a -> Double.parseDouble(a.getIncome())).sum();
                yearlyIncomeSeries.getData().add(new XYChart.Data(year, incomeOfTheYear));
            }
            resizeBarLoadedEmptyChart(yearlySortedData, lineYearlyIncome);
            addChartsToStatVBox(lineYearlyIncome);
            ////////////////////////////////////////////////////////////////
            setStatInfo(yearlySortedData);
        });
    }

    private void resizeBarLoadedEmptyChart(SortedMap<String, ArrayList<TableData>> yearlySortedData,
                                           Chart chart){
        if (yearlySortedData.keySet().size() > 10){
            chart.setPrefWidth(50*yearlySortedData.keySet().size());
        }
    }
    private HBox currentStatHBox = new HBox();
    private void addChartsToStatVBox(Chart chart){
        if (!statVBox.getChildren().contains(currentStatHBox)){
            statVBox.getChildren().add(currentStatHBox);
        }
        if (!currentStatHBox.getChildren().contains(chart) && tableview.getItems().size() > 0) {
            currentStatHBox.getChildren().add(chart);
        }

        if (currentStatHBox.getChildren().size() > 2){
            currentStatHBox = new HBox();
            statVBox.getChildren().add(currentStatHBox);
        }
    }
    private void setOnActionSave(){
        saveButton.setOnAction(event -> saveInputsOnTable());
    }
    private void saveInputsOnTable(){
        progressIndicator.setVisible(true);
        saveButton.setDisable(true);
        hideAllErrorLabels();
        ArrayList<String> data = new ArrayList<>();
        if (areInputsOK()) {

            addDataToTempArray(data);
            addAnyExtraFieldDataToComboArray();

            ArrayList<ComboData> values = getValuesFromComboBoxes();

            ComboDatas.save(comboBoxes, values);

            if (editingRow) {
                TableData tableData = new TableData(editingRowID, data);
                tableData.setId(editingRowID + "");
                tableview.getItems().set(editingRowID - 1, tableData);
                TableDatas.set(editingRowID - 1, tableData);
                TableDatas.setToDB(tableData);
                editingRow = false;
                editingRowLabel.setVisible(false);

                switchWindow(tableButton);

                tableview.scrollTo(tableData);
            } else {
                TableData tableData = new TableData(data);
                tableview.getItems().add(tableData);
                TableDatas.add(tableData);
                TableDatas.save(tableData);
            }
            progressIndicator.setVisible(false);
            saveButton.setDisable(false);
        }
        progressIndicator.setVisible(false);
        saveButton.setDisable(false);
    }
    private ArrayList<ComboData> getValuesFromComboBoxes(){
        ArrayList<ComboData> values = new ArrayList<>();
        for (ComboBox comboBox : comboBoxes.values()) {
            values.add(new ComboData(comboBox.getPromptText(), comboBox.getText()));
        }

        return values;
    }
    private void addAnyExtraFieldDataToComboArray(){
        for (ExtraGroup extraGroup : ExtraGroups.extraGroups) {
            if (extraGroup.getComponentType() == ComponentType.COMBOBOX) {
                if (!comboBoxes.keySet().contains(((ComboBox) extraGroup.getComponent()).getPromptText())) {
                    comboBoxes.put(((ComboBox) extraGroup.getComponent()).getPromptText(), ((ComboBox) extraGroup.getComponent()));
                }
            }
        }
    }
    private void addDataToTempArray(ArrayList<String> data){
        data.add(DepDate_Group.getInput());
        data.add(DepTime_Group.getInput());
        data.add(DepProduct_Group.getInput());
        data.add(DepEnterprise_Group.getInput());
        data.add(DepShip_Group.getInput());
        data.add(DepPort_Group.getInput());
        data.add(UnloadingLoc_Group.getInput());
        data.add(ArrDate_Group.getInput());
        data.add(ArrTime_Group.getInput());
        data.add(ArrProduct_Group.getInput());
        data.add(ArrEnterprise_Group.getInput());
        data.add(ArrShip_Group.getInput());
        data.add(ArrPort_Group.getInput());
        data.add(LoadingLoc_Group.getInput());
        data.add(OthTruck_Group.getInput());
        data.add(OthCompany_Group.getInput());
        data.add(OthCMR_Group.getInput());
        data.add(OthIncome_Group.getInput());
        data.add(OthKil_Group.getInput());
        if (OthCom_Group.checkBox.isSelected()) {
            data.add(OthCom_Group.getInput());
        } else {
            data.add("No Comment");
        }
        for (ExtraGroup extraGroup : ExtraGroups.extraGroups) {
            data.add(extraGroup.getComponent().getText());
        }
    }

    private void initColumnProperties(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
        departureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        exportationProduct.setCellValueFactory(new PropertyValueFactory<>("exportationProduct"));
        departureEnterprise.setCellValueFactory(new PropertyValueFactory<>("departureEnterprise"));
        departureShip.setCellValueFactory(new PropertyValueFactory<>("departureShip"));
        departurePort.setCellValueFactory(new PropertyValueFactory<>("departurePort"));
        unloadingLocations.setCellValueFactory(new PropertyValueFactory<>("unloadingLocations"));
        arrivalDate.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        arrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        importationProduct.setCellValueFactory(new PropertyValueFactory<>("importationProduct"));
        arrivalEnterprise.setCellValueFactory(new PropertyValueFactory<>("arrivalEnterprise"));
        arrivalShip.setCellValueFactory(new PropertyValueFactory<>("arrivalShip"));
        arrivalPort.setCellValueFactory(new PropertyValueFactory<>("arrivalPort"));
        loadingLocations.setCellValueFactory(new PropertyValueFactory<>("loadingLocations"));
        truck.setCellValueFactory(new PropertyValueFactory<>("truck"));
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        cmr.setCellValueFactory(new PropertyValueFactory<>("cmr"));
        income.setCellValueFactory(new PropertyValueFactory<>("income"));
        kilometers.setCellValueFactory(new PropertyValueFactory<>("kilometers"));
        comments.setCellValueFactory(new PropertyValueFactory<>("comments"));
    }

    private void switchWindow(AnchorPane menuButton){
        int newPositionOfArrow = (int) (menuButton.getLayoutY() + menuButton.getPrefHeight() / 2 + 13);

        if (activeWin != windows.get(menuButton)) {
            if (activeWin != null) {
                activeButton.setStyle(oldStyles.get(menuButton));

                AnimationControls.hideAndShowWithAnimationInDuration(activeWin, windows.get(menuButton), Duration.millis(500));
            } else {
                Animation.fadeInAnimation(Duration.millis(500), windows.get(menuButton)).play();
            }
        }
        createAndRunDriftAnimation(newPositionOfArrow);

        activeWin = windows.get(menuButton);
        activeButton = menuButton;

        menuButton.setStyle(newStyles.get(menuButton));
        windows.get(menuButton).setVisible(true);
    }

    private ArrayList<Integer> getColumnWidth(){
        ArrayList<Integer> columnsWidth = new ArrayList<>();
        for (TableColumn<TableData, String> column: columns){
            columnsWidth.add((int) column.widthProperty().get());
            System.out.println((int) column.widthProperty().get());
        }
        return columnsWidth;
    }

    private void initColumnArray(){
        columns.add(id);
        columns.add(departureDate);
        columns.add(departureTime);
        columns.add(exportationProduct);
        columns.add(departureEnterprise);
        columns.add(departureShip);
        columns.add(departurePort);
        columns.add(unloadingLocations);
        columns.add(arrivalDate);
        columns.add(arrivalTime);
        columns.add(importationProduct);
        columns.add(arrivalEnterprise);
        columns.add(arrivalShip);
        columns.add(arrivalPort);
        columns.add(loadingLocations);
        columns.add(truck);
        columns.add(company);
        columns.add(cmr);
        columns.add(income);
        columns.add(kilometers);
        columns.add(comments);

        columns = TableExtraColumns.loadExtraColumns(columns);
    }


    private void hideAllErrorLabels(){
        DepDate_Group.hideErrorLabel();
        DepTime_Group.hideErrorLabel();
        DepProduct_Group.hideErrorLabel();
        DepEnterprise_Group.hideErrorLabel();
        DepShip_Group.hideErrorLabel();
        DepPort_Group.hideErrorLabel();
        UnloadingLoc_Group.hideErrorLabel();
        ArrDate_Group.hideErrorLabel();
        ArrTime_Group.hideErrorLabel();
        ArrProduct_Group.hideErrorLabel();
        ArrEnterprise_Group.hideErrorLabel();
        ArrShip_Group.hideErrorLabel();
        ArrPort_Group.hideErrorLabel();
        LoadingLoc_Group.hideErrorLabel();
        OthTruck_Group.hideErrorLabel();
        OthCompany_Group.hideErrorLabel();
        OthCMR_Group.hideErrorLabel();
        OthIncome_Group.hideErrorLabel();
        OthKil_Group.hideErrorLabel();
        OthCom_Group.hideErrorLabel();
    }
    private boolean areInputsOK(){
        boolean isDepDateOK = DepDate_Group.isInputOK(null);
        boolean isDepTimeOK = DepTime_Group.isInputOK(null);
        boolean isDepProductOK = DepProduct_Group.isInputOK(null);
        boolean isDepEnterpriseOK = DepEnterprise_Group.isInputOK(null);
        boolean isDepShipOK = DepShip_Group.isInputOK(null);
        boolean isDepPortOK = DepPort_Group.isInputOK(null);
        boolean isUnloadingLocOK = UnloadingLoc_Group.isInputOK(null);
        boolean isArrDateOK = ArrDate_Group.isInputOK(null);
        boolean isArrTimeOK = ArrTime_Group.isInputOK(null);
        boolean isArrProductOK = ArrProduct_Group.isInputOK(null);
        boolean isArrEnterpriseOK = ArrEnterprise_Group.isInputOK(null);
        boolean isArrShipOK = ArrShip_Group.isInputOK(null);
        boolean isArrPortOK = ArrPort_Group.isInputOK(null);
        boolean isLoadingLocOK = LoadingLoc_Group.isInputOK(null);
        boolean isOthTruckOK = OthTruck_Group.isInputOK(null);
        boolean isOthCompanyOK = OthCompany_Group.isInputOK(null);
        boolean isOthCMROK = OthCMR_Group.isInputOK(null);
        boolean isOthIncomeOK = OthIncome_Group.isInputOK(null);
        boolean isOthKilOK = OthKil_Group.isInputOK(null);
        boolean isOthComOK = true;
        if (OthCom_Group.checkBox.isSelected()){
            isOthComOK = OthCom_Group.isInputOK(null);
        }

        return isDepDateOK &&
               isDepTimeOK &&
               isDepProductOK &&
               isDepEnterpriseOK &&
               isDepShipOK &&
               isDepPortOK &&
               isUnloadingLocOK &&
               isArrDateOK &&
               isArrTimeOK &&
               isArrProductOK &&
               isArrEnterpriseOK &&
               isArrShipOK &&
               isArrPortOK &&
               isLoadingLocOK &&
               isOthTruckOK &&
               isOthCompanyOK &&
               isOthCMROK &&
               isOthIncomeOK &&
               isOthKilOK &&
               isOthComOK;
    }
    private void initMinButtons()
    {
        minAddFieldButton.setOnAction((event -> {
            outNewFieldAnimations();
            outMinFieldButton(minAddFieldButton);
        }));
        minRemoveFieldButton.setOnAction((event -> {
            outRemoveFieldAnimations();
            outMinFieldButton(minRemoveFieldButton);
        }));
    }
    private void inMinFieldButton(JFXButton button)
    {
        button.setVisible(true);
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), event1 ->
        {
            if (button.getLayoutX()>=1274 && button.getLayoutX()<1348)
            {
                button.setLayoutX(button.getLayoutX()+0.108);
            }else if (button.getLayoutX()>=1348)
            {
                button.setLayoutX(1348);
            }
        }));
        fiveSecondsWonder.setCycleCount(500);
        fiveSecondsWonder.play();

        button.setVisible(true);
        Animation.fadeInAnimation(Duration.millis(500), button).play();
    }
    private void outMinFieldButton(JFXButton button)
    {
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), event1 ->
        {
            if (button.getLayoutX()>1274 && button.getLayoutX()<=1348)
            {
                button.setLayoutX(button.getLayoutX()-0.108);
            }else if (button.getLayoutX()<=1274)
            {
                button.setLayoutX(1274);
            }
        }));
        fiveSecondsWonder.setCycleCount(500);
        fiveSecondsWonder.play();

        Animation.fadeOutAnimation(Duration.millis(500), button).play();
        AnimationControls.setVisibleFalseInNewThread(button, 500);
    }
    private void initRemoveField()
    {
        removeFieldButton.setOnAction((event ->
        {
            if(newFieldAnchor.isVisible()){
                outNewFieldAnimations();
                outMinFieldButton(minAddFieldButton);
                inRemoveFieldAnimations();
                inMinFieldButton(minRemoveFieldButton);
            }else if (removeFieldAnchor.isVisible()){
                if (removeField_Group.isInputOK(null))
                {
                    TableColumn<TableData, String> column = new TableColumn<>();
                    for (TableColumn<TableData, String> tableColumn : TableExtraColumns.getColumns()) {
                        if (removeField_Group.getInput().equals(tableColumn.getText())){
                            column = tableColumn;
                            break;
                        }
                    }
                    TableExtraColumns.removeExtraColumn(column);
                    ExtraGroups.remove(removeField_Group.getInput());
                    updateContent();

                    outRemoveFieldAnimations();
                    outMinFieldButton(minRemoveFieldButton);
                    removeField_Group.clearInput();
                    removeField_Group.hideErrorLabel();
                }
            }else{
                inRemoveFieldAnimations();
                inMinFieldButton(minRemoveFieldButton);
            }
        }));
    }
    private void initComboBoxesHashMap(){
        ExtraGroups.loadContent();
        updateContent();

        comboBoxes.clear();
        comboBoxes.put(((ComboBox) ArrProduct_Comp).getPromptText(), ((ComboBox) ArrProduct_Comp));
        comboBoxes.put(((ComboBox) ArrEnterprise_Comp).getPromptText(), ((ComboBox) ArrEnterprise_Comp));
        comboBoxes.put(((ComboBox) ArrShip_Comp).getPromptText(), ((ComboBox) ArrShip_Comp));
        comboBoxes.put(((ComboBox) ArrPort_Comp).getPromptText(), ((ComboBox) ArrPort_Comp));
        comboBoxes.put(((ComboBox) ArrLoadingLoc_Comp).getPromptText(), ((ComboBox) ArrLoadingLoc_Comp));
        comboBoxes.put(((ComboBox) DepProduct_Comp).getPromptText(), ((ComboBox) DepProduct_Comp));
        comboBoxes.put(((ComboBox) DepEnterprise_Comp).getPromptText(), ((ComboBox) DepEnterprise_Comp));
        comboBoxes.put(((ComboBox) DepShip_Comp).getPromptText(), ((ComboBox) DepShip_Comp));
        comboBoxes.put(((ComboBox) DepPort_Comp).getPromptText(), ((ComboBox) DepPort_Comp));
        comboBoxes.put(((ComboBox) DepUnloadingLoc_Comp).getPromptText(), ((ComboBox) DepUnloadingLoc_Comp));
        comboBoxes.put(((ComboBox) OthTruck_Comp).getPromptText(), ((ComboBox) OthTruck_Comp));
        comboBoxes.put(((ComboBox) OthCompany_Comp).getPromptText(), ((ComboBox) OthCompany_Comp));

        for (ExtraGroup extraGroup: ExtraGroups.extraGroups){
            if (extraGroup.getComponentType()==ComponentType.COMBOBOX){
                comboBoxes.put(((ComboBox) extraGroup.getComponent()).getPromptText(), ((ComboBox) extraGroup.getComponent()));
            }
        }
    }
    private void initAddField()
    {
        addFieldButton.setOnAction((event)->
        {
            if (removeFieldAnchor.isVisible()){
                outRemoveFieldAnimations();
                outMinFieldButton(minRemoveFieldButton);
                inNewFieldAnimations();
                inMinFieldButton(minAddFieldButton);
            }else if(newFieldAnchor.isVisible())
            {
                if (newField_Group.isInputOK(null))
                {
                    ComponentType componentType = ComponentType.INFO;
                    if (radioList.isSelected())
                    {
                        componentType = ComponentType.COMBOBOX;
                    }

                    TableExtraColumns.add(newField_Group.getInput(), tableview);
                    ExtraGroups.add(new ExtraGroup(newField_Group.getInput(), componentType));
                    updateContent();

                    radioField.setSelected(true);
                    newField_Group.clearInput();
                    newField_Group.hideErrorLabel();
                    outNewFieldAnimations();
                    outMinFieldButton(minAddFieldButton);
                }
            }else{
                inNewFieldAnimations();
                inMinFieldButton(minAddFieldButton);
            }
        });

        exitMenuButton.setOnMousePressed(event -> UIControls.closeApplication());
    }
    private void updateContent()
    {
        hBox.getChildren().clear();
        hBox.getChildren().add(otherAnchor);
        hBox.getChildren().addAll(ExtraGroups.vBoxes);
    }
    private void inNewFieldAnimations()
    {
        addFieldButton.setText("Add");

        newFieldAnchor.setVisible(true);
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), event1 ->
        {
            if (newFieldAnchor.getLayoutX()>=1088 && newFieldAnchor.getLayoutX()<1327)
            {
                newFieldAnchor.setLayoutX(newFieldAnchor.getLayoutX()+0.4);
            }else if (newFieldAnchor.getLayoutX()>=1327)
            {
                newFieldAnchor.setLayoutX(1327);
            }
            if (newFieldAnchor.getOpacity()<100)
            {
                newFieldAnchor.setOpacity(newFieldAnchor.getOpacity() + 0.002);
            }
        }));
        fiveSecondsWonder.setCycleCount(500);
        fiveSecondsWonder.play();

        arrowNewField.setVisible(true);
        Animation.fadeInAnimation(Duration.millis(500), arrowNewField).play();
        expandWindow(true);
    }
    private void outNewFieldAnimations()
    {
        addFieldButton.setText("New Field");

        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), event1 ->
        {
            if (newFieldAnchor.getLayoutX()>1088 && newFieldAnchor.getLayoutX()<=1327)
            {
                newFieldAnchor.setLayoutX(newFieldAnchor.getLayoutX() - 0.4);
            }else if (newFieldAnchor.getLayoutX()<=1088)
            {
                newFieldAnchor.setLayoutX(1088);
            }
            if (newFieldAnchor.getOpacity()>0)
            {
                newFieldAnchor.setOpacity(newFieldAnchor.getOpacity() - 0.002);
            }
        }));
        fiveSecondsWonder.setCycleCount(500);
        fiveSecondsWonder.play();
        AnimationControls.setVisibleFalseInNewThread(newFieldAnchor, 500);

        Animation.fadeOutAnimation(Duration.millis(500), arrowNewField).play();
        AnimationControls.setVisibleFalseInNewThread(arrowNewField, 500);
        expandWindow(false);
    }

    private void inRemoveFieldAnimations()
    {
        removeFieldButton.setText("Remove");

        removeFieldAnchor.setVisible(true);
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), event1 ->
        {
            if (removeFieldAnchor.getLayoutX()>=1088 && removeFieldAnchor.getLayoutX()<1327)
            {
                removeFieldAnchor.setLayoutX(removeFieldAnchor.getLayoutX()+0.4);
            }else if (removeFieldAnchor.getLayoutX()>=1327)
            {
                removeFieldAnchor.setLayoutX(1327);
            }
            if (removeFieldAnchor.getOpacity()<100)
            {
                removeFieldAnchor.setOpacity(removeFieldAnchor.getOpacity() + 0.002);
            }
        }));
        fiveSecondsWonder.setCycleCount(500);
        fiveSecondsWonder.play();

        arrowRemoveField.setVisible(true);
        Animation.fadeInAnimation(Duration.millis(500), arrowRemoveField).play();
        expandWindow(true);
    }

    private void outRemoveFieldAnimations()
    {
        removeFieldButton.setText("Remove Field");

        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), event1 ->
        {
            if (removeFieldAnchor.getLayoutX()>1088 && removeFieldAnchor.getLayoutX()<=1327)
            {
                removeFieldAnchor.setLayoutX(removeFieldAnchor.getLayoutX() - 0.4);
            }else if (removeFieldAnchor.getLayoutX()<=1088)
            {
                removeFieldAnchor.setLayoutX(1088);
            }
            if (removeFieldAnchor.getOpacity()>0)
            {
                removeFieldAnchor.setOpacity(removeFieldAnchor.getOpacity() - 0.002);
            }
        }));
        fiveSecondsWonder.setCycleCount(500);
        fiveSecondsWonder.play();
        AnimationControls.setVisibleFalseInNewThread(removeFieldAnchor, 500);

        Animation.fadeOutAnimation(Duration.millis(500), arrowRemoveField).play();
        AnimationControls.setVisibleFalseInNewThread(arrowRemoveField, 500);
        expandWindow(false);
    }

    private void initGroup()
    {
        initComponents();

        ArrDate_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.DATEPICKER,
                ArrDate_Comp,
                ArrDate_Error_Label);
        ArrTime_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.TIMEPICKER,
                ArrTime_Comp,
                ArrTime_Error_Label);
        ArrProduct_Group = GroupFactory.createGroup(ArrProduct_Comp,
                ArrProduct_Error_Label,
                ArrProduct_But);
        ArrEnterprise_Group = GroupFactory.createGroup(ArrEnterprise_Comp,
                ArrEnterprise_Error_Label,
                ArrEnterprise_But);
        ArrShip_Group = GroupFactory.createGroup(ArrShip_Comp,
                ArrShip_Error_Label,
                ArrShip_But);
        ArrPort_Group = GroupFactory.createGroup(ArrPort_Comp,
                ArrPort_Error_Label,
                ArrPort_But);
        LoadingLoc_Group = GroupFactory.createGroup(ArrLoadingLoc_Comp,
                ArrLoadingLoc_Error_Label,
                ArrLoadingLoc_But);

        DepDate_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.DATEPICKER,
                DepDate_Comp,
                DepDate_Error_Label);
        DepTime_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.TIMEPICKER,
                DepTime_Comp,
                DepTime_Error_Label);
        DepProduct_Group = GroupFactory.createGroup(DepProduct_Comp,
                DepProduct_Error_Label,
                DepProduct_Butt);
        DepEnterprise_Group = GroupFactory.createGroup(DepEnterprise_Comp,
                DepEnterprise_Error_Label,
                DepEnterprise_But);
        DepShip_Group = GroupFactory.createGroup(DepShip_Comp,
                DepShip_Error_Label,
                DepShip_But);
        DepPort_Group = GroupFactory.createGroup(DepPort_Comp,
                DepPort_Error_Label,
                DepPort_But);
        UnloadingLoc_Group = GroupFactory.createGroup(DepUnloadingLoc_Comp,
                DepUnloadingLoc_Error_Label,
                DepUnloadingLoc_But);

        OthTruck_Group = GroupFactory.createGroup(OthTruck_Comp,
                OthTruck_Error_Label,
                OthTruck_But);
        OthCompany_Group = GroupFactory.createGroup(OthCompany_Comp,
                OthCompany_Error_Label,
                OthCompany_But);
        OthCMR_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.INFO,
                OthCMR_Comp,
                OthCMR_Error_Label);
        OthIncome_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.INFO,
                OthIncome_Comp,
                OthIncome_Error_Label);
        OthKil_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.INFO,
                OthKil_Comp,
                OthKil_Error_Label);
        OthCom_Group = GroupFactory.createGroup(OthCom_Comp,
                OthCom_Error_Label,
                ComCheck);

        newField_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.ADDINFO,
                newField_Comp,
                newField_Error_Label);
        removeField_Group = GroupFactory.createGroup(GroupType.MAINAPP,
                ComponentType.REMOVEINFO,
                removeField_Comp,
                removeField_Error_Label);

        setupConverterDatePicker(DepDate);
        setupConverterDatePicker(ArrDate);

        setupConverterTimePicker(DepTime);
        setupConverterTimePicker(ArrTime);
    }

    private void initComponents()
    {
        initErrorLabels();

        ArrDate_Comp = createComponent(ArrDate);
        ArrTime_Comp = createComponent(ArrTime);
        ArrProduct_Comp = createComponent(ArrProduct);
        ArrEnterprise_Comp = createComponent(ArrEnterprise);
        ArrShip_Comp = createComponent(ArrShip);
        ArrPort_Comp = createComponent(ArrPort);
        ArrLoadingLoc_Comp = createComponent(ArrLoadingLoc);

        DepDate_Comp = createComponent(DepDate);
        DepTime_Comp = createComponent(DepTime);
        DepProduct_Comp = createComponent(DepProduct);
        DepEnterprise_Comp = createComponent(DepEnterprise);
        DepShip_Comp = createComponent(DepShip);
        DepPort_Comp = createComponent(DepPort);
        DepUnloadingLoc_Comp = createComponent(DepUnloadingLoc);

        OthTruck_Comp = createComponent(OthTruck);
        OthCompany_Comp = createComponent(OthCompany);
        OthCMR_Comp = createComponent(OthCMR);
        OthIncome_Comp = createComponent(OthIncome);
        OthKil_Comp = createComponent(OthKil);
        OthCom_Comp = createComponent(OthCom);

        newField_Comp = createComponent(newField_TextField);
        removeField_Comp = createComponent(removeField_TextField);
    }

    private void initErrorLabels()
    {
        ArrDate_Error_Label = new ErrorLabel(ArrDate_Error, ArrDate_ImageError);
        ArrTime_Error_Label = new ErrorLabel(ArrTime_Error, ArrTime_ImageError);
        ArrProduct_Error_Label = new ErrorLabel(ArrProduct_Error, ArrProduct_ImageError);
        ArrEnterprise_Error_Label = new ErrorLabel(ArrEnterprise_Error, ArrEnterprise_ImageError);
        ArrShip_Error_Label = new ErrorLabel(ArrShip_Error, ArrShip_ImageError);
        ArrPort_Error_Label = new ErrorLabel(ArrPort_Error, ArrPort_ImageError);
        ArrLoadingLoc_Error_Label = new ErrorLabel(ArrLoadingLoc_Error, ArrLoadingLoc_ImageError);

        DepDate_Error_Label = new ErrorLabel(DepDate_Error, DepDate_ImageError);
        DepTime_Error_Label = new ErrorLabel(DepTime_Error, DepTime_ImageError);
        DepProduct_Error_Label = new ErrorLabel(DepProduct_Error, DepProduct_ImageError);
        DepEnterprise_Error_Label = new ErrorLabel(DepEnterprise_Error, DepEnterprise_ImageError);
        DepShip_Error_Label = new ErrorLabel(DepShip_Error, DepShip_ImageError);
        DepPort_Error_Label = new ErrorLabel(DepPort_Error, DepPort_ImageError);
        DepUnloadingLoc_Error_Label = new ErrorLabel(DepUnloadingLoc_Error, DepUnloadingLoc_ImageError);

        OthTruck_Error_Label = new ErrorLabel(OthTruck_Error, OthTruck_ImageError);
        OthCompany_Error_Label = new ErrorLabel(OthCompany_Error, OthCompany_ImageError);
        OthCMR_Error_Label = new ErrorLabel(OthCMR_Error, OthCMR_ImageError);
        OthIncome_Error_Label = new ErrorLabel(OthIncome_Error, OthIncome_ImageError);
        OthKil_Error_Label = new ErrorLabel(OthKil_Error, OthKil_ImageError);
        OthCom_Error_Label = new ErrorLabel(OthCom_Error, OthCom_ImageError);

        newField_Error_Label = new ErrorLabel(newField_Error, newField_ImageError);
        removeField_Error_Label = new ErrorLabel(removeField_Error, removeField_ImageError);
    }

    private void expandWindow(boolean expandWindow)
    {
        if (expandWindow)
        {
            Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), event ->
            {
                if (addWin.getPrefWidth()< 1650)
                {
                    addWin.setPrefWidth(addWin.getPrefWidth()+0.4);
                    exitButtonAdd.setLayoutX(exitButtonAdd.getLayoutX()+0.4);
                    minButtonAdd.setLayoutX(minButtonAdd.getLayoutX()+0.4);
                }
            }));
            fiveSecondsWonder.setCycleCount(500);
            fiveSecondsWonder.play();
        }else{
            Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(1), event ->
            {
                if (addWin.getPrefWidth()> 1450)
                {
                    addWin.setPrefWidth(addWin.getPrefWidth()-0.4);
                    exitButtonAdd.setLayoutX(exitButtonAdd.getLayoutX()-0.4);
                    minButtonAdd.setLayoutX(minButtonAdd.getLayoutX()-0.4);
                }
            }));
            fiveSecondsWonder.setCycleCount(500);
            fiveSecondsWonder.play();
        }
    }

    private void setupConverterTimePicker(JFXTimePicker timePicker)
    {
        timePicker.setIs24HourView(true);
        timePicker.setConverter(new StringConverter<LocalTime>()
        {
            @Override
            public String toString(LocalTime time)
            {
                if (time != null)
                {
                    return time.toString();
                } else {
                    return "";
                }
            }

            @Override
            public LocalTime fromString(String string)
            {
                if (string != null && !string.isEmpty())
                {
                    return LocalTime.parse(string);
                } else {
                    return null;
                }
            }
        });
    }
    private void setupConverterDatePicker(JFXDatePicker datePicker)
    {
        datePicker.setConverter(new StringConverter<LocalDate>()
        {
            @Override
            public String toString(LocalDate date)
            {
                if (date != null)
                {
                    return DateConvertion.convertToGreek(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string)
            {
                if (string != null && !string.isEmpty())
                {
                    return LocalDate.parse(string);
                } else {
                    return null;
                }
            }
        });
    }

    private void initializeHashMaps()
    {
        windows.put(userButton, userWin);
        windows.put(tableButton, tableWin);
        windows.put(addButton, addWin);
        windows.put(statButton, statWin);
        windows.put(settButton, settWin);

        oldStyles.put(userButton, userButton.getStyle());
        oldStyles.put(tableButton, tableButton.getStyle());
        oldStyles.put(addButton, addButton.getStyle());
        oldStyles.put(statButton, statButton.getStyle());
        oldStyles.put(settButton, settButton.getStyle());

        newStyles.put(userButton, "-fx-border-width: 4px");
        newStyles.put(tableButton, "-fx-border-width: 0px 0px 0px 5px");
        newStyles.put(addButton, "-fx-border-width: 0px 0px 0px 5px");
        newStyles.put(statButton, "-fx-border-width: 0px 0px 0px 5px");
        newStyles.put(settButton, "-fx-border-width: 4px");

        exitButtons.put(userButton, exitButtonUser);
        exitButtons.put(tableButton, exitButtonTable);
        exitButtons.put(addButton, exitButtonAdd);
        exitButtons.put(statButton, exitButtonStat);
        exitButtons.put(settButton, exitButtonSett);

        minButtons.put(userButton, minButtonUser);
        minButtons.put(tableButton, minButtonTable);
        minButtons.put(addButton, minButtonAdd);
        minButtons.put(statButton, minButtonStat);
        minButtons.put(settButton, minButtonSett);
    }
    private void menuButtonsSwitchSetup()
    {
        for(AnchorPane menuButton : windows.keySet())
        {
            setupListenersForButton(menuButton);
        }
    }
    private void setupListenersForButton(AnchorPane menuButton)
    {
        UIControls.styleOnMouseHover(menuButton, newStyles.get(menuButton));
        menuButton.setOnMouseExited(event ->
        {
            if (activeButton != menuButton)
            {
                menuButton.setStyle(oldStyles.get(menuButton));
            }
        });

        menuButton.setOnMousePressed(event ->
        {
            if (editingRow) {
                Dialog dialog = new Dialog(mainApp_Stack,
                        "You are editing a row! Are you sure you want to stop editing?\n" +
                                "By selecting YES you will stop editing the row and no change will \n" +
                                "happen to that row." +
                                "\n If you select NO or click outside of this dialog you will continue\n editing the row...",
                        "YES",
                        "NO",
                        "Core/Scenes/App/StyleSheet.css",
                        "dialogButton",
                        mainMenu_Anchor, addWin, tableWin);
                dialog.getButton().setOnAction(event1 -> {
                    int newPositionOfArrow = (int) (menuButton.getLayoutY() + event.getY() + 13);

                    if (activeWin != windows.get(menuButton)) {
                        if (activeWin != null) {
                            activeButton.setStyle(oldStyles.get(menuButton));

                            AnimationControls.hideAndShowWithAnimationInDuration(activeWin, windows.get(menuButton), Duration.millis(500));
                        } else {
                            Animation.fadeInAnimation(Duration.millis(500), windows.get(menuButton)).play();
                        }
                    }
                    createAndRunDriftAnimation(newPositionOfArrow);

                    activeWin = windows.get(menuButton);
                    activeButton = menuButton;

                    menuButton.setStyle(newStyles.get(menuButton));
                    windows.get(menuButton).setVisible(true);

                    editingRowLabel.setVisible(false);
                    editingRow = false;
                    dialog.close();
                });
                dialog.getNoButton().setOnAction(event1 -> dialog.close());
            }else {
                int newPositionOfArrow = (int) (menuButton.getLayoutY() + event.getY() + 13);

                if (activeWin != windows.get(menuButton)) {
                    if (activeWin != null) {
                        activeButton.setStyle(oldStyles.get(menuButton));

                        AnimationControls.hideAndShowWithAnimationInDuration(activeWin, windows.get(menuButton), Duration.millis(500));
                    } else {
                        Animation.fadeInAnimation(Duration.millis(500), windows.get(menuButton)).play();
                    }
                }
                createAndRunDriftAnimation(newPositionOfArrow);

                activeWin = windows.get(menuButton);
                activeButton = menuButton;

                menuButton.setStyle(newStyles.get(menuButton));
                windows.get(menuButton).setVisible(true);
            }
        });
    }
    private void createAndRunDriftAnimation(int newPositionOfArrow)
    {
        if (!loadData){
            initColumnArray();
            //initColumnWidthListener();
            //ColumnWidths.load(columns);
            TableDatas.load(tableview);
            ComboDatas.load(comboBoxes);
            loadData = true;
        }
        Range windowRange = new Range(0,725);
        Range animationOffsetRange = new Range(1,30);

        int animationPositionOfArrow;
        int valueToOffset = (int) (newPositionOfArrow - arrow.getTranslateY());

        animationPositionOfArrow = (int) (newPositionOfArrow + windowRange.map(valueToOffset, animationOffsetRange));

        SequentialTransition driftAnimation = Animation.driftAnimation(
                Animation.translateAnimationToY(Duration.millis(500), arrow, animationPositionOfArrow),
                newPositionOfArrow);

        driftAnimation.play();
    }

    private void minExitButtonsListeners()
    {
        for (AnchorPane menuButton: exitButtons.keySet())
        {
            exitButtonsListeners(menuButton);
            minButtonsListeners(menuButton);
        }
    }
    private void exitButtonsListeners(AnchorPane menuButton)
    {
        exitButtons.get(menuButton).setOnMousePressed(event ->
        {
            Animation.fadeOutAnimation(Duration.millis(500), windows.get(menuButton)).play();
            AnimationControls.setVisibleFalseInNewThread(windows.get(menuButton), 500);

            Animation.translateAnimationToY(Duration.millis(500), arrow, 0).play();

            if (activeButton != null)
            {
                menuButton.setStyle(oldStyles.get(menuButton));
            }

            activeWin = null;
            activeButton = null;
        });
    }
    private void minButtonsListeners(AnchorPane menuButton)
    {
        minButtons.get(menuButton).setOnMousePressed(event -> UIControls.minimizeApplication());
    }

    private void initScrollBar()
    {
        otherScrollPane.setContent(hBox);
        hBox.getChildren().add(otherAnchor);
        hBox.setSpacing(56);
    }

    private void setStatInfo(SortedMap<String, ArrayList<TableData>> correspondingData){
        double cmrSum = 0;
        double incomeSum = 0;
        double kilometersSum = 0;
        ArrayList<String> trucks = new ArrayList<>();
        for (String year : correspondingData.keySet()) {
            for (TableData data : correspondingData.get(year)) {
                cmrSum += Double.valueOf(data.getCmr());
                incomeSum += Double.valueOf(data.getIncome());
                kilometersSum += Double.valueOf(data.getKilometers());
                if (!trucks.contains(data.getTruck())){
                    trucks.add(data.getTruck());
                }
            }
        }

        tripsLabel.setText(tableview.getItems().size()+"");
        cmrLabel.setText(cmrSum+"");
        incomeLabel.setText(incomeSum+"");
        kilometersLabel.setText(kilometersSum+"");
        trucksLabel.setText(trucks.size()+"");
    }

}
