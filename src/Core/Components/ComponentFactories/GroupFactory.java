package Core.Components.ComponentFactories;

import Core.Components.Component;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.Components.GroupOfComponents.GroupType;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

public interface GroupFactory {

    static GroupOfComponents createGroup(GroupType groupType,
                                         ComponentType componentType,
                                         Component component,
                                         ErrorLabel errorLabel) {

        GroupOfComponents groupOfComponents = null;
        switch (groupType){
            case LOGIN:
            groupOfComponents = GroupLoginFactory.createGroup(componentType,
                        component, errorLabel);
                break;
            case SIGNUP:
                groupOfComponents = GroupSignUpFactory.createGroup(componentType,
                        component, errorLabel);
                break;
            case FORGETPASS:
                groupOfComponents = GroupForgetFactory.createGroup(componentType,
                        component, errorLabel);
                break;
            case MAINAPP:
                groupOfComponents = GroupAppAddFactory.createGroup(componentType,
                        component, errorLabel);
        }

        return groupOfComponents;
    }

    static GroupOfComponents createGroup(Component component,
                                         ErrorLabel errorLabel,
                                         JFXButton button) {
        return GroupAppAddFactory.createGroup(component, errorLabel, button);
    }

    static GroupOfComponents createGroup(Component component,
                                         ErrorLabel errorLabel,
                                         JFXCheckBox checkBox) {
        return GroupAppAddFactory.createGroup(component, errorLabel, checkBox);
    }
}
