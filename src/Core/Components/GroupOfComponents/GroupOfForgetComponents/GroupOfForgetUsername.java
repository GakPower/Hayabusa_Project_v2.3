package Core.Components.GroupOfComponents.GroupOfForgetComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfForgetUsername extends GroupOfComponents {

    public GroupOfForgetUsername(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
    }

    @Override
    public boolean isInputOK(String str){
        boolean result = true;
        if (component.inputIsNullOrEmpty()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if(!sqlControl.doesUserExists(getInput())){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Username does not exist... Please try again");
            result = false;
        }

        return result;
    }
}
