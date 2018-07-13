package Core.Components.GroupOfComponents.GroupOfForgetComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;

public class GroupOfForgetInfo extends GroupOfComponents {
    public GroupOfForgetInfo(Component component, ErrorLabel errorLabel) {
        super(component, errorLabel);
    }

    @Override
    public boolean isInputOK(String Question){
        boolean result = true;
        System.out.println(getInput());
        if (component.inputIsNullOrEmpty()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if (!getInput().equals(sqlControl.getAnswerForQuestion(Question))){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Wrong answer to question \""+Question+"\"... Please try again");
            result = false;
        }
        return result;
    }
}
