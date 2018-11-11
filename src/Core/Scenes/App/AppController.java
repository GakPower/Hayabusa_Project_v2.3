package Core.Scenes.App;
//
// Author: GakPower
// 
// Date: 14-Jun-2018 (12:01 AM)
//

import Core.Animations.Animation;
import Core.Animations.AnimationControls;
import Core.Range;
import Core.Scenes.UIControls;
import com.jfoenix.controls.*;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.HashMap;

public class AppController {

    @FXML private Label name;

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

    @FXML private ImageView NameIcon;
    @FXML private ImageView TableIcon;
    @FXML private ImageView AddIcon;
    @FXML private ImageView StatIcon;
    @FXML private ImageView SettingsIcon;
    @FXML private JFXButton OthTruck_But;
    @FXML private JFXButton OthCompany_But;


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


    @FXML private JFXDatePicker DepDate;
    @FXML private JFXTimePicker DepTime;

    @FXML private JFXComboBox DepProduct;
    @FXML private JFXComboBox DepEnterprise;
    @FXML private JFXComboBox DepShip;
    @FXML private JFXComboBox DepPort;
    @FXML private JFXComboBox DepUnloadingLoc;

    @FXML private Label DepProduct_Error;
    @FXML private Label DepEnterprise_Error;
    @FXML private Label DepShip_Error;
    @FXML private Label DepPort_Error;
    @FXML private Label DepUnloadingLoc_Error;

    @FXML private ImageView DepProduct_ImageError;
    @FXML private ImageView DepEnterprise_ImageError;
    @FXML private ImageView DepShip_ImageError;
    @FXML private ImageView DepPort_ImageError;
    @FXML private ImageView DepUnloadingLoc_ImageError;

    @FXML private JFXButton DepProduct_Butt;
    @FXML private JFXButton DepEnterpise_But;
    @FXML private JFXButton DepShip_But;
    @FXML private JFXButton DepPort_But;
    @FXML private JFXButton DepUnloadingLoc_But;

    @FXML private JFXDatePicker ArrDate;
    @FXML private JFXTimePicker ArrTime;
    @FXML private JFXComboBox ArrProduct;
    @FXML private JFXComboBox ArrEnterprise;
    @FXML private JFXComboBox ArrShip;
    @FXML private JFXComboBox ArrPort;
    @FXML private JFXComboBox ArrLoadingLoc;

    @FXML private Label ArrProduct_Error;
    @FXML private Label ArrEnterprise_Error;
    @FXML private Label ArrShip_Error;
    @FXML private Label ArrPort_Error;
    @FXML private Label ArrLoadingLoc_Error;

    @FXML private ImageView ArrProduct_ImageError;
    @FXML private ImageView ArrEnterprise_ImageError;
    @FXML private ImageView ArrShip_ImageError;
    @FXML private ImageView ArrPort_ImageError;
    @FXML private ImageView ArrLoadingLoc_ImageError;

    @FXML private JFXButton ArrProduct_But;
    @FXML private JFXButton ArrEnterprise_But;
    @FXML private JFXButton ArrShip_But;
    @FXML private JFXButton ArrPort_But;
    @FXML private JFXButton ArrLoadingLoc_But;

    @FXML private JFXComboBox OthTruck;
    @FXML private JFXComboBox OthCompany;
    @FXML private JFXTextField OthCMR;
    @FXML private JFXTextField OthIncome;
    @FXML private JFXTextField OthKil;
    @FXML private JFXTextArea OthCom;

    @FXML private Label OthTruck_Error;
    @FXML private Label OthCompany_Error;
    @FXML private Label OthCMR_Error;
    @FXML private Label OthIncome_Error;
    @FXML private Label OthKil_Error;
    @FXML private Label OthCom_Error;

    @FXML private ImageView OthTruck_ImageError;
    @FXML private ImageView OthCompany_ImageError;
    @FXML private ImageView OthCMR_ImageError;
    @FXML private ImageView OthIncome_ImageError;
    @FXML private ImageView OthKil_ImageError;
    @FXML private ImageView OthCom_ImageError;

    @FXML private JFXCheckBox ComCheck;


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
                    System.out.println("1");
                }else{
                    Animation.fadeInAnimation(Duration.millis(500), windows.get(menuButton)).play();
                    System.out.println("2");
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
}
