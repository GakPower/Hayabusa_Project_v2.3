package Core.Components.GroupOfComponents.GroupOfAppComponents.AddRemoveFields;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfAddInfo extends GroupOfComponents {
    public GroupOfAddInfo(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
    }

    @Override
    public boolean isInputOK(String str)
    {
        boolean result = true;
        if (component.inputIsNullOrEmpty()) {
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if ()
        return result;
    }

    private boolean isDublicate(String newField)
    {
        boolean result = true;

        return result;
    }
}
