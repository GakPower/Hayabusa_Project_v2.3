package Core.Scenes;

import Core.Main;
import javafx.application.Platform;
import javafx.scene.Node;

public class UIControls {

    public static void closeApplication(){
        Platform.exit();
    }
    public static void minimizeApplication(){
        Main.stage.setIconified(true);
    }

    public static void styleOnMouseHover(Node node, String newStyle)
    {
        String oldStyle = node.getStyle();

        node.setOnMouseEntered(event -> node.setStyle(newStyle));
        node.setOnMouseExited(event -> node.setStyle(oldStyle));
    }
}
