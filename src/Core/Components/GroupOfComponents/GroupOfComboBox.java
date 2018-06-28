package Core.Components.GroupOfComponents;
//
// Author: GakPower
// 
// Date: 23-Jun-2018 (5:24 PM)
//

import Core.Components.Component;

public class GroupOfComboBox implements GroupOfComponents {

    private Component component;
    private ErrorLabel errorLabel;

    public GroupOfComboBox(Component component, ErrorLabel errorLabel){
        this.component = component;
        this.errorLabel = errorLabel;
    }

    @Override
    public int getMaxInputLength() {
        return 100;
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
            errorLabel.setTooltipText("Invalid Input! Input is empty... Please try again");
            result = false;
        }else if (isInputMoreThanMaxLength()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid Input! Input's length is more than "+getMaxInputLength()+"... Please try again");
            result = false;
        }
        return result;
    }

    @Override
    public boolean isForgetPassInputOK() {
        return Boolean.parseBoolean(null);
    }

    private boolean isInputMoreThanMaxLength(){
        return component.getText().length() > getMaxInputLength();
    }

    @Override
    public String getInput() {
        return component.getText();
    }
}
