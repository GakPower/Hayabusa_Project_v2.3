package Core.Components;

import Core.DayConvertion.DateConvertion;
import com.jfoenix.controls.JFXDatePicker;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;

public class DatePicker extends Node implements Component {

    private JFXDatePicker datePicker;

    public DatePicker(JFXDatePicker datePicker)
    {
        this.datePicker = datePicker;
    }

    @Override
    public String getText() {
        return DateConvertion.convert(datePicker.getValue());
    }

    @Override
    public void clearInput() {
        datePicker.getEditor().setText("");
    }

    @Override
    public void setText(String newText) {
        datePicker.getEditor().setText(newText);
    }

    @Override
    public void setdisable(boolean disable) {
        datePicker.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return datePicker.getEditor().getText() == null || datePicker.getEditor().getText().isEmpty();
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
