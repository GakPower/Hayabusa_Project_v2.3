package Core.Animations;

//
// Author: GakPower
// 
// Date: 17-Jun-2018 (5:21 PM)
//

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animation {


    public static ScaleTransition scaleAnimation(Duration duration, Node node, double scaleXTo, double scaleYTo){
        ScaleTransition scaleTransition = new ScaleTransition(duration, node);
        scaleTransition.setToX(scaleXTo);
        scaleTransition.setToY(scaleYTo);

        return scaleTransition;
    }
    public static ScaleTransition scaleAnimationToX(Duration duration, Node node, double scaleXTo){
        ScaleTransition scaleTransition = new ScaleTransition(duration, node);
        scaleTransition.setToX(scaleXTo);

        return scaleTransition;
    }
    public static ScaleTransition scaleAnimationToY(Duration duration, Node node, double scaleYTo){
        ScaleTransition scaleTransition = new ScaleTransition(duration, node);
        scaleTransition.setToY(scaleYTo);

        return scaleTransition;
    }

    public static TranslateTransition translateAnimation(Duration duration, Node node, double ToX){
        TranslateTransition translateTransition = new TranslateTransition(duration, node);
        translateTransition.setToX(ToX);

        return translateTransition;
    }

    public static FadeTransition fadeOutAnimation(Duration duration, Node node){
        FadeTransition fadeOut = new FadeTransition(duration, node);
        fadeOut.setFromValue(100);
        fadeOut.setToValue(0);

        return fadeOut;
    }
    public static FadeTransition fadeInAnimation(Duration duration, Node node){
        FadeTransition fadeIn = new FadeTransition(duration, node);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(100);

        return fadeIn;
    }
}
