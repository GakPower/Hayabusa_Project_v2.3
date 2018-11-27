package Core.Components;

import com.jfoenix.controls.JFXTextArea;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;

public class TextArea extends Node implements Component {

    private JFXTextArea textArea;

    public TextArea(JFXTextArea textArea)
    {
        this.textArea = textArea;
    }

    @Override
    public String getText() {
        return textArea.getText();
    }

    @Override
    public void clearInput() {
        textArea.clear();
    }

    @Override
    public void setText(String newText) {
        textArea.setText(newText);
    }

    @Override
    public void setdisable(boolean disable) {
        textArea.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return textArea.getText() == null || textArea.getText().isEmpty();
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
