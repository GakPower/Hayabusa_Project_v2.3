package Core.Animations;
//
// Author: GakPower
// 
// Date: 22-Jun-2018 (9:24 PM)
//

import javafx.scene.Node;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimationControls {
    public static void translateAndFadeOutInDuration(Node toHide, double toX, Duration inDuration){
        Animation.translateAnimation(inDuration, toHide, toX).play();
        Animation.fadeOutAnimation(inDuration, toHide).play();
        setVisibleFalseInNewThread(toHide, (int) inDuration.toMillis());
    }
    public static void hideAndShowWithAnimationInDuration(Node toHide, Node toShow, Duration inDuration){
        Animation.fadeOutAnimation(inDuration, toHide).play();
        Animation.fadeInAnimation(inDuration, toShow).play();

        setVisibleFalseInNewThread(toHide, (int) inDuration.toMillis());
        toShow.setVisible(true);
    }
    private static  void setVisibleFalseInNewThread(Node node, int DurationInt){
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable hideNode = () -> node.setVisible(false);
        scheduler.schedule(hideNode, DurationInt, TimeUnit.MILLISECONDS);
        scheduler.shutdown();
    }
}
