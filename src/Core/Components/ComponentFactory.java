package Core.Components;

import Core.torubbish.ComboBox;
import Core.torubbish.Component;
import Core.torubbish.PasswordField;
import Core.torubbish.TextField;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Node;

public interface ComponentFactory {

    static Component createComponent(Node node) {

        Component component = null;
        if (node instanceof JFXTextField){
            component = new TextField((JFXTextField) node);
        } else if (node instanceof JFXPasswordField){
            component = new PasswordField((JFXPasswordField) node);
        } else if (node instanceof JFXComboBox){
            component = new ComboBox((JFXComboBox) node);
        }

        return component;
    }
}
