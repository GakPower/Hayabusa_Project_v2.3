package Core.Components.GroupOfComponents;
//
// Author: GakPower
// 
// Date: 23-Jun-2018 (5:23 PM)
//

import Core.Components.Component;

import java.sql.SQLException;

public class GroupOfUsername implements GroupOfComponents {

    private Component component;
    private ErrorLabel errorLabel;

    public GroupOfUsername(Component component, ErrorLabel errorLabel){
        this.component = component;
        this.errorLabel = errorLabel;
    }

    @Override
    public int getMaxInputLength() {
        return maxInputLength;
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
        boolean result = true;
        if (component.inputIsNullOrEmpty()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }
        return result;
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
            errorLabel.setTooltipText("Invalid input! Input's length is more that 30 characters... Please try again");
            result = false;
        }else if (doesUserExists()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Username is already taken... Please try again");
            result = false;
        }
        return result;
    }
    private boolean isInputMoreThanMaxLength(){
        return getInput().length() > getMaxInputLength();
    }

    private boolean doesUserExists() {
        boolean result = false;
        try {
            result = tryDoesUserExists();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    private boolean tryDoesUserExists() throws SQLException {
        sql.connDB();

        sql.execCommand("SELECT Username FROM Users WHERE Username=\'"+getInput()+"\'");

        boolean result = sql.getResultSet().next();

        sql.shutDB();
        return result;
    }

    public boolean isForgetPassInputOK(){
        boolean result = true;
        if (component.inputIsNullOrEmpty()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if(!doesUserExists()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Username does not exist... Please try again");
            result = false;
        }

        return result;
    }

    @Override
    public String getInput() {
        return component.getText();
    }
}
