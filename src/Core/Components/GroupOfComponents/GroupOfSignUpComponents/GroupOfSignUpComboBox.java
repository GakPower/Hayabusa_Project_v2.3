package Core.Components.GroupOfComponents.GroupOfSignUpComponents;

import Core.Components.ComboBox;
import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfSignUpComboBox extends GroupOfComponents {
    public GroupOfSignUpComboBox(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
        ComboBox comboBox = (ComboBox) component;
        comboBox.add("What was your favorite place to visit as a child?");
        comboBox.add("Who is your favorite actor, musician, or artist?");
        comboBox.add("What was the make of your first car?");
        comboBox.add("What is your favorite website?");
        comboBox.add("What is the name of your first grade teacher?");
        comboBox.add("What is your favorite movie?");

        setMaxInputLength(100);
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
