package Core.Components.ComponentFactories;

import Core.Components.Component;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.Components.GroupOfComponents.GroupType;

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
        }

        return groupOfComponents;
    }

}
