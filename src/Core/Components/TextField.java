package Core.Components;

import com.jfoenix.controls.JFXTextField;

public class TextField implements Component {

    private JFXTextField textField;

    public TextField(JFXTextField textField) {
        this.textField = textField;
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
    public void setDisable(boolean disable) {
        textField.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return textField.getText() == null || textField.getText().isEmpty();
    }
}
