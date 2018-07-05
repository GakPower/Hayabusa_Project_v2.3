package Core.Components.ComponentFactories;

import Core.Components.Component;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.Components.GroupOfComponents.GroupOfConfirmPassword;
import Core.Components.GroupOfComponents.GroupOfForgetComponents.GroupOfForgetInfo;
import Core.Components.GroupOfComponents.GroupOfForgetComponents.GroupOfForgetPassword;
import Core.Components.GroupOfComponents.GroupOfForgetComponents.GroupOfForgetUsername;

public interface GroupForgetFactory {

    static GroupOfComponents createGroup(ComponentType type, Component component, ErrorLabel errorLabel) {
        GroupOfComponents groupOfComponents = null;
        switch(type) {
            case USERNAME:
                groupOfComponents = new GroupOfForgetUsername(component, errorLabel);
                break;
            case INFO:
                groupOfComponents = new GroupOfForgetInfo(component, errorLabel);
                break;
            case PASSWORD:
                groupOfComponents = new GroupOfForgetPassword(component, errorLabel);
                break;
            case CONFIRMPASSWORD:
                groupOfComponents = new GroupOfConfirmPassword(component, errorLabel);
                break;
        }
        return groupOfComponents;
    }
}
