package Core.Components;

import com.jfoenix.controls.JFXTextField;

public class TextField implements Component {

    private JFXTextField textField;

    public TextField(JFXTextField textField) {
        this.textField = textField;
        banGreekCharacters();
    }

    private void banGreekCharacters(){
        this.textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσΤτΥυΦφΧχΨψΩω]")) {
                this.textField.setText(newValue.replaceAll("[ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσΤτΥυΦφΧχΨψΩω]", ""));
            }
        });
    }

    @Override
    public String getText() {
        return textField.getText();
    }

    @Override
    public void clearInput() {
        textField.clear();
    }

    @Override
    public void setText(String newText) {
        textField.setText(newText);
    }

    @Override
    public void setdisable(boolean disable) {
        textField.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return textField.getText() == null || textField.getText().isEmpty();
    }

    @Override
    public void setStyleClass(String style) {
        textField.getStyleClass().clear();
        textField.getStyleClass().add(style);
    }
}
