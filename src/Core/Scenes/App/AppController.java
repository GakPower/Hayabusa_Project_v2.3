package Core.Scenes.App;
//
// Author: GakPower
// 
// Date: 14-Jun-2018 (12:01 AM)
//

import Core.Scenes.UIControls;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AppController {

    @FXML private Label name;

    @FXML private AnchorPane userWin;
    @FXML private AnchorPane tableWin;
    @FXML private AnchorPane addWin;
    @FXML private AnchorPane statWin;
    @FXML private AnchorPane settWin;

    @FXML private AnchorPane userButt;
    @FXML private AnchorPane tableButt;
    @FXML private AnchorPane addButt;
    @FXML private AnchorPane statButt;
    @FXML private AnchorPane settButt;

    @FXML private ImageView NameIcon;
    @FXML private ImageView TableIcon;
    @FXML private ImageView AddIcon;
    @FXML private ImageView StatIcon;
    @FXML private ImageView SettingsIcon;
    @FXML private JFXButton OthTruck_But;
    @FXML private JFXButton OthCompany_But;
    @FXML private JFXButton exitButStat;

    @FXML private ImageView userArrow;
    @FXML private ImageView tableArrow;
    @FXML private ImageView addArrow;
    @FXML private ImageView statArrow;
    @FXML private ImageView settArrow;

    @FXML private JFXButton exitButUser;
    @FXML private JFXButton exitButTable;
    @FXML private JFXButton exitButAdd;
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

    @FXML private JFXButton exitButSett;

    private AnchorPane activeWin;
    private ImageView activeArrow;

    @FXML private void initialize()
    {
        UIControls.styleOnMouseHover(userButt, "-fx-border-width: 4px");
        UIControls.styleOnMouseHover(tableButt, "-fx-border-width: 0px 0px 0px 5px");
        UIControls.styleOnMouseHover(addButt, "-fx-border-width: 0px 0px 0px 5px");
        UIControls.styleOnMouseHover(statButt, "-fx-border-width: 0px 0px 0px 5px");
        UIControls.styleOnMouseHover(settButt, "-fx-border-width: 4px");

        activateWindow();
    }

    private void activateWindow()
    {
        userButt.setOnMousePressed(event ->{
            if (activeWin != null){
                activeWin.setVisible(false);
                activeArrow.setVisible(false);
            }

            userWin.setVisible(true);
            userArrow.setVisible(true);
            activeWin = userWin;
            activeArrow = userArrow;
        });

        tableButt.setOnMousePressed(event -> {
            if (activeWin != null){
                activeWin.setVisible(false);
                activeArrow.setVisible(false);
            }

            tableWin.setVisible(true);
            tableArrow.setVisible(true);
            activeWin = tableWin;
            activeArrow = tableArrow;
        });
    }

}
