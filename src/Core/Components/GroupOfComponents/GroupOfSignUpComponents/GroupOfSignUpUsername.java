package Core.Components.GroupOfComponents.GroupOfSignUpComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfSignUpUsername extends GroupOfComponents {

    public GroupOfSignUpUsername(Component component, ErrorLabel errorLabel) {
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
            errorLabel.setTooltipText("Invalid input! Input's length is more that 30 characters... Please try again");
            result = false;
        }else if (sqlControl.doesUserExists(getInput())){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Username is already taken... Please try again");
            result = false;
        }
        return result;
    }
}
