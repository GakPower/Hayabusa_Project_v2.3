package Core.Components.GroupOfComponents;
//
// Author: GakPower
// 
// Date: 22-Jun-2018 (9:43 PM)
//

import Core.Animations.Animation;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sun.java2d.loops.CustomComponent;

import javax.swing.plaf.synth.Region;

import static Core.Animations.Animation.translateAnimationToY;

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