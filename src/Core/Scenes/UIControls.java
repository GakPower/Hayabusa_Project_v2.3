package Core.Scenes;

import Core.Main;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.scene.input.MouseEvent;

public class UIControls {

    public static void closeApplication(){
        Platform.exit();
    }
    public static void minimizeApplication(){
        Main.stage.setIconified(true);
    }

    public static void changeOnMouseHover(MouseEvent mouseEvent, String ButtStyle){
        JFXButton jfxButton = (JFXButton) mouseEvent.getTarget();
        jfxButton.setStyle(ButtStyle);
    }
}
