package Core.Components.GroupOfComponents.GroupOfLoginComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfLoginPassword extends GroupOfComponents {

    public GroupOfLoginPassword(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
    }

    @Override
    public boolean isInputOK(String Username) {
        boolean result = true;
        if (component.inputIsNullOrEmpty()) {
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if (!sqlControl.isPasswordCorrect(Username, getInput())) {
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Invalid Username Password combination... Please try again");
            result = false;
        }
        return result;
    }
}
