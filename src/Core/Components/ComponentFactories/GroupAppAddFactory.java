package Core.Components.ComponentFactories;

import Core.Components.Component;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfAppComponents.*;
import Core.Components.GroupOfComponents.GroupOfComponents;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;


public interface GroupAppAddFactory {

    static GroupOfComponents createGroup(ComponentType type,
                                          Component component,
                                          ErrorLabel errorLabel) {
        GroupOfComponents groupOfComponents = null;
        switch (type) {
            case DATEPICKER:
                groupOfComponents = new GroupOfDatePicker(component, errorLabel);
                break;
            case TIMEPICKER:
                groupOfComponents = new GroupOfTimePicker(component, errorLabel);
                break;
            case INFO:
                groupOfComponents = new GroupOfInfo(component, errorLabel);
                break;
        }
        return groupOfComponents;
    }

    static GroupOfComponents createGroup(Component component,
                                         ErrorLabel errorLabel,
                                         JFXButton button) {
        return new GroupOfComboBox(component, errorLabel, button);
    }

    static GroupOfComponents createGroup(Component component,
                                         ErrorLabel errorLabel,
                                         JFXCheckBox checkBox) {
        return new GroupOfTextArea(component, errorLabel, checkBox);
    }

}
