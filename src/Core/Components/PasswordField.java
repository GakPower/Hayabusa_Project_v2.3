package Core.Components;

import com.jfoenix.controls.JFXPasswordField;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;

public class PasswordField extends Node implements Component {

    private JFXPasswordField passwordField;

    public PasswordField(JFXPasswordField passwordField){
        this.passwordField = passwordField;
    }

    @Override
    public String getText() {
        return passwordField.getText();
    }

    @Override
    public void clearInput() {
        passwordField.clear();
    }

    @Override
    public void setText(String newText) {}

    @Override
    public void setdisable(boolean disable) {
        passwordField.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return passwordField.getText() == null || passwordField.getText().isEmpty();
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
