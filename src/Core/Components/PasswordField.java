package Core.Components;

import com.jfoenix.controls.JFXPasswordField;

public class PasswordField implements Component {

    private JFXPasswordField passwordField;

    public PasswordField(JFXPasswordField passwordField){
        this.passwordField = passwordField;
        banGreekCharacters();
    }

    private void banGreekCharacters(){
        this.passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσΤτΥυΦφΧχΨψΩω]")) {
                this.passwordField.setText(newValue.replaceAll("[ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσΤτΥυΦφΧχΨψΩω]", ""));
            }
        });
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
    public void setdisable(boolean disable) {
        passwordField.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return passwordField.getText() == null || passwordField.getText().isEmpty();
    }

    @Override
    public void setStyleClass(String style) {
        passwordField.getStyleClass().clear();
        passwordField.getStyleClass().add(style);
    }


}
