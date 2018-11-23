package Core.Components;

import com.jfoenix.controls.*;
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
        } else if (node instanceof JFXDatePicker){
            component = new DatePicker((JFXDatePicker) node);
        } else if (node instanceof JFXTimePicker){
            component = new TimePicker((JFXTimePicker) node);
        } else if (node instanceof JFXTextArea){
            component = new TextArea((JFXTextArea) node);
        }

        return component;
    }
}
