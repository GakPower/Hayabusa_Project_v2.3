package Core.Components.GroupOfComponents.GroupOfAppComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfTimePicker extends GroupOfComponents {
    public GroupOfTimePicker(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
        setMaxInputLength(500);
    }
}
