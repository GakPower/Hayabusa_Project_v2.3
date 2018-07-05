package Core.Components.ComponentFactories;

import Core.Components.Component;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.Components.GroupOfComponents.GroupOfLoginComponents.GroupOfLoginPassword;
import Core.Components.GroupOfComponents.GroupOfLoginComponents.GroupOfLoginUsername;

public interface GroupLoginFactory {

    static GroupOfComponents createGroup(ComponentType type, Component component, ErrorLabel errorLabel) {
        GroupOfComponents groupOfComponents = null;
        switch (type) {
            case USERNAME:
                groupOfComponents = new GroupOfLoginUsername(component, errorLabel);
                break;
            case PASSWORD:
                groupOfComponents = new GroupOfLoginPassword(component, errorLabel);
                break;
        }
        return groupOfComponents;
    }
}
