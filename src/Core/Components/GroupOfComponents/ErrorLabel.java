package Core.Components.GroupOfComponents;
//
// Author: GakPower
// 
// Date: 22-Jun-2018 (9:43 PM)
//

import Core.Animations.Animation;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class ErrorLabel {
    private Label label;
    private ImageView image;
    private Tooltip tooltip;

    public ErrorLabel(Label label, ImageView image) {
        this.label = label;
        this.image = image;
        configureTooltip();
        addToolTipToLabel();
    }

    private void configureTooltip() {
        tooltip = new Tooltip();
        tooltip.setWrapText(true);
    }
    private void addToolTipToLabel() {
        label.setTooltip(tooltip);
    }

    public void show() {
        Animation.bounceAnimation(1000, image).play();
        label.setVisible(true);
        image.setVisible(true);
    }

    public void hide() {
        label.setVisible(false);
        image.setVisible(false);
    }

    public void setTooltipText(String newText) {
        tooltip.setText(newText);
    }

    public String getTooltipText() {
        return tooltip.getText() == null ? "" : tooltip.getText();
    }
}