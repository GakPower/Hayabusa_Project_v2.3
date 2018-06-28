package Core.Components.GroupOfComponents;
//
// Author: GakPower
// 
// Date: 23-Jun-2018 (8:03 PM)
//

import Core.Components.Component;

public class GroupOfConfirmPassword implements GroupOfComponents {

    private Component component;
    private ErrorLabel errorLabel;
    private GroupOfPassword groupOfPassword;

    public GroupOfConfirmPassword(Component component, ErrorLabel errorLabel, GroupOfPassword groupOfPassword){
        this.component = component;
        this.errorLabel = errorLabel;
        this.groupOfPassword = groupOfPassword;
    }

    @Override
    public int getMaxInputLength() {
        return 20;
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
    public boolean isSingUpInputOK(String str) {
        boolean result = true;
        if(!getInput().equals(groupOfPassword.getInput())){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid Input! Passwords do not match... Please try again");
            result = false;
        }
        return result;
    }

    @Override
    public boolean isForgetPassInputOK() {
        return false;
    }

    @Override
    public boolean isLoginInputOK(String str) {
        return Boolean.parseBoolean(null);
    }

    @Override
    public String getInput() {
        return component.getText();
    }
}
