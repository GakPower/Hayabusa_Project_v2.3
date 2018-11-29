package Core.Scenes.App;
//
// Author: GakPower
// 
// Date: 14-Jun-2018 (12:01 AM)
//

import Core.Animations.Animation;
import Core.Animations.AnimationControls;
import Core.Components.Component;
import Core.Components.ComponentFactories.GroupFactory;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.Components.GroupOfComponents.GroupType;
import Core.DayConvertion.DateConvertion;
import Core.ExtraFields.ExtraGroup;
import Core.ExtraFields.ExtraGroups;
import Core.Range;
import Core.Scenes.UIControls;
import Core.TableData;
import com.jfoenix.controls.*;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import static Core.Components.ComponentFactory.createComponent;

@SuppressWarnings("Duplicates")
public class AppController {

    @FXML private TableView<TableData> tableview;
    @FXML private JFXScrollPane tablescroll;

    @FXML private TableColumn<Object, Object> id;
    @FXML private TableColumn<Object, Object> departureDate;
    @FXML private TableColumn departureTime;
    @FXML private TableColumn exportationProduct;
    @FXML private TableColumn departureEnterprise;
    @FXML private TableColumn departureShip;
    @FXML private TableColumn departurePort;
    @FXML private TableColumn unloadingLocations;
    @FXML private TableColumn arrivalDate;
    @FXML private TableColumn arrivalTime;
    @FXML private TableColumn importationProduct;
    @FXML private TableColumn arrivalEnterprise;
    @FXML private TableColumn arrivalShip;
    @FXML private TableColumn arrivalPort;
    @FXML private TableColumn loadingLocations;
    @FXML private TableColumn truck;
    @FXML private TableColumn company;
    @FXML private TableColumn cmr;
    @FXML private TableColumn income;
    @FXML private TableColumn kilometers;
    @FXML private TableColumn comments;

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
    @FXML private ScrollPane otherScrollPane;
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
    private GroupOfComponents ArrLoadingLoc_Group;

    private GroupOfComponents DepDate_Group;
    private GroupOfComponents DepTime_Group;
    private GroupOfComponents DepProduct_Group;
    private GroupOfComponents DepEnterprise_Group;
    private GroupOfComponents DepShip_Group;
    private GroupOfComponents DepPort_Group;
    private GroupOfComponents DepUnloadingLoc_Group;

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

    @FXML private void initialize()
    {
        initializeHashMaps();
        menuButtonsSwitchSetup();
        minExitButtonsListeners();

        initScrollBar();

        initErrorLabels();
        initComponents();
        initGroup();

        initAddField();
        initRemoveField();
        initMinButtons();

        departureDate.setCellValueFactory(new PropertyValueFactory<>("depDate"));

        ArrayList<String> arrayList = new ArrayList<>();
        saveButton.setOnAction((event -> {
            if (
                    ArrDate_Group.isInputOK(null) &&
                    ArrTime_Group.isInputOK(null) &&
                    ArrProduct_Group.isInputOK(null) &&
                    ArrEnterprise_Group.isInputOK(null) &&
                    ArrShip_Group.isInputOK(null) &&
                    ArrPort_Group.isInputOK(null) &&
                    ArrLoadingLoc_Group.isInputOK(null) &&
                    DepDate_Group.isInputOK(null) &&
                    DepTime_Group.isInputOK(null) &&
                    DepProduct_Group.isInputOK(null) &&
                    DepEnterprise_Group.isInputOK(null) &&
                    DepShip_Group.isInputOK(null) &&
                    DepPort_Group.isInputOK(null) &&
                    DepUnloadingLoc_Group.isInputOK(null) &&
                    OthTruck_Group.isInputOK(null) &&
                    OthCompany_Group.isInputOK(null) &&
                    OthCMR_Group.isInputOK(null) &&
                    OthIncome_Group.isInputOK(null) &&
                    OthKil_Group.isInputOK(null) &&
                    OthCom_Group.isInputOK(null)){
                arrayList.add(ArrDate_Group.getInput());
                arrayList.add(ArrTime_Group.getInput());
                arrayList.add(ArrProduct_Group.getInput());
                arrayList.add(ArrEnterprise_Group.getInput());
                arrayList.add(ArrShip_Group.getInput());
                arrayList.add(ArrPort_Group.getInput());
                arrayList.add(ArrLoadingLoc_Group.getInput());
                arrayList.add(DepDate_Group.getInput());
                arrayList.add(DepTime_Group.getInput());
                arrayList.add(DepProduct_Group.getInput());
                arrayList.add(DepEnterprise_Group.getInput());
                arrayList.add(DepShip_Group.getInput());
                arrayList.add(DepPort_Group.getInput());
                arrayList.add(DepUnloadingLoc_Group.getInput());
                arrayList.add(OthTruck_Group.getInput());
                arrayList.add(OthCompany_Group.getInput());
                arrayList.add(OthCMR_Group.getInput());
                arrayList.add(OthIncome_Group.getInput());
                arrayList.add(OthKil_Group.getInput());
                arrayList.add(OthCom_Group.getInput());

                ArrayList<String> str = new ArrayList<>();
                str.add("");
                tableview.getItems().add(new TableData(arrayList, str));
            }
        }));

        //tablescroll

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
                    ExtraGroups.remove(removeField_Group.getInput());
                    updateContent();
                    removeField_Group.clearInput();
                    removeField_Group.hideErrorLabel();
                    outRemoveFieldAnimations();
                    outMinFieldButton(minRemoveFieldButton);
                }
            }else{
                inRemoveFieldAnimations();
                inMinFieldButton(minRemoveFieldButton);
            }
        }));
    }
    private void initAddField()
    {
        ExtraGroups.loadContent();
        updateContent();

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
        ArrLoadingLoc_Group = GroupFactory.createGroup(ArrLoadingLoc_Comp,
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
        DepUnloadingLoc_Group = GroupFactory.createGroup(DepUnloadingLoc_Comp,
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
                    return DateConvertion.convert(date);
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
            int newPositionOfArrow = (int) (menuButton.getLayoutY()+event.getY()+13);

            if (activeWin != windows.get(menuButton))
            {
                if (activeWin != null)
                {
                    activeButton.setStyle(oldStyles.get(menuButton));

                    AnimationControls.hideAndShowWithAnimationInDuration(activeWin, windows.get(menuButton), Duration.millis(500));
                }else{
                    Animation.fadeInAnimation(Duration.millis(500), windows.get(menuButton)).play();
                }
            }
            createAndRunDriftAnimation(newPositionOfArrow);

            activeWin = windows.get(menuButton);
            activeButton = menuButton;

            menuButton.setStyle(newStyles.get(menuButton));
            windows.get(menuButton).setVisible(true);
        });
    }
    private void createAndRunDriftAnimation(int newPositionOfArrow)
    {
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
        otherScrollPane.setPannable(true);
        otherScrollPane.setVmax(0);
        hBox.getChildren().add(otherAnchor);
        hBox.setSpacing(56);
        HBox.setHgrow(otherScrollPane, Priority.ALWAYS);
    }
}
