package Core.Components;

import com.jfoenix.controls.JFXTimePicker;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;

public class TimePicker extends Node implements Component {

    private JFXTimePicker timepicker;

    public TimePicker(JFXTimePicker timePicker)
    {
        this.timepicker = timePicker;
    }

    @Override
    public String getText() {
        return timepicker.getValue().toString();
    }

    @Override
    public void clearInput() {
        timepicker.getEditor().setText("");
    }

    @Override
    public void setText(String newText) {
        timepicker.getEditor().setText(newText);
    }

    @Override
    public void setdisable(boolean disable) {
        timepicker.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return timepicker.getEditor().getText() == null || timepicker.getEditor().getText().isEmpty();
    }

    @Override
    protected NGNode impl_createPeer() {
        return null;
    }

    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        return null;
    }

    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        return false;
    }

    @Override
    public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return null;
    }
}
