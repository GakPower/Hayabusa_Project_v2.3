package Core.Components;

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
    public void setDisable(boolean disable) {
        passwordField.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return passwordField.getText() == null || passwordField.getText().isEmpty();
    }
}
