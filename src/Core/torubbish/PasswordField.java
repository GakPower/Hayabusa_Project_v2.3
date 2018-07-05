package Core.torubbish;
//
// Author: GakPower
// 
// Date: 22-Jun-2018 (9:15 PM)
//

import com.jfoenix.controls.JFXPasswordField;

public class PasswordField implements Component {

    private JFXPasswordField passwordField;

    public PasswordField(JFXPasswordField passwordField){
        this.passwordField = passwordField;
    }

    @Override
    public String getText() {
        return passwordField.getText();
    }

    @Override
    public void clearInput() {
        passwordField.clear();
    }

    @Override
    public void setText(String newText) {}

    @Override
    public boolean inputIsNullOrEmpty() {
        return passwordField.getText() == null || passwordField.getText().isEmpty();
    }

}
