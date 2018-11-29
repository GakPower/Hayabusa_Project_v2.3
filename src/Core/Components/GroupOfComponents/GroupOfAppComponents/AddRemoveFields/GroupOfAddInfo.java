package Core.Components.GroupOfComponents.GroupOfAppComponents.AddRemoveFields;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.ExtraFields.ExtraGroup;
import Core.ExtraFields.ExtraGroups;

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
        }else if(isDuplicate()){
            errorLabel.show();
            errorLabel.setTooltipText("Duplicate input! There already exists a field " +
                    "with this name... Please try again");
            result = false;
        }
        return result;
    }

    private boolean isDuplicate()
    {
        for (ExtraGroup extraGroup: ExtraGroups.extraGroups) {
            if (extraGroup.getGroupName().equals(component.getText())){
                return true;
            }
        }
        return false;
    }
}
