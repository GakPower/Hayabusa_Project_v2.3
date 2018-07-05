package Core.torubbish.GroupOfComponents;
//
// Author: GakPower
// 
// Date: 23-Jun-2018 (8:23 PM)
//

import Core.Components.GroupOfComponents.ErrorLabel;
import Core.torubbish.Component;

public class GroupOfInfo implements GroupOfComponents {

    private Component component;
    private ErrorLabel errorLabel;

    public GroupOfInfo(Component component, ErrorLabel errorLabel){
        this.component = component;
        this.errorLabel = errorLabel;
    }

    @Override
    public int getMaxInputLength() {
        return 50;
    }

    @Override
    public void clearInput() {
        component.clearInput();
    }

    @Override
    public void hideErrorLabel() {
        errorLabel.hide();
    }

    @Override
    public boolean isLoginInputOK(String str) {
        return Boolean.parseBoolean(null);
    }

    @Override
    public boolean isSingUpInputOK(String str) {
        boolean result = true;
        if (component.inputIsNullOrEmpty()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if (isInputMoreThanMaxLength()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input's length is more than "+getMaxInputLength()+"... Please try again");
            result = false;
        }
        return result;
    }

    @Override
    public boolean isForgetPassInputOK() {
        return false;
    }


    private boolean isInputMoreThanMaxLength(){
        return component.getText().length() > getMaxInputLength();
    }

    @Override
    public String getInput() {
        return component.getText();
    }

    public void setInput(String newText){
        component.setText(newText);
    }

    @Override
    public void showLabel() {
        errorLabel.show();
    }

    @Override
    public void hideLabel() {
        errorLabel.hide();
    }

    @Override
    public void setErrorLabelText(String newText) {
        errorLabel.setTooltipText(newText);
    }
}
