package Core.Components;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class MinusButton extends JFXButton implements Serializable {
    public MinusButton(){
        super("");
        super.setGraphic(createImageView());
        this.getStyleClass().add("minusButton");
        this.setRipplerFill(Color.WHITE);
        this.setPrefSize(40, 32);
    }

    @SuppressWarnings("Duplicates")
    private ImageView createImageView(){

        ImageView imageView = new ImageView("Core/Scenes/Assets/Minus.png");
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        return imageView;
    }
}
