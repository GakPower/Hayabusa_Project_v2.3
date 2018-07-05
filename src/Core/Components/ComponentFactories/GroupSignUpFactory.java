package Core.Components.ComponentFactories;

import Core.Components.Component;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.Components.GroupOfComponents.GroupOfConfirmPassword;
import Core.Components.GroupOfComponents.GroupOfSignUpComponents.GroupOfSignUpComboBox;
import Core.Components.GroupOfComponents.GroupOfSignUpComponents.GroupOfSignUpInfo;
import Core.Components.GroupOfComponents.GroupOfSignUpComponents.GroupOfSignUpPassword;
import Core.Components.GroupOfComponents.GroupOfSignUpComponents.GroupOfSignUpUsername;

public interface GroupSignUpFactory {

    static GroupOfComponents createGroup(ComponentType type, Component component, ErrorLabel errorLabel) {
        GroupOfComponents groupOfComponents = null;
        switch(type) {
            case USERNAME:
                groupOfComponents = new GroupOfSignUpUsername(component, errorLabel);
                break;
            case PASSWORD:
                groupOfComponents = new GroupOfSignUpPassword(component, errorLabel);
                break;
            case CONFIRMPASSWORD:
                groupOfComponents = new GroupOfConfirmPassword(component, errorLabel);
                break;
            case COMBOBOX:
                groupOfComponents = new GroupOfSignUpComboBox(component, errorLabel);
                break;
            case INFO:
                groupOfComponents = new GroupOfSignUpInfo(component, errorLabel);
                break;
        }
        return groupOfComponents;
    }
}
