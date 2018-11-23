package Core.Components;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class MinusButton extends JFXButton {
    public MinusButton(){
        super("", new ImageView("Core/Scenes/Assets/Minus.png"));
        this.getStyleClass().add("minusButton");
        this.setRipplerFill(Color.WHITE);
        this.setPrefSize(40,32);
    }
}
