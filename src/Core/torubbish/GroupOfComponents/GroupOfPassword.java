package Core.torubbish.GroupOfComponents;
//
// Author: GakPower
// 
// Date: 23-Jun-2018 (5:24 PM)
//

import Core.Components.GroupOfComponents.ErrorLabel;
import Core.torubbish.Component;

import java.sql.SQLException;

public class GroupOfPassword implements GroupOfComponents{

    private Component component;
    private ErrorLabel errorLabel;

    public GroupOfPassword(Component component, ErrorLabel errorLabel){
        this.component = component;
        this.errorLabel = errorLabel;
    }

    @Override
    public void hideErrorLabel() {
        errorLabel.hide();
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
    public boolean isLoginInputOK(String Username) {
        boolean result = true;
        if (component.inputIsNullOrEmpty()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if (!isPasswordCorrect(Username)){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Invalid Username Password combination..." +
                    " Please try again");
            result = false;
        }
        return result;
    }

    private boolean isPasswordCorrect(String Username){
        boolean result = false;
        try {
            result = tryIsPasswordCorrect(Username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    private boolean tryIsPasswordCorrect(String Username) throws SQLException {
        boolean result = false;
        sql.connDB();

        sql.execCommand("SELECT Password FROM Users WHERE Username=\'"+Username+"\';");
        if (sql.getResultSet().next()){
            String PasswordOnDB = sql.getResultSet().getString("Password");
            result = PasswordOnDB.equals(getInput());
        }

        sql.shutDB();
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
            errorLabel.setTooltipText("Invalid input! Input's length is more that "+getMaxInputLength()+" characters... Please try again");
            result = false;
        }
        return result;
    }

    @Override
    public boolean isForgetPassInputOK() {
        return false;
    }

    @Override
    public void setInput(String newText) {
        component.setText(newText);
    }

    private boolean isInputMoreThanMaxLength(){
        return getInput().length() > getMaxInputLength();
    }

    @Override
    public String getInput() {
        return component.getText();
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
