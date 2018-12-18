package Core.Components.GroupOfComponents.GroupOfAppComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfDatePicker extends GroupOfComponents {
    public GroupOfDatePicker(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
        setMaxInputLength(500);
    }
}
