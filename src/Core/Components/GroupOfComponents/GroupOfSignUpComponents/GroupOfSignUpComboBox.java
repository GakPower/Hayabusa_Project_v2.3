package Core.Components.GroupOfComponents.GroupOfSignUpComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfSignUpComboBox extends GroupOfComponents {
    public GroupOfSignUpComboBox(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
    }

    @Override
    public boolean isInputOK(String str) {
        boolean result = true;
        if (component.inputIsNullOrEmpty()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid Input! Input is empty... Please try again");
            result = false;
        }else if (isInputMoreThanMaxLength()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid Input! Input's length is more than "+getMaxInputLength()+"... Please try again");
            result = false;
        }
        return result;
    }
}
