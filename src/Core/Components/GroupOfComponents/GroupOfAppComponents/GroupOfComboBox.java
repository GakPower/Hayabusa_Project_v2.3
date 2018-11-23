package Core.Components.GroupOfComponents.GroupOfAppComponents;

import Core.Components.ComboBox;
import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import com.jfoenix.controls.JFXButton;

public class GroupOfComboBox extends GroupOfComponents {
    public GroupOfComboBox(Component component, ErrorLabel errorLabel, JFXButton button) {
        super(component, errorLabel, button);
        button.setOnAction((event)-> initComboBox());
    }

    private void initComboBox(){
        ComboBox comboBox = (ComboBox)component;
        if (!comboBox.getItems().isEmpty()){
            comboBox.getItems().remove(0);
        }
    }
}
