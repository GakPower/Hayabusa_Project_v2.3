package Core.Components.GroupOfComponents.GroupOfSignUpComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfSignUpInfo extends GroupOfComponents {
    public GroupOfSignUpInfo(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
    }

    @Override
    public boolean isInputOK(String str) {
        boolean result = true;
        if (component.inputIsNullOrEmpty()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if (isInputMoreThanMaxLength()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input's length is more than "+getMaxInputLength()+"... Please try again");
            result = false;
        }
        return result;
    }
}
