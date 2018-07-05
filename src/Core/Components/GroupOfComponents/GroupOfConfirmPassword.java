package Core.Components.GroupOfComponents;

import Core.Components.Component;

public class GroupOfConfirmPassword extends GroupOfComponents {
    public GroupOfConfirmPassword(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
    }

    @Override
    public boolean isInputOK(String Password) {
        boolean result = true;
        if(!getInput().equals(Password)){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid Input! Passwords do not match... Please try again");
            result = false;
        }
        return result;
    }
}
