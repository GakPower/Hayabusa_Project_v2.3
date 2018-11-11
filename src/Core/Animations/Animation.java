package Core.Animations;

//
// Author: GakPower
// 
// Date: 17-Jun-2018 (5:21 PM)
//

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
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

    public static TranslateTransition translateAnimationToX(Duration duration, Node node, double ToX){
        TranslateTransition translateTransition = new TranslateTransition(duration, node);
        translateTransition.setToX(ToX);

        return translateTransition;
    }

    public static TranslateTransition translateAnimationToY(Duration duration, Node node, double ToY){
        TranslateTransition translateTransition = new TranslateTransition(duration, node);
        translateTransition.setToY(ToY);

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

    public static SequentialTransition bounceAnimation(double durationInMilliseconds, Node node){
        double y = node.getTranslateY();

        SequentialTransition sequentialTransition = new SequentialTransition(
                translateAnimationToY(Duration.millis(0.23*durationInMilliseconds), node, y - 15),
                translateAnimationToY(Duration.millis(0.1*durationInMilliseconds), node, y),
                translateAnimationToY(Duration.millis(0.17*durationInMilliseconds), node, y - 8),
                translateAnimationToY(Duration.millis(0.133*durationInMilliseconds), node, y),
                translateAnimationToY(Duration.millis(0.133*durationInMilliseconds), node, y - 2),
                translateAnimationToY(Duration.millis(0.133*durationInMilliseconds), node, y)
        );
        sequentialTransition.setDelay(Duration.millis(0.1*durationInMilliseconds));

        return sequentialTransition;
    }

    public static SequentialTransition driftAnimation(TranslateTransition translateTransition, double ToY)
    {

        Duration driftDuration = Duration.millis(translateTransition.getDuration().toMillis()*0.4);
        Node node = translateTransition.getNode();

        TranslateTransition driftTransition = Animation.translateAnimationToY(driftDuration,node,ToY);

        SequentialTransition sequentialTransition = new SequentialTransition(
                translateTransition, driftTransition);

        return sequentialTransition;
    }
}
